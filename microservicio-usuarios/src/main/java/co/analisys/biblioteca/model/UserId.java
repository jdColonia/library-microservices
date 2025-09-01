package co.analisys.biblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Schema(description = "Unique identifier for a user")
public class UserId {
    @Schema(description = "User ID value", example = "U001", required = true)
    private final String userIdValue;
}
