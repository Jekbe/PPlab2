package edu.uph.ii.pplab2.components;

import edu.uph.ii.pplab2.domain.Book;
import edu.uph.ii.pplab2.domain.BookGenre;
import edu.uph.ii.pplab2.domain.CoverType;
import edu.uph.ii.pplab2.repositories.BookRepository;
import edu.uph.ii.pplab2.repositories.CoverRepository;
import edu.uph.ii.pplab2.repositories.GenreRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookInitializer {
    private BookRepository bookRepository;
    private CoverRepository coverRepository;
    private GenreRepository genreRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setCoverTypeRepository(CoverRepository coverTypeRepository) {
        this.coverRepository = coverTypeRepository;
    }

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    @Bean
    InitializingBean init(){
        return () -> {
            CoverType hardcover = new CoverType(1L, "Hardcover", "Paper");
            CoverType paperback = new CoverType(2L, "Paperback", "Plastic");
            if (coverRepository.count() == 0) {
                coverRepository.save(hardcover);
                coverRepository.save(paperback);
            }

            BookGenre bookGenre1 = new BookGenre(1, "Horror");
            BookGenre bookGenre2 = new BookGenre(2, "Fantasy");
            BookGenre bookGenre3 = new BookGenre(3, "Novel");
            BookGenre bookGenre4 = new BookGenre(4, "Ballad");
            if (genreRepository.count() == 0){
                genreRepository.save(bookGenre1);
                genreRepository.save(bookGenre2);
                genreRepository.save(bookGenre3);
                genreRepository.save(bookGenre4);
            }

            Book book1 = new Book(1L, "Author 1", "Title 1", LocalDate.of(2022, 1, 1), "Description 1", 29.99f, true);
            Book book2 = new Book(2L, "Author 2", "Title 2", LocalDate.of(2023, 2, 2), "Description 2", 39.99f, false);
            Book book3 = new Book(3L, "Author 3", "Title 3", LocalDate.of(2021, 3, 3), "Description 3", 19.99f, true);
            if (bookRepository.count() == 0) {
                bookRepository.save(book1);
                bookRepository.save(book2);
                bookRepository.save(book3);

                book1.setCoverType(hardcover);
                book2.setCoverType(hardcover);
                book3.setCoverType(paperback);

                book1.addGenere(bookGenre3);
                book2.addGenere(bookGenre3);
                book2.addGenere(bookGenre1);
                book3.addGenere(bookGenre2);
                book3.addGenere(bookGenre4);
            }
        };
    }
}
