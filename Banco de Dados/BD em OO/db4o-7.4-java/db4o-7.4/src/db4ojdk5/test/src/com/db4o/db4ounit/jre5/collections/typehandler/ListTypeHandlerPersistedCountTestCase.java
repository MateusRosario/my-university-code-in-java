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
package com.db4o.db4ounit.jre5.collections.typehandler;

import java.util.*;

import com.db4o.config.*;
import com.db4o.typehandlers.*;

import db4ounit.extensions.*;


public class ListTypeHandlerPersistedCountTestCase extends AbstractDb4oTestCase{

    public static void main(String[] args) {
        new ListTypeHandlerPersistedCountTestCase().runAll();
    }
    
    public static class TypedItem {
        
        ArrayList list;
        
    }
    
    public static class InterfaceItem {
        
        List list;
        
    }
    
    public static class UntypedItem {
        
        Object list;
        
    }
    
    protected void configure(Configuration config) throws Exception {
        config.registerTypeHandler(
            new SingleClassTypeHandlerPredicate(ArrayList.class), 
            new ListTypeHandler());
    }
    
    public void testTypedItem(){
        TypedItem typedItem = new TypedItem();
        typedItem.list = new ArrayList();
        store(typedItem);
        Db4oAssert.persistedCount(1, ArrayList.class);
    }
    
    public void testInterFaceItem(){
        InterfaceItem interfaceItem = new InterfaceItem();
        interfaceItem.list = new ArrayList();
        store(interfaceItem);
        Db4oAssert.persistedCount(1, ArrayList.class);
    }
    
    public void testUntypedItem(){
        UntypedItem untypedItem = new UntypedItem();
        untypedItem.list = new ArrayList();
        store(untypedItem);
        Db4oAssert.persistedCount(1, ArrayList.class);
    }
    
}
