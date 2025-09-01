package co.analisys.biblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "books")
@Data
@Schema(description = "Book entity representing a library book with all its details")
public class Book {
    @EmbeddedId
    @Schema(description = "Unique identifier for the book", example = "1")
    private BookId id;

    @Schema(description = "Title of the book", example = "Clean Code", required = true)
    private String title;

    @Embedded
    @Schema(description = "International Standard Book Number")
    private ISBN isbn;

    @Embedded
    @Schema(description = "Category/genre of the book")
    private Category category;

    @Schema(description = "Availability status of the book", example = "true", required = true)
    private boolean available;

    @ManyToMany(fetch = FetchType.EAGER)
    @Schema(description = "List of authors who wrote this book")
    private List<Author> authors;

    public void markAsAvailable() {
        this.available = true;
    }

    public void markAsUnavailable() {
        this.available = false;
    }

    public void updateCategory(Category newCategory) {
        this.category = newCategory;
    }
}
