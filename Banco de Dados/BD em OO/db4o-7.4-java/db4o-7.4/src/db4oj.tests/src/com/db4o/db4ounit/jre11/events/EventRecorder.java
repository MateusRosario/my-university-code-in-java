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
package com.db4o.db4ounit.jre11.events;

import java.util.Vector;

import com.db4o.events.*;

public class EventRecorder implements EventListener4 {
	
	private final Object _lock;
	
	private static final long TIMEOUT = 10000; // 10 seconds
	
	private final Vector _events = new Vector();
	
	private boolean _cancel;
	
	public EventRecorder(Object lock_){
		_lock = lock_;
	}
	
	public String toString() {
		return _events.toString();
	}
	
	public void onEvent(Event4 e, EventArgs args) {
		synchronized(_lock){
			if (_cancel && args instanceof CancellableEventArgs) {
				((CancellableEventArgs)args).cancel();
			}
			_events.addElement(new EventRecord(e, args));
			_lock.notifyAll();
		}
	}

	public int size() {
		synchronized(_lock){
			return _events.size();
		}
	}

	public EventRecord get(int index) {
		return (EventRecord)_events.elementAt(index);
	}

	public void clear() {
        _events.removeAllElements();
	}

	public void cancel(boolean flag) {
		_cancel = flag;
	}
	
	public void waitForEventCount(int count){
		synchronized(_lock){
			long startTime = System.currentTimeMillis();
			while(size() < count){
				try {
					_lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				long currentTime = System.currentTimeMillis();
				long duration = currentTime - startTime;
				if(duration > TIMEOUT){
					throw new RuntimeException("EventRecorder timed out waiting for " + count + " events to happen.");
				}
			}
		}
	}
	
}