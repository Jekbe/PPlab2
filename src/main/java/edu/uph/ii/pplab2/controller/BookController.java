package edu.uph.ii.pplab2.controller;

import edu.uph.ii.pplab2.components.BookValidator;
import edu.uph.ii.pplab2.domain.Book;
import edu.uph.ii.pplab2.domain.CoverType;
import edu.uph.ii.pplab2.repositories.BookRepository;
import edu.uph.ii.pplab2.repositories.CoverRepository;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j2
public class BookController {
    private BookRepository bookRepository;
    private CoverRepository coverRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        log.log(Level.DEBUG, "Repozytorium załadowane");
    }

    @GetMapping("/bookList")
    public String list(Model model){
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }

    @GetMapping("/bookInfo")
    public String info(Model model, @RequestParam("Id") Long id){
        Book book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "bookinfo";
    }

    @GetMapping("/bookUsun")
    public String usun(Model model, @RequestParam("Id") Long id){
        bookRepository.deleteById(id);
        return "bookusun";
    }

    @GetMapping("/bookEdytuj")
    public String edytuj(Model model, @RequestParam(value = "Id", required = false) Long id){
        Book book = (id != null) ? bookRepository.findById(id).orElse(new Book()) : new Book();
        model.addAttribute("book", book);
        return "bookedytuj";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String process(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "bookedytuj";
        }
        bookRepository.save(book);
        return "redirect:/bookList";
    }

    @InitBinder("book")
    public void addValidator(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new BookValidator());
    }

    public CoverType getCover(Long id){
        return coverRepository.findById(id).orElse(null);
    }

    @Autowired
    public void setCoverRepository(CoverRepository coverRepository) {
        this.coverRepository = coverRepository;
    }
}
