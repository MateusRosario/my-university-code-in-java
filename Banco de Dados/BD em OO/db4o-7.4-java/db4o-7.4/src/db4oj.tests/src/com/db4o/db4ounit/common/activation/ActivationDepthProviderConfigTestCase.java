/* Copyright (C) 2004 - 2008  db4objects Inc.  http://www.db4o.com

This file is part of the db4o open source object database.

db4o is free software; you can redistribute it and/or modify it under
the terms of version 2 of the GNU General Public License as published
by the Free Software Foundation and as clarified by db4objects' GPL 
interpretation policy, available at
http://www.db4o.com/about/company/legalpolicies/gplinterpretation/
Alternatively you can write to db4objects, Inc., 1900 S Norfolk Street,
Suite 350, San Mateo, CA 94403, USA.

db4o is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; without even the implied warranty of MERCHANTABILITY or
FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
for more details.

You should have received a copy of the GNU General Public License along
with this program; if not, write to the Free Software Foundation, Inc.,
59 Temple Place - Suite 330, Boston, MA  02111-1307, USA. */
package com.db4o.db4ounit.common.activation;

import com.db4o.config.*;
import com.db4o.internal.*;
import com.db4o.internal.activation.*;

import db4ounit.extensions.*;
import db4ounit.mocking.*;

/**
 * Ensures the container uses the provided ActivationDepthProvider instance
 * whenever necessary.
 */
public class ActivationDepthProviderConfigTestCase
	extends AbstractDb4oTestCase
	implements OptOutTA {
	
	public static final class ItemRoot {
		public Item root;
		
		public ItemRoot(Item root_) {
			this.root = root_;
		}
		
		public ItemRoot() {
		}
	}
	
	public static final class Item {
		public Item child;
		
		public Item() {
		}
		
		public Item(Item child_) {
			this.child = child_;
		}
	}
	
	private final MockActivationDepthProvider _dummyProvider = new MockActivationDepthProvider();
	
	protected void configure(Configuration config) throws Exception {
		((Config4Impl)config).activationDepthProvider(_dummyProvider);
	}
	
	protected void store() throws Exception {
		store(new ItemRoot(new Item(new Item(new Item()))));
	}
	
	public void testCSActivationDepthFor() {
		if (!isNetworkCS()) {
			return;
		}
		
		resetProvider();
		queryItem();
		assertProviderCalled(new MethodCall[] {
			new MethodCall("activationDepthFor", itemRootMetadata(), ActivationMode.PREFETCH),
			new MethodCall("activationDepthFor", itemRootMetadata(), ActivationMode.ACTIVATE),
		});
	}
	
	public void testSoloActivationDepthFor() {
		if (isNetworkCS()) {
			return;
		}
		resetProvider();
		queryItem();
		assertProviderCalled("activationDepthFor", itemRootMetadata(), ActivationMode.ACTIVATE);
	}

	public void testSpecificActivationDepth() {
		
		Item item = queryItem();		
		resetProvider();
		
		db().activate(item, 3);
		
		assertProviderCalled("activationDepth", new Integer(3), ActivationMode.ACTIVATE);
	}
	
	private boolean isNetworkCS() {
		return isClientServer() && !isMTOC();
	}

	private ClassMetadata itemRootMetadata() {
		return classMetadataFor(ItemRoot.class);
	}
	
	private void assertProviderCalled(MethodCall[] expectedCalls) {
		_dummyProvider.verify(expectedCalls);
	}
	
	private void assertProviderCalled(String methodName, Object arg1, Object arg2) {
		_dummyProvider.verify(new MethodCall[] {
			new MethodCall(methodName, arg1, arg2)
		});
	}

	private void resetProvider() {
		_dummyProvider.reset();
	}

	private Item queryItem() {
		return ((ItemRoot)retrieveOnlyInstance(ItemRoot.class)).root;
	}
}
