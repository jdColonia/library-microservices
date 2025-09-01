package co.analisys.biblioteca.service;

import co.analisys.biblioteca.client.CatalogServiceClient;
import co.analisys.biblioteca.client.NotificationServiceClient;
import co.analisys.biblioteca.dto.NotificationDTO;
import co.analisys.biblioteca.exception.BookNotAvailableException;
import co.analisys.biblioteca.exception.LoanNotFoundException;
import co.analisys.biblioteca.model.*;
import co.analisys.biblioteca.repository.LoanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CirculationService {
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CatalogServiceClient catalogServiceClient;
    
    @Autowired
    private NotificationServiceClient notificationServiceClient;

    @Transactional
    public void loanBook(UserId userId, BookId bookId) {
        Boolean bookAvailable = catalogServiceClient.isBookAvailable(bookId.getBookIdValue());

        if (bookAvailable != null && bookAvailable) {
            Loan loan = new Loan(
                    new LoanId(java.util.UUID.randomUUID().toString()),
                    userId,
                    bookId,
                    new LoanDate(),
                    new ExpectedReturnDate(),
                    LoanStatus.ACTIVE
            );
            loanRepository.save(loan);

            catalogServiceClient.updateBookAvailability(bookId.getBookIdValue(), false);

            notificationServiceClient.sendNotification(
                new NotificationDTO(userId.getUserIdValue(), "Book loaned: " + bookId.getBookIdValue())
            );
        } else {
            throw new BookNotAvailableException(bookId);
        }
    }

    @Transactional
    public void returnBook(LoanId loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFoundException(loanId));

        loan.setStatus(LoanStatus.RETURNED);
        loanRepository.save(loan);

        catalogServiceClient.updateBookAvailability(loan.getBookId().getBookIdValue(), true);

        notificationServiceClient.sendNotification(
            new NotificationDTO(loan.getUserId().getUserIdValue(), "Book returned: " + loan.getBookId().getBookIdValue())
        );
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}
