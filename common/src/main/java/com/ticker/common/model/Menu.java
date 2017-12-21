package com.ticker.common.model;

public class Menu {

    private Box.Menu box;

    private Label.Menu label;

    private Book.Menu book;

    public Book.Menu getBook() {
        return book;
    }

    public void setBook(Book.Menu book) {
        this.book = book;
    }

    public Box.Menu getBox() {
        return box;
    }

    public void setBox(Box.Menu box) {
        this.box = box;
    }

    public Label.Menu getLabel() {
        return label;
    }

    public void setLabel(Label.Menu label) {
        this.label = label;
    }
}
