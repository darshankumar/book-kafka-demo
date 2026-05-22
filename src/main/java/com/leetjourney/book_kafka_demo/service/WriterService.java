package com.leetjourney.book_kafka_demo.service;

import com.leetjourney.book_kafka_demo.model.BookPublishRequest;
import com.leetjourney.book_kafka_demo.model.BookPublishedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class WriterService {

    private final KafkaTemplate<String, BookPublishedEvent> kafkaTemplate;
    private final String topicName;

    public WriterService(
            KafkaTemplate<String, BookPublishedEvent> kafkaTemplate,
            @Value("${app.kafka.topic.book-published}") String topicName
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public BookPublishedEvent publishBook(BookPublishRequest request) {
        BookPublishedEvent event = new BookPublishedEvent(
                request.isbn(),
                request.title(),
                request.author(),
                request.price(),
                Instant.now()
        );

        kafkaTemplate.send(topicName, event.isbn(), event);
        return event;
    }
}
