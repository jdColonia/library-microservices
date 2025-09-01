package co.analisys.biblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Unique identifier for a book")
public class BookId implements Serializable {
    @Schema(description = "Book ID value", example = "1", required = true)
    private String bookIdValue;
}