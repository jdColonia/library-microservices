package co.analisys.biblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Status of a book loan")
public enum LoanStatus {
    @Schema(description = "Loan is currently active")
    ACTIVE, 
    
    @Schema(description = "Book has been returned")
    RETURNED, 
    
    @Schema(description = "Loan is overdue")
    OVERDUE
}
