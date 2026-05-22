package com.leetjourney.book_kafka_demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Instant publishedAt;

    protected BookEntity() {
    }

    public BookEntity(String isbn, String title, String author, BigDecimal price, Instant publishedAt) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishedAt = publishedAt;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }
}
