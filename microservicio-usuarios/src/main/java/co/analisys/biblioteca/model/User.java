package co.analisys.biblioteca.model;

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
public class User {
    @EmbeddedId
    private UserId id;

    @Column(name = "name")
    private String name;

    @Embedded
    private Email email;

    @Embedded
    private Address address;

    @Embedded
    private Credentials credentials;

    public void changeEmail(Email newEmail) {
        this.email = newEmail;
    }

    public void updateAddress(Address newAddress) {
        this.address = newAddress;
    }
}
