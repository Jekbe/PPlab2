package edu.uph.ii.pplab2.components;

import edu.uph.ii.pplab2.domain.Book;
import edu.uph.ii.pplab2.domain.CoverType;
import edu.uph.ii.pplab2.repositories.BookRepository;
import edu.uph.ii.pplab2.repositories.CoverRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookInitializer {
    private BookRepository bookRepository;
    private CoverRepository coverRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setCoverTypeRepository(CoverRepository coverTypeRepository) {
        this.coverRepository = coverTypeRepository;
    }

    @Bean
    InitializingBean init(){
        return () -> {
            if (coverRepository.count() == 0) {
                coverRepository.save(new CoverType(1L, "Hardcover", "Paper"));
                coverRepository.save(new CoverType(2L, "Paperback", "Plastic"));
            }

            if (bookRepository.findAll().isEmpty()) {
                bookRepository.save(new Book(1L, "Author 1", "Title 1", LocalDate.of(2022, 1, 1), "Description 1", 29.99f, true));
                bookRepository.save(new Book(2L, "Author 2", "Title 2", LocalDate.of(2023, 2, 2), "Description 2", 39.99f, false));
                bookRepository.save(new Book(3L, "Author 3", "Title 3", LocalDate.of(2021, 3, 3), "Description 3", 19.99f, true));
            }
        };
    }
}
