package org.cucumber.rcs.tests;

import com.sun.net.httpserver.HttpsParameters;
import org.apache.http.HttpConnection;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NoHttpResponseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


import javax.ws.rs.core.Cookie;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;

public class CookieTest {

    @Test
    public void authentBasic() throws IOException {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials
                = new UsernamePasswordCredentials("devel", "rotfront");
        provider.setCredentials(AuthScope.ANY, credentials);

        BasicCookieStore cookieStore = new BasicCookieStore();
        BasicClientCookie cookie = new BasicClientCookie("wordpress_logged_in_5ae9a77047750402d8a084f3d3c26ec4", " ");
        cookie.setDomain(".rotfront.org");
        cookie.setPath("/");
        cookieStore.addCookie(cookie);
        BasicClientCookie cookie2 = new BasicClientCookie("wordpress_sec_5ae9a77047750402d8a084f3d3c26ec4", " ");
        cookie2.setDomain(".rotfront.org");
        cookie2.setPath("/");
        cookieStore.addCookie(cookie2);
        BasicClientCookie cookie3 = new BasicClientCookie("PHPSESSID", "2ktnc7d34320qok3mdb7jpu4f1");
        cookie3.setDomain(".rotfront.org");
        cookie3.setPath("/");
        cookieStore.addCookie(cookie3);

        HttpClient client = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .setDefaultCookieStore(cookieStore)
                .build();

        HttpDelete request = new HttpDelete("https://rotfront.org/wp-json/wp/v2/posts/36084");
        request.setConfig(RequestConfig.custom()
                .setConnectTimeout(60000)
                .build());
        request.setHeader("Content-type","application/json");

        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine()
                .getStatusCode();

        Assert.assertThat(statusCode,
                equalTo(HttpStatus.SC_OK));

    }
}