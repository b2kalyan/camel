/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.converter.stream;

import java.io.ByteArrayOutputStream;

import org.apache.camel.ContextTestSupport;
import org.junit.Test;

/**
 * @version 
 */
public class SourceCacheTest extends ContextTestSupport {

    @Test
    public void testSourceCache() throws Exception {
        SourceCache cache = new SourceCache("<foo>bar</foo>");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        cache.writeTo(bos);

        String s = context.getTypeConverter().convertTo(String.class, bos);
        assertEquals("<foo>bar</foo>", s);

        cache.reset();

        s = context.getTypeConverter().convertTo(String.class, cache);
        assertEquals("<foo>bar</foo>", s);
    }

}