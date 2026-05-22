package com.leetjourney.book_kafka_demo.controller;

import com.leetjourney.book_kafka_demo.model.BookEntity;
import com.leetjourney.book_kafka_demo.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reader")
public class ReaderController {

    private final BookRepository bookRepository;

    public ReaderController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<BookEntity> getConsumedBooks() {
        return bookRepository.findAll();
    }
}
