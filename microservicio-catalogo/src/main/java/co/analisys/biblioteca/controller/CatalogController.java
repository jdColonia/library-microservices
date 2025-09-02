package co.analisys.biblioteca.controller;

import co.analisys.biblioteca.model.Book;
import co.analisys.biblioteca.model.BookId;
import co.analisys.biblioteca.service.CatalogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Tag(name = "Book Catalog", description = "API for managing library book catalog")
public class CatalogController {
    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Retrieve book by ID",
        description = "Fetches a book from the catalog using its unique identifier"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Book found successfully"),
        @ApiResponse(responseCode = "404", description = "Book not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public Book getBook(
        @Parameter(description = "Unique identifier of the book", required = true, example = "1")
        @PathVariable String id
    ) {
        return catalogService.getBook(new BookId(id));
    }

    @GetMapping("/{id}/available")
    @Operation(
        summary = "Check book availability",
        description = "Verifies if a specific book is currently available for loan"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Availability status retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "Book not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public boolean isBookAvailable(
        @Parameter(description = "Unique identifier of the book", required = true, example = "1")
        @PathVariable String id
    ) {
        Book book = catalogService.getBook(new BookId(id));
        return book != null && book.isAvailable();
    }

    @PutMapping("/{id}/availability")
    @Operation(
        summary = "Update book availability",
        description = "Updates the availability status of a book (used by circulation service)"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Availability updated successfully"),
        @ApiResponse(responseCode = "404", description = "Book not found"),
        @ApiResponse(responseCode = "400", description = "Invalid availability status"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void updateAvailability(
        @Parameter(description = "Unique identifier of the book", required = true, example = "1")
        @PathVariable String id,
        @Parameter(description = "New availability status", required = true, example = "true")
        @RequestBody boolean available
    ) {
        catalogService.updateAvailability(new BookId(id), available);
    }

    @GetMapping("/search")
    @Operation(
        summary = "Search books in catalog",
        description = "Searches for books based on title, author, or other criteria"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Search completed successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid search criteria"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<Book> searchBooks(
        @Parameter(description = "Search criteria (title, author, etc.)", required = true, example = "Java")
        @RequestParam String criteria
    ) {
        return catalogService.searchBooks(criteria);
    }
}
