package com.sparta.fk.libraryproject;

import com.sparta.fk.libraryproject.Model.entities.BookDTO;
import com.sparta.fk.libraryproject.Model.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class LibraryProjectApplication {

    private Logger logger = Logger.getLogger(LibraryProjectApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(LibraryProjectApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner runner(BookRepository bookRepository) {
        return args -> {
            ArrayList<BookDTO > allBooks = (ArrayList<BookDTO>) bookRepository.findAll();
            logger.log(Level.INFO, allBooks.toString());
        };
    }*/

}
