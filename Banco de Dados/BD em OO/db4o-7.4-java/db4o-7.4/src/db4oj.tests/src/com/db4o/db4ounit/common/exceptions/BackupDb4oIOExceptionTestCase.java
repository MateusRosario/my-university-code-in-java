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
package com.db4o.db4ounit.common.exceptions;

import com.db4o.ext.*;
import com.db4o.foundation.io.*;

import db4ounit.*;

public class BackupDb4oIOExceptionTestCase extends Db4oIOExceptionTestCaseBase {
	
	public static void main(String[] args) {
		new BackupDb4oIOExceptionTestCase().runAll();
	}
	
	private static final String BACKUP_FILE = "backup.db4o";

	protected void db4oSetupBeforeStore() throws Exception {
		super.db4oSetupBeforeStore();
		File4.delete(BACKUP_FILE);
	}

	protected void db4oTearDownBeforeClean() throws Exception {
		super.db4oTearDownBeforeClean();
		File4.delete(BACKUP_FILE);
	}
	
	public void testBackup() {
		Assert.expect(Db4oIOException.class, new CodeBlock() {
			public void run() throws Throwable {
				ExceptionIOAdapter.exception = true;
				db().backup(BACKUP_FILE);
			}
		});
	}
	
}
