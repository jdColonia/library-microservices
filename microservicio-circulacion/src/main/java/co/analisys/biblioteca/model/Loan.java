package co.analisys.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @EmbeddedId
    private LoanId id;

    @Embedded
    private UserId userId;

    @Embedded
    private BookId bookId;

    @Embedded
    private LoanDate loanDate;

    @Embedded
    private ExpectedReturnDate expectedReturnDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;
}
