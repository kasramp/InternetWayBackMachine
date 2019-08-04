package com.madadipouya.internet.waybackmachine.service.impl;

import com.madadipouya.internet.waybackmachine.service.InternetArchiveService;
import com.madadipouya.internet.waybackmachine.utils.UrlUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultInternetArchiveService implements InternetArchiveService {

    private static final int TIMEOUT_FIVE_SECONDS = 5000;

    private static final String WEB_ARCHIVE_SAVE_URL = "https://web.archive.org/save/%s";

    private static final String WEB_ARCHIVE_BASE_URL = "https://web.archive.org%s";

    @Override
    public void submit(String url) {
        getUri(url).ifPresent(uri -> {
            HttpGet request = new HttpGet(String.format(WEB_ARCHIVE_SAVE_URL, uri.toASCIIString()));
            try {
                HttpResponse response = getHttpClient().execute(request);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpStatus.SC_OK) {
                    System.out.println(String.format("Succeed. Link: [%s]", String.format(WEB_ARCHIVE_BASE_URL,
                            response.getHeaders("Content-Location")[0].getElements()[0].getName())));

                } else {
                    System.out.println(String.format("Failed to submit the URL, got %s response. Try again", statusCode));
                }
            } catch (IOException e) {
                System.out.println("Failed to connect to archive.org");
            }
        });
    }

    @Override
    public void submitBatch(List<String> urls) {
        urls.forEach(this::submit);
    }

    private Optional<URI> getUri(String url) {
        try {
            return Optional.of(UrlUtils.toUri(url));
        } catch (MalformedURLException | URISyntaxException badUrlException) {
            System.out.println("Invalid URL is provided!");
            return Optional.empty();
        }
    }

    private HttpClient getHttpClient() {
        RequestConfig.Builder requestBuilder = RequestConfig.custom();
        requestBuilder.setConnectTimeout(TIMEOUT_FIVE_SECONDS);
        requestBuilder.setConnectionRequestTimeout(TIMEOUT_FIVE_SECONDS);
        HttpClientBuilder builder = HttpClientBuilder.create();
        builder.setDefaultRequestConfig(requestBuilder.build());
        return builder.build();
    }
}
