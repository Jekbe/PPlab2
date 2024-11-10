package edu.uph.ii.pplab2.domain;

public class Rozmiar {
    private double width;
    private double height;
    private int numberOfPages;

    public Rozmiar() {
    }

    public Rozmiar(double width, double height, int numberOfPages) {
        this.width = width;
        this.height = height;
        this.numberOfPages = numberOfPages;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return width + " x " + height + ", " + numberOfPages + " pages";
    }
}
