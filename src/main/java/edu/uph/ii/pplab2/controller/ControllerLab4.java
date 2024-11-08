package edu.uph.ii.pplab2.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class ControllerLab4 {
    @NumberFormat(pattern = "#.00") private float price;

    @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate date;

    @GetMapping("/format")
    public String formatTest(Model model){
        model.addAttribute("price", price);
        model.addAttribute("date", date);

        return "format";
    }
}
