package com.sparta.fk.libraryproject.controller;

import com.sparta.fk.libraryproject.Model.entities.AuthorDTO;
import com.sparta.fk.libraryproject.Model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    /*@GetMapping("/authors")
    public List<AuthorDTO> getAllAuthors(){
        return authorRepository.findAll();
    }*/

   @GetMapping("/author/{id}")
    public Optional<AuthorDTO> getAuthorById(@PathVariable Integer id) {
        return authorRepository.findById(id);
    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAllAuthorsByName(@RequestParam(name = "name", required = false) String name) {
        List<AuthorDTO> resultList = new ArrayList<>();
        List<AuthorDTO> authorDTOList = authorRepository.findAll();

        for (AuthorDTO authorDTO : authorDTOList) {
            if (name == null) {
                resultList = authorDTOList;
            } else if (authorDTO.getFullName().contains(name)) {
                resultList.add(authorDTO);
            }
        }

        return resultList;

    }

    @PatchMapping("/author/{id}")
    public AuthorDTO saveAuthor(@RequestBody AuthorDTO newAuthor, @PathVariable Integer id) {
        AuthorDTO author = null;
        if(authorRepository.findById(id).isPresent()) {
            author = authorRepository.findById(id).get();
            author.setFullName(newAuthor.getFullName());
        }
        return  authorRepository.save(author);
    }

    @PostMapping("/author/create")
    public AuthorDTO createAuthor(@RequestBody AuthorDTO newAuthor) {
        AuthorDTO author = new AuthorDTO();
            author.setFullName(newAuthor.getFullName());
        return  authorRepository.save(newAuthor);

    }

    @DeleteMapping("/author/delete/{id}") // need to delete books beforehand!
    public String deleteAuthor (@PathVariable Integer id) {
        AuthorDTO authorToDelete = authorRepository.findById(id).get();
            authorRepository.delete(authorToDelete);

            return "author deleted";

    }


}
