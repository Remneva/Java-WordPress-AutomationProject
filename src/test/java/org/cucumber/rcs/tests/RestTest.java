package org.cucumber.rcs.tests;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestTest {

    @Test
    public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
            throws ClientProtocolException, IOException, AssertionError {

        // Given
        String postId = RandomStringUtils.randomAlphabetic(5);
        HttpUriRequest request = new HttpGet("https://rotfront.su/wp-json/wp/v2/" + postId);

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void
    givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson()
            throws ClientProtocolException, IOException {

        // Given
        String jsonMimeType = "application/json";
        HttpUriRequest request = new HttpGet("https://rotfront.su/wp-json/wp/v2/36028");

        // When
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        // Then
        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals(jsonMimeType, mimeType);
    }

    @Test
    public void givenRequestWithNoAcceptHeader()
            throws ClientProtocolException, IOException {

        // Given
        String serverType = "nginx";
        HttpUriRequest request = new HttpGet("https://rotfront.su/wp-json/wp/v2/posts/36028");

        // When
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        // Then
        String responseServerType = response.getFirstHeader("Server").getValue();
        assertEquals(serverType, responseServerType);
    }

    @Test
    public void
    givenUserExists_whenUserInformationIsRetrieved()
            throws ClientProtocolException, IOException {

        // Given
        String title = "О скандальных заявлениях придворных &#171;коммунистов&#187;";
        HttpUriRequest request = new HttpGet("https://rotfront.su/wp-json/wp/v2/posts/36028");

        // When
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        // Then
        String responseJson = EntityUtils.toString(response.getEntity());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(responseJson);
        JsonNode actualTitleNode = node.get("title");
        String actualTitle;
        if (actualTitleNode != null) {
            actualTitle = actualTitleNode.get("rendered").asText();
            System.out.println(actualTitle);
        } else actualTitle = "";

        Assert.assertEquals(title, actualTitle);
    }
}
