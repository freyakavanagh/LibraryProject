package com.sparta.fk.libraryproject.Model.repositories;

import com.sparta.fk.libraryproject.Model.entities.AuthorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorDTO, Integer> {

    Optional<AuthorDTO> findAuthorByFullName(String FullName);
}