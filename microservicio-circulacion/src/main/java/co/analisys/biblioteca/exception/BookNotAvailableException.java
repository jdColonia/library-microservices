package co.analisys.biblioteca.exception;

import co.analisys.biblioteca.model.BookId;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException(BookId bookId) {
        super("The book with ID " + bookId.getBookIdValue() + " is not available.");
    }
}
