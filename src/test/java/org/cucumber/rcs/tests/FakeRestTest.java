package org.cucumber.rcs.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FakeRestTest {

    @Test
    public void givenFakeResourses()
            throws ClientProtocolException, IOException {

        // Given
        StringEntity entity = new StringEntity("{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }",
                ContentType.create("application/json", "UTF-8"));
        HttpPost httpPostRequest = new HttpPost("https://jsonplaceholder.typicode.com/posts");
        httpPostRequest.setEntity(entity);

        // When
        HttpResponse response = HttpClientBuilder.create().build().execute(httpPostRequest);

        // Then
        String responseJson = EntityUtils.toString(response.getEntity());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(responseJson);
        JsonNode requestIDNode = node.get("id");
        int requestID;
        if (requestIDNode != null) {
            requestID = requestIDNode.asInt();
            System.out.println(requestID);
        } else requestID = 10110101;

        Assert.assertNotNull(requestID);
    }


}
