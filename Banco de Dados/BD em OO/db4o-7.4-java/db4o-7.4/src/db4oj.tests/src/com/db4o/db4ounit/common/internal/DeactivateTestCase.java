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
package com.db4o.db4ounit.common.internal;

import com.db4o.ObjectSet;
import com.db4o.query.Query;

import db4ounit.Assert;
import db4ounit.extensions.AbstractDb4oTestCase;

public class DeactivateTestCase extends AbstractDb4oTestCase  {
	protected void store() throws Exception {
		db().set(new Item("foo", new Item("bar", null)));
	}
	
	public void test() {		
		Query query = newQuery();
		query.descend("_name").constrain("foo");
		
		ObjectSet results = query.execute();
		Assert.areEqual(1, results.size());
		
		Item item1 = (Item) results.next();	
		Item item2 = item1._child;
		
		Assert.isTrue(db().isActive(item1));
		Assert.isTrue(db().isActive(item2));
		
		db().deactivate(item1);
		
		Assert.isFalse(db().isActive(item1));
		Assert.isTrue(db().isActive(item2));
	}
	
	public static void main(String []args) {
		new DeactivateTestCase().runAll();
	}
	
	public class Item {
		public Item _child;
		public String _name;
		
		public Item(String name, Item child) {
			_name = name;
			_child = child;
		}
	}
}
