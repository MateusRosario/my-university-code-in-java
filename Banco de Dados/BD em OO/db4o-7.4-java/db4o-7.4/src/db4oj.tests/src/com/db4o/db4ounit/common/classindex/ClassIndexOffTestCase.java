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
package com.db4o.db4ounit.common.classindex;

import com.db4o.config.*;
import com.db4o.ext.*;
import com.db4o.query.*;

import db4ounit.*;
import db4ounit.extensions.*;
import db4ounit.extensions.fixtures.*;

public class ClassIndexOffTestCase extends AbstractDb4oTestCase implements OptOutCS{
    
    static String NAME = "1";
    
    public static class Holder {
        
        public Item _item;
        
        public Item _nullItem;
        
        public Holder(Item item){
            _item = item;
        }
    }
	
	public static class Item {
	    
		public String _name;

		public Item(String name) {
			_name = name;
		}
	}
	
	public static void main(String[] args) {
		new ClassIndexOffTestCase().runSolo();
	}
	
	protected void configure(Configuration config) throws Exception {
		super.configure(config);
		config.objectClass(Item.class).indexed(false);
	}
	
	protected void store() throws Exception {
        Item item = new Item(NAME);
        store(new Holder(item));
	}
	
	public void testNoItemInIndex(){
		
		StoredClass storedClass = db().storedClass(Item.class);
		Assert.isFalse(storedClass.hasClassIndex());
		
		assertNoItemFoundByQuery();
		
		db().commit();
		assertNoItemFoundByQuery();
	}
	
	private void assertNoItemFoundByQuery(){
		Query q = db().query();
		q.constrain(Item.class);
		Assert.areEqual(0, q.execute().size());
	}
	
	public void testRetrievalThroughHolder(){
	    assertData();
	}

    private void assertData() {
        Holder holder = (Holder) retrieveOnlyInstance(Holder.class);
	    Assert.isNotNull(holder._item);
	    Assert.areEqual(NAME, holder._item._name);
    }
	
	public void testDefragment() throws Exception{
	    defragment();
	    assertData();
	}

}
