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

import static com.hp.hpl.jena.graph.NodeFactory.createURI;
import static com.hp.hpl.jena.graph.Triple.create;
import static org.apache.http.HttpStatus.SC_OK;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.rdf.model.Model;

/**
 *
 * @author longshousitu
 *
 */
public class FedoraRepositoryImplTest {

    @Mock
    FedoraRepositoryImpl mockRepoImpl;

    @Mock
    HttpClient mockClient;

    @Mock
    private HttpResponse mockResponse;

    @Mock
    private HttpEntity mockEntity;

    @Mock
    private StatusLine mockStatusLine;

    @Mock
    private FedoraObjectImpl mockObject;

    @Mock
    private Model mockModel;

    private final String testContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"" +
                " xmlns:fcrepo=\"http://fedora.info/definitions/v4/repository#\">" +
                "<rdf:Description rdf:about=\"http://localhost:8080/rest/testObject\">" +
                "<rdf:type rdf:resource=\"http://fedora.info/definitions/v4/rest-api#resource\"/>" +
                "<rdf:type rdf:resource=\"http://fedora.info/definitions/v4/rest-api#object\"/>" +
                "<fcrepo:uuid>2fb9c440-db63-434f-929b-0ff29253205c</fcrepo:uuid>" +
                "</rdf:description>" +
                "</rdf:RDF>";
    private final Triple testTriple =
            create(createURI("info:test"), createURI("info:test"),
                    createURI("info:test"));


    @Before
    public void setUp() throws IOException {
        initMocks(this);
        when(mockClient.execute(any(HttpUriRequest.class))).thenReturn(mockResponse);
        when(mockResponse.getEntity()).thenReturn(mockEntity);
        when(mockResponse.getStatusLine()).thenReturn(mockStatusLine);
    }

    @Test
    public void testGetObject() throws IOException {
        final String testId = "testGetObject";

        mockModel.add(mockModel.asStatement(testTriple));
        when(mockStatusLine.getStatusCode()).thenReturn(SC_OK);
        try (
            InputStream rdf =
                new ByteArrayInputStream(testContent.getBytes())) {
            when(mockEntity.getContent()).thenReturn(rdf);
        }
    }
}
