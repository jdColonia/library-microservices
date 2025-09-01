package co.analisys.biblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Loan entity representing a book loan transaction")
public class Loan {
    @EmbeddedId
    @Schema(description = "Unique identifier for the loan", example = "L001")
    private LoanId id;

    @Embedded
    @Schema(description = "ID of the user who borrowed the book")
    private UserId userId;

    @Embedded
    @Schema(description = "ID of the borrowed book")
    private BookId bookId;

    @Embedded
    @Schema(description = "Date when the book was loaned")
    private LoanDate loanDate;

    @Embedded
    @Schema(description = "Expected return date for the book")
    private ExpectedReturnDate expectedReturnDate;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Current status of the loan", example = "ACTIVE")
    private LoanStatus status;
}
