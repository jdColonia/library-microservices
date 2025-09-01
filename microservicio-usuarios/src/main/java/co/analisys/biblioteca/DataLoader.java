package co.analisys.biblioteca;

import co.analisys.biblioteca.model.*;
import co.analisys.biblioteca.repository.UserRepository;
import jakarta.persistence.Embedded;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Load test data
        UserId userId = new UserId("1");
        Email email = new Email("jrquintero@analisys.co");
        Address address = new Address("123 Main Street","Cali","123");
        Credentials credentials = new Credentials("jrquintero","password");
        userRepository.save(User.builder()
                .id(userId)
                .name("John Robert Quintero")
                .email(email)
                .address(address)
                .credentials(credentials)
                .build());

        System.out.println("Test data loaded successfully.");
    }
}
