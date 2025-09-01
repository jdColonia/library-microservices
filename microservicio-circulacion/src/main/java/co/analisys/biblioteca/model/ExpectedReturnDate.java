package co.analisys.biblioteca.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@Data
@AllArgsConstructor
public class ExpectedReturnDate {
    private LocalDate expectedReturnDateValue;

    public ExpectedReturnDate() {
        this.expectedReturnDateValue = LocalDate.now().plusDays(14); // 2 weeks by default
    }
}
