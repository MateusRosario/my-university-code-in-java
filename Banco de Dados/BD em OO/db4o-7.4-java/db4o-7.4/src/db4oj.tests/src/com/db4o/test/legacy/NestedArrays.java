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
package com.db4o.test.legacy;

import java.io.*;

import com.db4o.*;
import com.db4o.test.*;


public class NestedArrays {
    
    public Object _object;
    
    public Object[] _objectArray;
    
    private static final int DEPTH = 5;
    
    private static final int ELEMENTS = 3;
    
    private static final String FILE = "nestedArrays.yap";
    
    
    public NestedArrays(){
        
    }
    
    
    public static void main(String[] arguments) {
        
        new File(FILE).delete();
        ObjectContainer oc = Db4o.openFile(FILE);
        NestedArrays nr = new NestedArrays();
        nr.storeOne();
        
        long storeStart = System.currentTimeMillis();
        oc.store(nr);
        long storeStop = System.currentTimeMillis();
        oc.commit();
        long commitStop = System.currentTimeMillis();
        
        oc.close();
        Db4o.configure().activationDepth(0);
        oc = Db4o.openFile(FILE);
        long loadStart = System.currentTimeMillis();
        nr = (NestedArrays)oc.queryByExample(new NestedArrays()).next();
        oc.activate(nr, Integer.MAX_VALUE);
        long loadStop = System.currentTimeMillis();
        
        oc.close();
        
        long store = storeStop - storeStart;
        long commit = commitStop - storeStop;
        long load = loadStop - loadStart;
        
        System.out.println(Db4o.version() +  " running com.db4o.test.NestedArrays");
        System.out.println("store: " + store + "ms");
        System.out.println("commit: " + commit + "ms");
        System.out.println("load: " + load + "ms");
        
    }
    
    
    public void storeOne(){
        
        _object = new Object[ELEMENTS];
        fill((Object[])_object, DEPTH);
        
        _objectArray = new Object[ELEMENTS];
        fill(_objectArray, DEPTH);
    }
    
    private void fill(Object[] arr, int depth){
        
        if(depth <= 0){
            arr[0] = "somestring";
            arr[1] = new Integer(10);
            return;
        }
        
        depth --;
        
        for (int i = 0; i < ELEMENTS; i++) {
            arr[i] = new Object[ELEMENTS];
            fill((Object[])arr[i], depth );
        }
    }
    
    public void testOne(){
        Test.objectContainer().activate(this, Integer.MAX_VALUE);
        
        check((Object[])_object, DEPTH);
        
        check((Object[])_objectArray, DEPTH);
        
        
    }
    
    private void check(Object[] arr, int depth){
        if(depth <= 0){
            Test.ensure(arr[0].equals("somestring"));
            Test.ensure(arr[1].equals(new Integer(10)));
            return;
        }
        
        depth --;
        
        for (int i = 0; i < ELEMENTS; i++) {
            check((Object[])arr[i], depth );
        }
        
    }
    
}
