/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package javax.sql.rowset;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.RowSet;

public interface WebRowSet extends CachedRowSet, Joinable, ResultSet, RowSet {
    String PUBLIC_XML_SCHEMA = "--//Sun Microsystems, Inc.//XSD Schema//EN"; //$NON-NLS-1$

    String SCHEMA_SYSTEM_ID = "http://java.sun.com/xml/ns/jdbc/webrowset.xsd"; //$NON-NLS-1$

    void readXml(Reader reader) throws SQLException;

    void readXml(InputStream iStream) throws SQLException, IOException;

    void writeXml(ResultSet rs, Writer writer) throws SQLException;

    void writeXml(ResultSet rs, OutputStream oStream) throws SQLException,
            IOException;

    void writeXml(Writer writer) throws SQLException;

    void writeXml(OutputStream oStream) throws SQLException, IOException;
}
