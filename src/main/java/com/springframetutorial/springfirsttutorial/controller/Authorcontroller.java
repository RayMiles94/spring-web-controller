package com.springframetutorial.springfirsttutorial.controller;

import com.springframetutorial.springfirsttutorial.repos.AuthorRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Authorcontroller {

    private AuthorRepository authorRepository;

    public Authorcontroller(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String GetAuthors(Model model) {
        model.addAttribute("authors", this.authorRepository.findAll());
        return "authors";
    }
    
}