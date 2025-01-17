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
package com.db4o.db4ounit.common.querying;


import com.db4o.config.*;
import com.db4o.db4ounit.common.btree.*;
import com.db4o.db4ounit.common.foundation.*;
import com.db4o.foundation.*;
import com.db4o.internal.*;
import com.db4o.internal.query.processor.*;
import com.db4o.internal.query.result.*;
import com.db4o.query.*;

import db4ounit.extensions.*;
import db4ounit.extensions.fixtures.*;


public abstract class QueryResultTestCase extends AbstractDb4oTestCase implements OptOutCS, OptOutDefragSolo {
	
	private static final int[] VALUES = new int[] { 1 , 5, 6 , 7, 9};
	
	private final int [] itemIds = new int[VALUES.length];
	
	private int idForGetAll;
	
	
	protected void configure(Configuration config) {
		indexField(config, Item.class, "foo");
	}
	
	public void testClassQuery(){
		assertIDs(classOnlyQuery(), itemIds);
	}
	
	public void testGetAll(){
		AbstractQueryResult queryResult = newQueryResult();
		queryResult.loadFromClassIndexes(container().classCollection().iterator());
		int[] ids = IntArrays4.concat(itemIds, new int[] {idForGetAll});
		assertIDs(queryResult, ids, true);
	}
	
	public void testIndexedFieldQuery(){
		Query query = newItemQuery();
		query.descend("foo").constrain(new Integer(6)).smaller();
		QueryResult queryResult = executeQuery(query);
		assertIDs(queryResult, new int[] {itemIds[0], itemIds[1] });
	}
	
	public void testNonIndexedFieldQuery(){
		Query query = newItemQuery();
		query.descend("bar").constrain(new Integer(6)).smaller();
		QueryResult queryResult = executeQuery(query);
		assertIDs(queryResult, new int[] {itemIds[0], itemIds[1] });
	}
	
	private QueryResult classOnlyQuery() {
		AbstractQueryResult queryResult = newQueryResult();
		queryResult.loadFromClassIndex(yapClass());
		return queryResult;
	}

	private ClassMetadata yapClass() {
		return classMetadataFor(Item.class);
	}

	private QueryResult executeQuery(Query query) {
		AbstractQueryResult queryResult = newQueryResult();
		queryResult.loadFromQuery((QQuery)query);
		return queryResult;
	}
	
	private void assertIDs(QueryResult queryResult, int[] expectedIDs){
		assertIDs(queryResult, expectedIDs, false);
	}
	
	private void assertIDs(QueryResult queryResult, int[] expectedIDs, boolean ignoreUnexpected){
		ExpectingVisitor expectingVisitor = new ExpectingVisitor(IntArrays4.toObjectArray(expectedIDs), false, ignoreUnexpected);
		IntIterator4 i = queryResult.iterateIDs();
		while(i.moveNext()){
			expectingVisitor.visit(new Integer(i.currentInt()));
		}
		expectingVisitor.assertExpectations();
	}
	
	protected Query newItemQuery() {
		return newQuery(Item.class);
	}

	protected void store() throws Exception {
		storeItems(VALUES);
		ItemForGetAll ifga = new ItemForGetAll();
		store(ifga);
		idForGetAll = (int)db().getID(ifga);
	}
	
	protected void storeItems(final int[] foos) {
		for (int i = 0; i < foos.length; i++) {
			Item item = new Item(foos[i]); 
			store(item);
			itemIds[i] = (int)db().getID(item);
	    }
	}
	
	public static class Item {
		
		public int foo;
		
		public int bar;
		
		public Item() {
			
		}
		
		public Item(int foo_) {
			foo = foo_;
			bar = foo;
		}
		
	}
	
	public static class ItemForGetAll {
		
	}
	
	protected abstract AbstractQueryResult newQueryResult();
	
}
