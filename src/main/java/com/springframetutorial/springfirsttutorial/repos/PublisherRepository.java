package com.springframetutorial.springfirsttutorial.repos;

import com.springframetutorial.springfirsttutorial.model.Publisher;

import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    
}