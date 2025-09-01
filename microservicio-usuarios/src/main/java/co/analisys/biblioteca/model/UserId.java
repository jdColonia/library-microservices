package co.analisys.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class UserId {
    private final String userIdValue;
}
