package edu.uph.ii.pplab2.controller;

import edu.uph.ii.pplab2.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class MyController {

    @GetMapping("/newBook")
    public String newBook(Model model){
        Book book = new Book(1L, "autor", "tytuł", LocalDate.now(), "opis", 30, false);

        model.addAttribute("book", book);

        return "newBook";
    }

    @GetMapping("/list")
    public String list(Model model){
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(1L, "autor1","tytuł1", LocalDate.now(), "opis1", 30, false));
        books.add(new Book(2L, "autor2","tytuł2", LocalDate.now(), "opis2", 50, true));
        books.add(new Book(3L, "autor3", "tytuł3", LocalDate.now(), "opis3", 20, false));

        model.addAttribute("books", books);

        return "list";
    }

    @GetMapping("/index")
    public String index(Model model){
        return "index";
    }
}
