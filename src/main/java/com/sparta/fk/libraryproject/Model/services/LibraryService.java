package com.sparta.fk.libraryproject.Model.services;

import com.sparta.fk.libraryproject.Model.repositories.BookRepository;
import com.sparta.fk.libraryproject.Model.entities.AuthorDTO;
import com.sparta.fk.libraryproject.Model.entities.BookDTO;
import com.sparta.fk.libraryproject.Model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    public List<AuthorDTO> findAuthorsWithMoreThanOneBook(){

        List<AuthorDTO> complete = new ArrayList<>();
        List<AuthorDTO> allAuthors = authorRepository.findAll();
        List<BookDTO> allBooks = bookRepository.findAll();

        int counter = 0;

        for(AuthorDTO author : allAuthors){
            int id = author.getId();
            for (BookDTO book : allBooks) {
                int bookID = book.getId();
                if (id == bookID) {
                    counter++;
                }
            }
            if (counter > 1) {
                complete.add(author);
            }
        }

        return complete;
    }

    public List<BookDTO> findAutoBiographies() {

        List<BookDTO> autobiographies = new ArrayList<>();
        List<AuthorDTO> allAuthors = authorRepository.findAll();
        List<BookDTO> allBooks = bookRepository.findAll();

        for(AuthorDTO author : allAuthors) {
            String authorName = author.getFullName();
            for (BookDTO book : allBooks) {
                if (book.getTitle().contains(authorName)) {
                    autobiographies.add(book);
                }
            }
        }



        return autobiographies;
    }
}
