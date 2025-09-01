package co.analisys.biblioteca.repository;

import co.analisys.biblioteca.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
