package com.springframetutorial.springfirsttutorial.repos;

import com.springframetutorial.springfirsttutorial.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    
}