package edu.uph.ii.pplab2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rozmiar {
    private double width;
    private double height;
    private int numberOfPages;

    @Override
    public String toString() {
        return width + " x " + height + ", " + numberOfPages + " pages";
    }
}
