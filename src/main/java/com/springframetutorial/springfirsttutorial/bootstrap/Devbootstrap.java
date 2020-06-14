package com.springframetutorial.springfirsttutorial.bootstrap;

import com.springframetutorial.springfirsttutorial.model.Author;
import com.springframetutorial.springfirsttutorial.model.Book;
import com.springframetutorial.springfirsttutorial.model.Publisher;
import com.springframetutorial.springfirsttutorial.repos.AuthorRepository;
import com.springframetutorial.springfirsttutorial.repos.BookRepository;
import com.springframetutorial.springfirsttutorial.repos.PublisherRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Devbootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authRepository;
    private BookRepository bookRespository;
    private PublisherRepository publisherRepository;

    public Devbootstrap(AuthorRepository authRepository, BookRepository bookRespository,
            PublisherRepository publisherRepository) {
        this.authRepository = authRepository;
        this.bookRespository = bookRespository;
        this.publisherRepository = publisherRepository;
    }    
   
    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        this.initData();
    }

    private void initData() {
        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);

        Author author = new Author("raouf", "jabri");
        Book book_1 = new Book("domaine", "12345", publisher);
        author.getBooks().add(book_1);
        book_1.getAuthors().add(author);
        authRepository.save(author);
        bookRespository.save(book_1);

        Author author_2 = new Author("admin2", "admin2");
        Book be2 = new Book("JEE", "125456", publisher);
        author_2.getBooks().add(be2);
        authRepository.save(author_2);
        bookRespository.save(be2);
    }

}