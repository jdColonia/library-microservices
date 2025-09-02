package co.analisys.biblioteca.controller;

import co.analisys.biblioteca.dto.NotificationDTO;
import co.analisys.biblioteca.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
@Tag(name = "Notifications", description = "API for sending notifications to users")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_LIBRARIAN')")
    @Operation(
        summary = "Send notification to user",
        description = "Sends a notification message to a specific user. Only librarians can send notifications."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Notification sent successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid notification data"),
        @ApiResponse(responseCode = "403", description = "Access denied - librarian role required"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void sendNotification(
        @Parameter(description = "Notification details", required = true)
        @RequestBody NotificationDTO notification
    ) {
        notificationService.sendNotification(notification);
    }
}
