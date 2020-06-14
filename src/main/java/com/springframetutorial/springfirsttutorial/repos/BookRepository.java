package com.springframetutorial.springfirsttutorial.repos;

import com.springframetutorial.springfirsttutorial.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
    
}