package com.example.littlebackend.repository;

import com.example.littlebackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByBookTitle(String title);
    Book findBookById(Long bookId);

}
