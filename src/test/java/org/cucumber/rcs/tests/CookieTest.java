package org.cucumber.rcs.tests;

import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.junit.jupiter.api.Test;


import java.io.IOException;


public class CookieTest {

    @Test
    public void authentBasic() throws IOException {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials
                = new UsernamePasswordCredentials("", "");
        provider.setCredentials(AuthScope.ANY, credentials);

        BasicCookieStore cookieStore = new BasicCookieStore();
        BasicClientCookie cookie = new BasicClientCookie("wordpress_logged_in_5ae9a77047750402d8a084f3d3c26ec4", "taranov%7C1540829314%7Ce9bQ7B40BzmXU9zRcxIl3Z5yyqqAFwDbZ2Q8qfbzvrc%7C7fa6f9254962b88b3477cc7b02427eb91c7a2bff919a55bebe78f32030617ce0");
        cookie.setDomain(".rotfront.org");
        cookie.setPath("/");
        cookieStore.addCookie(cookie);


        HttpClient client = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .setDefaultCookieStore(cookieStore)
                .build();

        HttpDelete request = new HttpDelete("");
        request.setConfig(RequestConfig.custom()
                .setConnectTimeout(60000)
                .build());
        request.setHeader("Content-type","application/json");
        try{
        HttpResponse response = client.execute(request);}
        catch (NoHttpResponseException e){
            System.out.println(e.getMessage());
        }
//        int statusCode = response.getStatusLine()
//                .getStatusCode();
//
//        Assert.assertThat(statusCode,
//                equalTo(HttpStatus.SC_OK));

    }
}