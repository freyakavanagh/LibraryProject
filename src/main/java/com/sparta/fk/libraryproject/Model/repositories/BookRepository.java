package com.sparta.fk.libraryproject.Model.repositories;

import com.sparta.fk.libraryproject.Model.entities.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookDTO, Integer> {
}