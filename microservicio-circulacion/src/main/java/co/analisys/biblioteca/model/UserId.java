package co.analisys.biblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Unique identifier for a user")
public class UserId implements Serializable {
    @Schema(description = "User ID value", example = "U001", required = true)
    private String userIdValue;
}
