package co.analisys.biblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Schema(description = "User's email address")
public class Email {
    @Schema(description = "Email address value", example = "john.doe@library.com", required = true)
    private final String emailValue;
}
