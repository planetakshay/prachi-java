package practice2023.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class AtlassianRest {

    public void executeGet() {
        String url = "someurl";
        try {
            URI uri = new URI(url);

            HttpRequest httpRequest = HttpRequest.newBuilder().uri(uri).GET().header("Accept", "application/json").build();
            HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(60)).version(HttpClient.Version.HTTP_2).build();

            HttpResponse response = httpClient.send(httpRequest, null);
            if(response.statusCode() == 200) {
                Object bodyObj = response.body();
                String body = String.valueOf(bodyObj);

            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
