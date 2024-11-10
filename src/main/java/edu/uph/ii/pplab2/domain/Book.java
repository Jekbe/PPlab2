package edu.uph.ii.pplab2.domain;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {
    @NotNull
    private Long id;
    @NotBlank
    private String author, title, description;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate release;
    @Positive
    @NumberFormat(pattern = "#.00")
    private float price;
    private boolean bestseler;
    //private Rozmiar rozmiar;

    public Book() {
    }

    public Book(Long id, String author, String title, LocalDate release, String description, float price, boolean bestseller) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.release = release;
        this.description = description;
        this.price = price;
        this.bestseler = bestseller;
        //this.rozmiar = rozmiar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isBestseller() {
        return bestseler;
    }

    public void setBestseller(boolean bestseler) {
        this.bestseler = bestseler;
    }

//    public Rozmiar getRozmiar() {
//        return rozmiar;
//    }
//
//    public void setRozmiar(Rozmiar rozmiar) {
//        this.rozmiar = rozmiar;
//    }
}
