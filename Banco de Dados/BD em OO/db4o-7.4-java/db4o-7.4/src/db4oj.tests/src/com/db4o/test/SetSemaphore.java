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
package com.db4o.test;

import com.db4o.ext.*;
import com.db4o.foundation.*;

public class SetSemaphore {

    public void _test() throws InterruptedException {
    	
    	final ExtObjectContainer[] clients = new ExtObjectContainer[5];

        clients[0] = Test.objectContainer();

        Test.ensure(clients[0].setSemaphore("hi", 0));
        Test.ensure(clients[0].setSemaphore("hi", 0));

        if (Test.clientServer) {
        	for (int i = 1; i < clients.length; i++) {
				clients[i] = Test.open();
			}
        	

            Test.ensure(!clients[1].setSemaphore("hi", 0));
            clients[0].releaseSemaphore("hi");
            Test.ensure(clients[1].setSemaphore("hi", 50));
            Test.ensure(!clients[0].setSemaphore("hi", 0));
            Test.ensure(!clients[2].setSemaphore("hi", 0));
            
            
            Thread[] threads = new Thread[clients.length];
            
            for (int i = 0; i < clients.length; i++) {
            	threads[i] = startGetAndReleaseThread(clients[i]);
			}
            
            for (int i = 0; i < threads.length; i++) {
            	threads[i].join();
			}
            
            Cool.sleepIgnoringInterruption(50);

            Test.ensure(clients[0].setSemaphore("hi", 0));
            clients[0].close();
            
            threads[2] = startGetAndReleaseThread(clients[2]);
            threads[1] = startGetAndReleaseThread(clients[1]);
            
            threads[1].join();
            threads[2].join();
            
            for (int i = 1; i < 4; i++) {
            	clients[i].close();	
			}
            
            clients[4].setSemaphore("hi", 1000);
        }

    }
    
    private Thread startGetAndReleaseThread(ExtObjectContainer client) {
    	Thread t = new Thread(new GetAndRelease(client));
    	t.start();
    	return t;
    }

    static class GetAndRelease implements Runnable {

        ExtObjectContainer _client;

        public GetAndRelease(ExtObjectContainer client) {
            this._client = client;
        }

        public void run() {
            long time = System.currentTimeMillis();
            Test.ensure(_client.setSemaphore("hi", 50000));
            time = System.currentTimeMillis() - time;
            // System.out.println("Time to get semaphore: " + time);
            Cool.sleepIgnoringInterruption(50);

            // System.out.println("About to release semaphore.");
            _client.releaseSemaphore("hi");
        }
    }

}
