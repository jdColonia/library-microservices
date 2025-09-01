package co.analisys.biblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@Data
@AllArgsConstructor
@Schema(description = "Expected date for book return")
public class ExpectedReturnDate {
    @Schema(description = "Expected return date (default: 2 weeks from loan date)", example = "2023-12-15", required = true)
    private LocalDate expectedReturnDateValue;

    public ExpectedReturnDate() {
        this.expectedReturnDateValue = LocalDate.now().plusDays(14); // 2 weeks by default
    }
}
