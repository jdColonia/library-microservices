package co.analisys.biblioteca.controller;

import co.analisys.biblioteca.model.BookId;
import co.analisys.biblioteca.model.Loan;
import co.analisys.biblioteca.model.LoanId;
import co.analisys.biblioteca.model.UserId;
import co.analisys.biblioteca.service.CirculationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/circulation")
@Tag(name = "Book Circulation", description = "API for managing book loans and returns")
public class CirculationController {
    @Autowired
    private CirculationService circulationService;

    @PostMapping("/loan")
    @Operation(
        summary = "Loan a book to a user",
        description = "Creates a new loan record if the book is available and sends notification"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Book loaned successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid user ID or book ID"),
        @ApiResponse(responseCode = "404", description = "Book not found or not available"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void loanBook(
        @Parameter(description = "Unique identifier of the user", required = true, example = "U001")
        @RequestParam String userId,
        @Parameter(description = "Unique identifier of the book", required = true, example = "1")
        @RequestParam String bookId
    ) {
        circulationService.loanBook(new UserId(userId), new BookId(bookId));
    }

    @PostMapping("/return")
    @Operation(
        summary = "Return a loaned book",
        description = "Marks a loan as returned, updates book availability and sends notification"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Book returned successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid loan ID"),
        @ApiResponse(responseCode = "404", description = "Loan not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void returnBook(
        @Parameter(description = "Unique identifier of the loan", required = true, example = "L001")
        @RequestParam String loanId
    ) {
        circulationService.returnBook(new LoanId(loanId));
    }

    @GetMapping("/loans")
    @Operation(
        summary = "Retrieve all loans",
        description = "Returns a list of all loan records in the system"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Loans retrieved successfully"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<Loan> getAllLoans() {
        return circulationService.getAllLoans();
    }
}
