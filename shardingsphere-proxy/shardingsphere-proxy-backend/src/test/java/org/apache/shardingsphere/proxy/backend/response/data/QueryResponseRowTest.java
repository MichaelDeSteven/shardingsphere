/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.proxy.backend.response.data;

import org.junit.Test;

import java.sql.Types;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public final class QueryResponseRowTest {
    
    @Test
    public void assertGetDataWhenQueryResponseCellsOfEmptyList() {
        QueryResponseRow queryResponseRow = new QueryResponseRow(Collections.emptyList());
        assertThat(queryResponseRow.getData(), is(Collections.emptyList()));
    }
    
    @Test
    public void assertGetDataWhenQueryResponseCellsPresent() {
        QueryResponseCell queryResponseCell1 = new QueryResponseCell(Types.INTEGER, 1);
        QueryResponseCell queryResponseCell2 = new QueryResponseCell(Types.VARCHAR, "column");
        QueryResponseRow queryResponseRow = new QueryResponseRow(Arrays.asList(queryResponseCell1, queryResponseCell2));
        assertThat(queryResponseRow.getData().size(), is(2));
        assertTrue(queryResponseRow.getData().containsAll(Arrays.asList(1, "column")));
    }
}
