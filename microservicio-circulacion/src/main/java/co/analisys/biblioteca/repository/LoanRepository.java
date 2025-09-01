package co.analisys.biblioteca.repository;

import co.analisys.biblioteca.model.Loan;
import co.analisys.biblioteca.model.LoanId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, LoanId> {
}
