package co.analisys.biblioteca.service;

import co.analisys.biblioteca.model.Book;
import co.analisys.biblioteca.model.BookId;
import co.analisys.biblioteca.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatalogService {
    private final BookRepository bookRepository;

    @Autowired
    public CatalogService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBook(BookId id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Transactional
    public void updateAvailability(BookId bookId, boolean available) {
        Book book = getBook(bookId);
        if (available) {
            book.markAsAvailable();
        } else {
            book.markAsUnavailable();
        }
        bookRepository.save(book);
    }

    public List<Book> searchBooks(String criteria) {
        return bookRepository.findByTitle(criteria);
    }
}
