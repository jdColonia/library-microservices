package co.analisys.biblioteca;

import co.analisys.biblioteca.model.*;
import co.analisys.biblioteca.repository.AuthorRepository;
import co.analisys.biblioteca.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create authors
        Author author1 = new Author(null, "Gabriel García Márquez");
        Author author2 = new Author(null, "George Orwell");

        // Save authors to the database
        authorRepository.saveAll(Arrays.asList(author1, author2));

        // Create books and associate them with the saved authors
        Book book1 = new Book();
        book1.setId(new BookId("1"));
        book1.setTitle("One Hundred Years of Solitude");
        book1.setIsbn(new ISBN("978-0307474728"));
        book1.setCategory(new Category("Fiction"));
        book1.setAvailable(true);
        book1.setAuthors(Arrays.asList(author1));

        Book book2 = new Book();
        book2.setId(new BookId("2"));
        book2.setTitle("1984");
        book2.setIsbn(new ISBN("978-0451524935"));
        book2.setCategory(new Category("Science Fiction"));
        book2.setAvailable(true);
        book2.setAuthors(Arrays.asList(author2));

        // Save books to the database
        bookRepository.saveAll(Arrays.asList(book1, book2));

        System.out.println("Test data loaded successfully.");
    }
}
