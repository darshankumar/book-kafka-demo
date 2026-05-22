package com.leetjourney.book_kafka_demo.controller;

import com.leetjourney.book_kafka_demo.model.BookPublishRequest;
import com.leetjourney.book_kafka_demo.model.BookPublishedEvent;
import com.leetjourney.book_kafka_demo.service.WriterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/writer")
public class WriterController {

    private final WriterService writerService;

    public WriterController(WriterService writerService) {
        this.writerService = writerService;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookPublishedEvent publishBook(@RequestBody BookPublishRequest request) {
        return writerService.publishBook(request);
    }
}
