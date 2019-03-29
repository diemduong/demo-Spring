package repository;

import model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Book_Repository extends CrudRepository<Book, Long> {
    List<Book> findByBookName(String name);
}
