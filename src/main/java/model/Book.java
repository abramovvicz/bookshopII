package model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Book {

    private int id;
    private String binding;
    private List<Author> author;
    private Category category;
    private String title;
    private int isbn;
    private int year;

    public Book(int id, String title, int isbn, int year, String binding, List<Author> author, Category category) {
        this.id = id;
        this.binding = binding;
        this.author = author;
        this.category = category;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
    }

    @Override
    public String toString() {
        return "############## BOOK " + id + " ###############" + "\n" +
                "Title: " + title + "\n" +
                "Binding: " + binding + "\n" +
                "Category: " + category + "\n" +
                "Author: " + author + "\n" +
                "ISBN: " + isbn + "\n" +
                "YEAR: " + year + "\n" + "\n";
    }
}






