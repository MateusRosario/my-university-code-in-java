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
package com.db4o.db4ounit.common.assorted;

import com.db4o.*;
import com.db4o.config.*;
import com.db4o.ext.*;
import com.db4o.internal.*;
import com.db4o.query.*;

import db4ounit.*;
import db4ounit.extensions.*;


public class LazyObjectReferenceTestCase extends AbstractDb4oTestCase{
	
	public static void main(String[] arguments) {
		new LazyObjectReferenceTestCase().runSolo();
	}
	
	public static class Item {
		
	}
	
	protected void configure(Configuration config) throws Exception {
		super.configure(config);
		config.objectClass(Item.class).generateUUIDs(true);
	}
	
	protected void store() throws Exception {
		for (int i = 0; i < 10; i++) {
			store(new Item());
		}
	}
	
	public void test(){
		Query q = db().query();
		q.constrain(Item.class);
		ObjectSet objectSet = q.execute();
		long[]ids = objectSet.ext().getIDs();
		
		ObjectInfo[] infos = new ObjectInfo[ids.length];
		Item[] items = new Item[ids.length];
		
		for (int i = 0; i < items.length; i++) {
			items[i] = (Item) db().getByID(ids[i]);
			infos[i] = new LazyObjectReference(trans(), (int)ids[i]);
		}
		
		assertInfosAreConsistent(ids, infos);
		
		for (int i = 0; i < items.length; i++) {
			db().purge(items[i]);
		}
		
		db().purge();
		
		assertInfosAreConsistent(ids, infos);
		
	}

	private void assertInfosAreConsistent(long[] ids, ObjectInfo[] infos) {
		for (int i = 0; i < infos.length; i++) {
			ObjectInfo info = db().getObjectInfo(db().getByID(ids[i]));
			Assert.areEqual(info.getInternalID(), infos[i].getInternalID());
			Assert.areEqual(info.getUUID().getLongPart(), infos[i].getUUID().getLongPart());
			Assert.areSame(info.getObject(), infos[i].getObject());
		}
	}
	
	

}
