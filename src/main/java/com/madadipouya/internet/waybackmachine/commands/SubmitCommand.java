package com.madadipouya.internet.waybackmachine.commands;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.madadipouya.internet.waybackmachine.service.InternetArchiveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.IOException;
import java.util.List;

@ShellCommandGroup("URL submission commands to 'http://archive.org/'")
@ShellComponent
public class SubmitCommand {

    private static final Logger logger = LoggerFactory.getLogger(SubmitCommand.class);

    private final ObjectMapper objectMapper;

    private final InternetArchiveService internetArchiveService;

    public SubmitCommand(InternetArchiveService internetArchiveService, ObjectMapper objectMapper) {
        this.internetArchiveService = internetArchiveService;
        this.objectMapper = objectMapper;
    }


    @ShellMethod(value = "Saves a URL, example `save \"https://google.com\"`", key = "save")
    public void submitUrl(@ShellOption String url) {
        internetArchiveService.submit(url);
    }

    @ShellMethod(value = "Saves a batch of URLs, " +
            "example, `save-batch '[\"https://google.com\", \"https://msn.com\"]'`", key = "save-batch")
    public void submitUrlBatch(@ShellOption String jsonUrls) {
        try {
            internetArchiveService.submitBatch(List.of(objectMapper.readValue(jsonUrls, String[].class)));
        } catch (IOException deserializationException) {
            logger.error("Failed to parse user input", deserializationException);
            System.out.println("Failed to parse the input. Use the provided example structure!");
        }
    }

    @ShellMethod(value = "Saves URLs provided a given file, " +
            "example, `save-file \"/home/User/Desktop/file.txt\"`", key = "save-file")
    public void submitFile(@ShellOption String filePath) {
        internetArchiveService.submitFile(filePath);
    }
}