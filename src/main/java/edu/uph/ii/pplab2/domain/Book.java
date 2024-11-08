package edu.uph.ii.pplab2.domain;



import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {
    private Long id;
    private String author, title, description;
    private LocalDate release;
    private float price;
    private boolean bestseler;

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
}
