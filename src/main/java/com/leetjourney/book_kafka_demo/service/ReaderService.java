package com.leetjourney.book_kafka_demo.service;

import com.leetjourney.book_kafka_demo.model.BookEntity;
import com.leetjourney.book_kafka_demo.model.BookPublishedEvent;
import com.leetjourney.book_kafka_demo.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {

    private static final Logger log = LoggerFactory.getLogger(ReaderService.class);

    private final BookRepository bookRepository;

    public ReaderService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @KafkaListener(topics = "${app.kafka.topic.book-published}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeBook(BookPublishedEvent event) {
        BookEntity book = new BookEntity(
                event.isbn(),
                event.title(),
                event.author(),
                event.price(),
                event.publishedAt()
        );

        bookRepository.save(book);
        log.info("Reader consumed book from Kafka and saved isbn={}, title={}", event.isbn(), event.title());
    }
}
