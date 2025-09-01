package co.analisys.biblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "User's physical address")
public class Address {
    @Schema(description = "Street address", example = "123 Main St", required = true)
    private String street;
    
    @Schema(description = "City name", example = "Springfield", required = true)
    private String city;
    
    @Schema(description = "Postal/ZIP code", example = "12345", required = true)
    private String postalCode;
}
