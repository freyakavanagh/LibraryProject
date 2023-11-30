package com.sparta.fk.libraryproject;

import com.sparta.fk.libraryproject.Model.entities.AuthorDTO;
import com.sparta.fk.libraryproject.controller.AuthorController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LibraryRestTest {

    private WebTestClient testClient;

    @Autowired
    private AuthorController authorController;

    @BeforeEach
    void setup() {
        testClient = WebTestClient
                .bindToController(authorController).build();
    }

    @Test
    @DisplayName("Check that the status code is 200")
    void checkThatTheStatusCodeIs200() {

        testClient.get()
                .uri("http://127.0.0.1:3000/authors")
                .exchange()
                .expectStatus()
                .isEqualTo(200);
    }

    @Test
    @DisplayName("Check that the first Author is Jane Austen")
    void checkThatTheFirstAuthorIsJaneAusten() {
        testClient.get()
                .uri("http://127.0.0.1:3000/author/2")
                .exchange()
                .expectBody(AuthorDTO.class)
                .value(author -> assertEquals( "Jane Austen", author.getFullName()));
    }




}
