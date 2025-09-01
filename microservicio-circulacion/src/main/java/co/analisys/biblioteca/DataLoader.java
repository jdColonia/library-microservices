package co.analisys.biblioteca;

import co.analisys.biblioteca.model.*;
import co.analisys.biblioteca.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private LoanRepository loanRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create sample loans
        Loan loan1 = new Loan(
                new LoanId(UUID.randomUUID().toString()),
                new UserId("U001"),
                new BookId("L001"),
                new LoanDate(LocalDate.now().minusDays(5)),
                new ExpectedReturnDate(LocalDate.now().plusDays(9)),
                LoanStatus.ACTIVE
        );

        Loan loan2 = new Loan(
                new LoanId(UUID.randomUUID().toString()),
                new UserId("U002"),
                new BookId("L002"),
                new LoanDate(LocalDate.now().minusDays(10)),
                new ExpectedReturnDate(LocalDate.now().plusDays(4)),
                LoanStatus.ACTIVE
        );

        Loan loan3 = new Loan(
                new LoanId(UUID.randomUUID().toString()),
                new UserId("U003"),
                new BookId("L003"),
                new LoanDate(LocalDate.now().minusDays(15)),
                new ExpectedReturnDate(LocalDate.now().minusDays(1)),
                LoanStatus.OVERDUE
        );

        // Save loans to the database
        loanRepository.saveAll(Arrays.asList(loan1, loan2, loan3));

        System.out.println("Sample loan data loaded successfully.");
    }
}
