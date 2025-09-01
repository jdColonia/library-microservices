package co.analisys.biblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "International Standard Book Number")
public class ISBN {
    @Schema(description = "ISBN value", example = "978-0-13-235088-4", required = true)
    private String isbnValue;
}
