package repository;

import model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
interface Book_Repository extends JpaRepository<Book, Long> {
}
