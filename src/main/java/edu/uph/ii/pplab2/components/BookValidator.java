package edu.uph.ii.pplab2.components;

import edu.uph.ii.pplab2.domain.Book;
import org.springframework.lang.NonNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookValidator implements Validator {
    private static final String ROZMIAR_PATTERN = "\\d+(\\.\\d+)? x \\d+(\\.\\d+)? x \\d+";

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return Book.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        Book book = (Book) target;

        if(book.getTitle() != null && book.getTitle().equals(book.getAuthor())) {
            errors.rejectValue("author","fieldsMismach.book.author", "Pole tytuł i autor nie może być takie same");
        }

        if (book.getRozmiar() != null && !book.getRozmiar().toString().matches(ROZMIAR_PATTERN)) {
            errors.rejectValue("rozmiar", "formatMismatch.book.rozmiar", "Nieprawidłowy format rozmiaru");
        }
    }
}
