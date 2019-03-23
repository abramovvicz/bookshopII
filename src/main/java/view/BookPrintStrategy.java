package view;

import model.Book;

import java.util.List;

public interface BookPrintStrategy {

    void print(List<Book> bookList);

}
