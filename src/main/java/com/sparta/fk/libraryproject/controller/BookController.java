package com.sparta.fk.libraryproject.controller;

import com.sparta.fk.libraryproject.Model.entities.AuthorDTO;
import com.sparta.fk.libraryproject.Model.entities.BookDTO;
import com.sparta.fk.libraryproject.Model.repositories.AuthorRepository;
import com.sparta.fk.libraryproject.Model.repositories.BookRepository;
import com.sparta.fk.libraryproject.exceptions.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/book")
    public String addBook(@RequestBody BookDTO bookDTO) throws AuthorNotFoundException {
        Optional<AuthorDTO> author = authorRepository.findAuthorByFullName(bookDTO.getAuthor().getFullName());
        if(author.isEmpty()) {
            throw new AuthorNotFoundException(bookDTO.getAuthor().getFullName());
        }else {
            bookDTO.setAuthor(author.get());
            bookRepository.save(bookDTO);
            return "book has been saved";
        }

    }






}
