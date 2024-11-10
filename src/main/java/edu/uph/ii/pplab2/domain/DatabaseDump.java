package edu.uph.ii.pplab2.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/*
* Prosta baza danych typu InMemory
* Celem jest zapoznanie studentów ze Stream API języka Java
* */

public class DatabaseDump {
    private static final List<Book> bookList;

    static {
        bookList = new ArrayList<>();
        long id = 0;
        var book = new Book(id++, "Henryk Sienkiewicz","W pustyni i puszczy", LocalDate.of(2000,1,23), "0-596-52068-9", 56.99f, true, new Rozmiar(10, 15, 100));
        bookList.add(book);
        book = new Book(id++, "Henryk Sienkiewicz","Krzyżacy", LocalDate.of(2006,11,13), "0 512 52068 9", 106.59f, true, new Rozmiar(10, 15, 100));
        bookList.add(book);
        book = new Book(id, "Adam Mickiewicz","Pan Tadeusz", LocalDate.of(1996,9,16), "ISBN-10 0-596-52068-9", 100.10f, false, new Rozmiar(10, 15, 100));
        bookList.add(book);
    }

    public static List<Book> getAllBooks(){
        return bookList;
    }

    public static Book findBookById(Long id, Book defaultVal){
        var book = bookList.stream().filter(x -> Objects.equals(x.getId(), id)).findFirst();
        return book.orElse(defaultVal);//jeśli nie znaleziono to zwróć domyślną wartość
    }

    public static void deleteBookById(Long id){
        var book = findBookById(id, null);
		if(book != null) bookList.remove(book);
    }

    public static void saveOrUpdate(Book book){
        if(book.getId() == null){//brak ID - nowa ksiazka
            //wyszukiwanie maksymalnego Id i zwiększanie o 1
            var max = bookList.stream().max(Comparator.comparing(Book::getId)).stream().map(x->x.getId() + 1).findFirst();
            var newId = max.orElse(1L);//jeśli lista była pusta i brak max to id=1
            book.setId(newId);
            bookList.add(book);
        } else{//edycja
            var bookToUpdate = findBookById(book.getId(), null);
			if(bookToUpdate != null){
				var idx = bookList.indexOf(bookToUpdate);//wyszukiwanie indeksu, gdzie znajduje się stara książka
				if(idx != -1) bookList.set(idx, book);//podmieniamy książkę
			}
        }
    }
}
