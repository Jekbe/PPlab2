package edu.uph.ii.pplab2.repositories;

import edu.uph.ii.pplab2.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
