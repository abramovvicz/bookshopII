package model;

import lombok.Getter;

@Getter
public class Book {

    private int id;
    private String title;
    private int isbn;
    private int year;


    public Book(String title, int isbn, int year) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
    }

    @Override
    public String toString() {
        return "############## BOOK " + id + " ###############" + "\n" +
//                "Id: " + id +
                "Title: " + title + "\n" +
                "ISBN: " + isbn + "\n" +
                "YEAR: " + year + "\n"+ "\n";
    }
}






