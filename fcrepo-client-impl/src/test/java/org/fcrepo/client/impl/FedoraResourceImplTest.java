/**
 * Copyright 2014 DuraSpace, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fcrepo.client.impl;

import static org.mockito.MockitoAnnotations.initMocks;

import java.io.IOException;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.hp.hpl.jena.graph.Triple;

/**
 *
 * @author longshousitu
 *
 */
public class FedoraResourceImplTest {

    @Mock
    FedoraRepositoryImpl mockRepoImpl;

    @Mock
    private Iterator<Triple> mockTriples;

    @Before
    public void setUp() throws IOException {
        initMocks(this);

    }

    @Test
    public void testGetName() throws IOException {

    }
}
