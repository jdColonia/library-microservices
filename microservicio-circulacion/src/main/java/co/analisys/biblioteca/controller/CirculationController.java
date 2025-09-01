package co.analisys.biblioteca.controller;

import co.analisys.biblioteca.model.BookId;
import co.analisys.biblioteca.model.Loan;
import co.analisys.biblioteca.model.LoanId;
import co.analisys.biblioteca.model.UserId;
import co.analisys.biblioteca.service.CirculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/circulation")
public class CirculationController {
    @Autowired
    private CirculationService circulationService;

    @PostMapping("/loan")
    public void loanBook(@RequestParam String userId, @RequestParam String bookId) {
        circulationService.loanBook(new UserId(userId), new BookId(bookId));
    }

    @PostMapping("/return")
    public void returnBook(@RequestParam String loanId) {
        circulationService.returnBook(new LoanId(loanId));
    }

    @GetMapping("/loans")
    public List<Loan> getAllLoans() {
        return circulationService.getAllLoans();
    }
}
