package co.analisys.biblioteca.repository;

import co.analisys.biblioteca.model.User;
import co.analisys.biblioteca.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UserId> {
}
