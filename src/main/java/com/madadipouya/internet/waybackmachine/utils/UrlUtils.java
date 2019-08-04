package com.madadipouya.internet.waybackmachine.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlUtils {

    private UrlUtils() {

    }

    public static URI toUri(String strUrl) throws MalformedURLException, URISyntaxException {
        URL url = new URL(strUrl);
        return new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
    }
}
