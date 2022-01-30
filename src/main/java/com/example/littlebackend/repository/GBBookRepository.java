package com.example.littlebackend.repository;

import com.example.littlebackend.model.GBBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GBBookRepository extends JpaRepository<GBBook, Long> {
    GBBook findGBBookByTitle(String title);
    List<GBBook> findByBookId(Long bookId);
}
