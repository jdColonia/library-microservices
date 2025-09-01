package co.analisys.biblioteca.controller;

import co.analisys.biblioteca.model.Book;
import co.analisys.biblioteca.model.BookId;
import co.analisys.biblioteca.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class CatalogController {
    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable String id) {
        return catalogService.getBook(new BookId(id));
    }

    @GetMapping("/{id}/available")
    public boolean isBookAvailable(@PathVariable String id) {
        Book book = catalogService.getBook(new BookId(id));
        return book != null && book.isAvailable();
    }

    @PutMapping("/{id}/availability")
    public void updateAvailability(@PathVariable String id, @RequestBody boolean available) {
        catalogService.updateAvailability(new BookId(id), available);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String criteria) {
        return catalogService.searchBooks(criteria);
    }
}
