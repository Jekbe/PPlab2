package edu.uph.ii.pplab2.repositories;

import edu.uph.ii.pplab2.domain.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<BookGenre, Integer> {
}
