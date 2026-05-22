package com.leetjourney.book_kafka_demo.model;

import java.math.BigDecimal;
import java.time.Instant;

public record BookPublishedEvent(
        String isbn,
        String title,
        String author,
        BigDecimal price,
        Instant publishedAt
) {
}
