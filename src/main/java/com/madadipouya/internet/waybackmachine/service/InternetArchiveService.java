package com.madadipouya.internet.waybackmachine.service;

import java.util.List;

public interface InternetArchiveService {

    /**
     * Submits a url web.archive.org
     * @param url to submit
     */
    void submit(String url);

    /**
     * Submits a batch of urls to web.archive.org
     * @param urls to submit
     */
    void submitBatch(List<String> urls);

    /**
     * Submits all the provided urls in a file to web.archive.org
     * @param filePath where the file consists of urls stored
     */
    void submitFile(String filePath);
}
