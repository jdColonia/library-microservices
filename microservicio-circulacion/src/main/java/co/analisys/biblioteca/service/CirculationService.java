package co.analisys.biblioteca.service;

import co.analisys.biblioteca.dto.NotificationDTO;
import co.analisys.biblioteca.exception.BookNotAvailableException;
import co.analisys.biblioteca.exception.LoanNotFoundException;
import co.analisys.biblioteca.model.*;
import co.analisys.biblioteca.repository.LoanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CirculationService {
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Transactional
    public void loanBook(UserId userId, BookId bookId) {
        Boolean bookAvailable = restTemplate.getForObject(
                "http://localhost:8082/books/" + bookId.getBookIdValue() + "/available", Boolean.class);

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

            // Update availability
            HttpEntity<Boolean> requestEntity = new HttpEntity<>(false);
            restTemplate.exchange(
                    "http://localhost:8082" + "/books/" + bookId.getBookIdValue() + "/availability",
                    HttpMethod.PUT,
                    requestEntity,
                    Void.class
            );

            restTemplate.postForObject(
                    "http://localhost:8084/notify",
                    new NotificationDTO(userId.getUserIdValue(), "Book loaned: " + bookId.getBookIdValue()),
                    Void.class);
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

        restTemplate.put("http://localhost:8082/books/" + loan.getBookId().getBookIdValue() + "/availability", true);

        restTemplate.postForObject(
                "http://localhost:8084/notify",
                new NotificationDTO(loan.getUserId().getUserIdValue(), "Book returned: " + loan.getBookId().getBookIdValue()),
                Void.class);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}
