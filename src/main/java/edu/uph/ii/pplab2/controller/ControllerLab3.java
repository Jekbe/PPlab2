package edu.uph.ii.pplab2.controller;

import edu.uph.ii.pplab2.domain.Book;
import edu.uph.ii.pplab2.domain.DatabaseDump;
import edu.uph.ii.pplab2.components.BookValidator;
import edu.uph.ii.pplab2.domain.RozmiarFormatter;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ControllerLab3 {
    @GetMapping("/list3")
    public String list(Model model){
        ArrayList<Book> books = (ArrayList<Book>) DatabaseDump.getAllBooks();

        model.addAttribute("books", books);

        return "list";
    }

    @GetMapping("/info")
    public String info(Model model, @RequestParam("Id") Long id){
        Book book = DatabaseDump.findBookById(id, null);
        model.addAttribute("book", book);

        return "info";
    }

    @GetMapping("/usun")
    public String usun(Model model, @RequestParam("Id") Long id){
        DatabaseDump.deleteBookById(id);

        return "usun";
    }

    @GetMapping("/edytuj")
    public String edytuj(Model model, @RequestParam(name = "Id", required = false) Long id){
        Book book = (id != null) ? DatabaseDump.findBookById(id, null) : new Book();
        model.addAttribute("book", book);
        return "edytuj";
    }

    @RequestMapping(value = "/bookForm", method = RequestMethod.POST)
    public String process(@ModelAttribute("book") @Valid Book book, BindingResult result){
        if(result.hasErrors())
            return "edytuj";

        DatabaseDump.saveOrUpdate(book);

        return "redirect:/list3";
    }

    @InitBinder("book")
    public void addValidator(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new BookValidator());
    }

    public void addFormatter(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new RozmiarFormatter());
    }
}
