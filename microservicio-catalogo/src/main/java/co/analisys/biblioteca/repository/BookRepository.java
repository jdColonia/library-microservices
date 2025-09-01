package co.analisys.biblioteca.repository;

import co.analisys.biblioteca.model.Book;
import co.analisys.biblioteca.model.BookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, BookId> {
    List<Book> findByTitle(String title);
}
