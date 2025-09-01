package co.analisys.biblioteca.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data Transfer Object for sending notifications to users")
public class NotificationDTO {
    @Schema(description = "ID of the user to receive the notification", example = "U001", required = true)
    private String userId;
    
    @Schema(description = "Notification message content", example = "Book loaned: Clean Code", required = true)
    private String message;
}
