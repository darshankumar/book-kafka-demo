package com.leetjourney.book_kafka_demo.model;

import java.math.BigDecimal;

public record BookPublishRequest(
        String isbn,
        String title,
        String author,
        BigDecimal price
) {
}
