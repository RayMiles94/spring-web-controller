package com.springframetutorial.springfirsttutorial.bootstrap;

import com.springframetutorial.springfirsttutorial.model.Author;
import com.springframetutorial.springfirsttutorial.model.Book;
import com.springframetutorial.springfirsttutorial.repos.AuthorRepository;
import com.springframetutorial.springfirsttutorial.repos.BookRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Devbootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authRepository;
    private BookRepository bookRespository;

    public Devbootstrap(AuthorRepository authRepository, BookRepository bookRespository) {
        this.authRepository = authRepository;
        this.bookRespository = bookRespository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        this.initData();
    }

    private void initData() {
        Author author = new Author("raouf", "jabri");
        Book book_1 = new Book("domaine", "12345", "marper");
        author.getBooks().add(book_1);
        book_1.getAuthors().add(author);
        authRepository.save(author);
        bookRespository.save(book_1);

        Author author_2 = new Author("admin2", "admin2");
        Book be2 = new Book("JEE", "125456", "MAX");
        author_2.getBooks().add(be2);
        authRepository.save(author_2);
        bookRespository.save(be2);
    }

    
   
}