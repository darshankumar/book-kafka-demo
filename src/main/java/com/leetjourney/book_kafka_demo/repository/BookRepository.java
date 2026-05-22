package com.leetjourney.book_kafka_demo.repository;

import com.leetjourney.book_kafka_demo.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, String> {
}
