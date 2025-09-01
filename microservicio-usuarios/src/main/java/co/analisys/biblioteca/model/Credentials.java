package co.analisys.biblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "User login credentials")
public class Credentials {
    @Schema(description = "Username for login", example = "johndoe", required = true)
    private String username;
    
    @Schema(description = "Hashed password (never store plain text)", example = "$2a$10$...", required = true)
    private String passwordHash;
}
