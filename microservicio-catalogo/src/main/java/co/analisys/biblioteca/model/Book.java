package co.analisys.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "books")
@Data
public class Book {
    @EmbeddedId
    private BookId id;

    private String title;

    @Embedded
    private ISBN isbn;

    @Embedded
    private Category category;

    private boolean available;

    @ManyToMany(fetch = FetchType.EAGER)
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
