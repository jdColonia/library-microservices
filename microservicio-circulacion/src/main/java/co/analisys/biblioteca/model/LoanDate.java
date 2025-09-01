package co.analisys.biblioteca.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@Data
@AllArgsConstructor
public class LoanDate {
    private LocalDate loanDateValue;

    public LoanDate() {
        this.loanDateValue = LocalDate.now();
    }
}
