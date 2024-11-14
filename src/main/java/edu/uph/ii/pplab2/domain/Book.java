package edu.uph.ii.pplab2.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book implements Serializable {
    @Id
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
    private boolean bestseller;
    @ManyToOne
    private CoverType coverType;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<BookGenre> genres;
    //private Rozmiar rozmiar;

    public Book(Long id, String author, String title, LocalDate release, String description, float price, boolean bestseller/*, Rozmiar rozmiar*/) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.release = release;
        this.description = description;
        this.price = price;
        this.bestseller = bestseller;
        this.genres = new HashSet<>();
        //this.rozmiar = rozmiar;
    }

    public void addGenere(BookGenre genre){
        genres.add(genre);
    }
}
