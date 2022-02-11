package com.example.littlebackend.repository;

import com.example.littlebackend.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    Library findLibraryByStreet(String street);
    Library findLibraryById(Long libraryId);
}
