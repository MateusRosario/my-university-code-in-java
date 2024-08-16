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
package com.db4o.internal.cluster;

import java.util.*;

import com.db4o.*;
import com.db4o.cluster.Cluster;
import com.db4o.foundation.*;
import com.db4o.internal.query.*;
import com.db4o.query.*;

/**
 * 
 * @exclude
 */
public class ClusterQuery implements Query{
    
    private final Cluster _cluster;
    private final Query[] _queries;
    
    public ClusterQuery(Cluster cluster, Query[] queries){
        _cluster = cluster;
        _queries = queries;
    }

    public Constraint constrain(Object constraint) {
        synchronized(_cluster){
            Constraint[] constraints = new Constraint[_queries.length];
            for (int i = 0; i < constraints.length; i++) {
                constraints[i] = _queries[i].constrain(constraint);
            }
            return new ClusterConstraint(_cluster, constraints);
        }
    }

    public Constraints constraints() {
        synchronized(_cluster){
            Constraint[] constraints = new Constraint[_queries.length];
            for (int i = 0; i < constraints.length; i++) {
                constraints[i] = _queries[i].constraints();
            }
            return new ClusterConstraints(_cluster, constraints);
        }
    }

    public Query descend(String fieldName) {
        synchronized(_cluster){
            Query[] queries = new Query[_queries.length];
            for (int i = 0; i < queries.length; i++) {
                queries[i] = _queries[i].descend(fieldName);
            }
            return new ClusterQuery(_cluster, queries);
        }
    }

    public ObjectSet execute() {
        synchronized(_cluster){
            return new ObjectSetFacade(new ClusterQueryResult(_cluster, _queries)); 
        }
    }

    public Query orderAscending() {
        throw new NotSupportedException();
    }

    public Query orderDescending() {
    	throw new NotSupportedException();
    }

	public Query sortBy(QueryComparator comparator) {
		// FIXME
		throw new NotSupportedException();
	}

	/**
	 * @decaf.ignore.jdk11
	 */
	public Query sortBy(Comparator comparator) {
		// FIXME
		throw new NotSupportedException();
	}
}
