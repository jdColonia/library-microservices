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
@Schema(description = "Date when the book was loaned")
public class LoanDate {
    @Schema(description = "Date of the loan", example = "2023-12-01", required = true)
    private LocalDate loanDateValue;

    public LoanDate() {
        this.loanDateValue = LocalDate.now();
    }
}
