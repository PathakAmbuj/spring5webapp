package com.ambuj.spring.bootstrap;

import com.ambuj.spring.domain.Author;
import com.ambuj.spring.domain.Book;
import com.ambuj.spring.domain.Publisher;
import com.ambuj.spring.repositories.AuthorRepositories;
import com.ambuj.spring.repositories.BookRepositories;
import com.ambuj.spring.repositories.PublisherRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepositories authorRepositories;
    private final BookRepositories bookRepositories;
    private final PublisherRepositories publisherRepositories;

    public BootStrapData(AuthorRepositories authorRepositories, BookRepositories bookRepositories, PublisherRepositories publisherRepositories) {
        this.authorRepositories = authorRepositories;
        this.bookRepositories = bookRepositories;
        this.publisherRepositories = publisherRepositories;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in BootStrap");

        Publisher publisher = new Publisher();

        publisher.setName("SEG Publishing");
        publisher.setAddressLine1("Darbhanga");
        publisher.setState("Bihar");

        publisherRepositories.save(publisher);
        System.out.println("Publisher Count : "+publisherRepositories.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123456");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepositories.save(eric);
        bookRepositories.save(ddd);
        publisherRepositories.save(publisher);

        Author rod = new Author("rod", "johnson");
        Book noEJB = new Book("J2EE development without EJB", "121132424");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepositories.save(rod);
        bookRepositories.save(noEJB);
        publisherRepositories.save(publisher);

        System.out.println("Number of Books : "+ bookRepositories.count());
        System.out.println("Publisher Number of books : "+publisher.getBooks().size());
    }
}
