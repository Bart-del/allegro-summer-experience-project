package pl.bartdel.allegrosummerexperience.api;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

@SpringBootTest
public class GitHubDataControllerTest {

    @Test
    public void whenUserDoesNotExistReturn404() throws IOException {
        String user = RandomStringUtils.randomAlphabetic( 8 );
        HttpUriRequest request = new HttpGet("https://api.github.com/users/" + user + "/repos");

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void whenRequestIsExecutedDefaultResponseMediaTypeIsJSON() throws IOException {

        String jsonMimeType = "application/json";
        HttpUriRequest request = new HttpGet( "https://api.github.com/users/Bart-del/repos" );

        HttpResponse response = HttpClientBuilder.create().build().execute( request );

        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals( jsonMimeType, mimeType );
    }
}
