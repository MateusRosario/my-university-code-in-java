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
package com.db4o.db4ounit.common.handlers;

import com.db4o.*;
import com.db4o.internal.*;
import com.db4o.marshall.*;
import com.db4o.typehandlers.*;


public class MockWriteContext extends MockMarshallingContext implements WriteContext{

    public MockWriteContext(ObjectContainer objectContainer) {
        super(objectContainer);
    }
    
    public void writeObject(TypeHandler4 handler, Object obj) {
        handler.write(this, obj);
    }

    public void writeAny(Object obj) {
        ClassMetadata classMetadata = container().classMetadataForObject(obj);
        writeInt(classMetadata.getID());
        classMetadata.write(this, obj);
    }

    public ReservedBuffer reserve(int length) {
        ReservedBuffer reservedBuffer = new ReservedBuffer() {
            private final int reservedOffset = offset();
            public void writeBytes(byte[] bytes) {
                int currentOffset = offset();
                seek(reservedOffset);
                MockWriteContext.this.writeBytes(bytes);
                seek(currentOffset);
            }
        };
        seek(offset() + length );
        return reservedBuffer;
    }
    
}
