package co.analisys.biblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Schema(description = "User entity representing a library user")
public class User {
    @EmbeddedId
    @Schema(description = "Unique identifier for the user", example = "U001")
    private UserId id;

    @Column(name = "name")
    @Schema(description = "Full name of the user", example = "John Doe", required = true)
    private String name;

    @Embedded
    @Schema(description = "User's email address")
    private Email email;

    @Embedded
    @Schema(description = "User's physical address")
    private Address address;

    @Embedded
    @Schema(description = "User's login credentials")
    private Credentials credentials;

    public void changeEmail(Email newEmail) {
        this.email = newEmail;
    }

    public void updateAddress(Address newAddress) {
        this.address = newAddress;
    }
}
