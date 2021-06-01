package guru.springfamework.spring5webapp.bootstrap;

import guru.springfamework.spring5webapp.domain.Author;
import guru.springfamework.spring5webapp.domain.Book;
import guru.springfamework.spring5webapp.domain.Publisher;
import guru.springfamework.spring5webapp.repositories.AuthorRepository;
import guru.springfamework.spring5webapp.repositories.BookRepository;
import guru.springfamework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("The American Publication");
        publisher.setAddressLine1("St# 7, W, LONDON");
        publisher.setCity("New YORK");
        publisher.setState("FLORIDA");
        publisher.setZip("123");

        Author author1 = new Author("Tanveer", "Ahmad");
        Book book1 = new Book("The Java Player","1231");
        publisher.getBooks().add(book1);
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        // saving Data
        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher);


        Author author2 = new Author("Zohaan", "Tanveer");
        Book book2 = new Book("The Pro Java","5555");

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        publisher.getBooks().add(book2);

        // saving Data
        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("started in Bootstrap");
        System.out.println("Number of books: "+bookRepository.count());
        System.out.println("Published Number of books: "+publisher.getBooks().size());

    }
}
