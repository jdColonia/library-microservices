package co.analisys.biblioteca.exception;

import co.analisys.biblioteca.model.LoanId;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(LoanId loanId) {
        super("Loan not found with ID " + loanId.getLoanIdValue());
    }
}
