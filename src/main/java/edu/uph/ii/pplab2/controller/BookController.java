package edu.uph.ii.pplab2.controller;

import edu.uph.ii.pplab2.components.BookValidator;
import edu.uph.ii.pplab2.domain.Book;
import edu.uph.ii.pplab2.domain.CoverType;
import edu.uph.ii.pplab2.repositories.BookRepository;
import edu.uph.ii.pplab2.repositories.CoverRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    private BookRepository bookRepository;
    private CoverRepository coverRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/bookList")
    public String list(Model model){
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/bookInfo")
    public String info(Model model, @RequestParam("Id") Long id){
        Book book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "info";
    }

    @GetMapping("/bookUsun")
    public String usun(Model model, @RequestParam("Id") Long id){
        bookRepository.deleteById(id);
        return "usun";
    }

    @GetMapping("/bookEdytuj")
    public String edytuj(Model model, @RequestParam(value = "Id", required = false) Long id){
        Book book = (id != null) ? bookRepository.findById(id).orElse(new Book()) : new Book();
        model.addAttribute("book", book);
        return "edytuj";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String process(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "edytuj";
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
