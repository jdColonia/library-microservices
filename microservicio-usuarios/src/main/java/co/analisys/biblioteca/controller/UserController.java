package co.analisys.biblioteca.controller;

import co.analisys.biblioteca.model.Email;
import co.analisys.biblioteca.model.User;
import co.analisys.biblioteca.model.UserId;
import co.analisys.biblioteca.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name = "User Management", description = "API for managing library users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_LIBRARIAN') or hasRole('ROLE_USER')")
    @Operation(
        summary = "Retrieve user by ID",
        description = "Fetches user information using their unique identifier"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User found successfully"),
        @ApiResponse(responseCode = "404", description = "User not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public User getUser(
        @Parameter(description = "Unique identifier of the user", required = true, example = "U001")
        @PathVariable String id
    ) {
        return userService.getUser(new UserId(id));
    }

    @PutMapping("/{id}/email")
    @PreAuthorize("hasRole('ROLE_LIBRARIAN') or (hasRole('ROLE_USER') and #id == authentication.name)")
    @Operation(
        summary = "Update user email address",
        description = "Changes the email address for a specific user. Users can only update their own email."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Email updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid email format"),
        @ApiResponse(responseCode = "403", description = "Access denied - can only update own email"),
        @ApiResponse(responseCode = "404", description = "User not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void changeEmail(
        @Parameter(description = "Unique identifier of the user", required = true, example = "U001")
        @PathVariable String id,
        @Parameter(description = "New email address", required = true, example = "user@library.com")
        @RequestBody String newEmail
    ) {
        userService.changeUserEmail(new UserId(id), new Email(newEmail));
    }
}
