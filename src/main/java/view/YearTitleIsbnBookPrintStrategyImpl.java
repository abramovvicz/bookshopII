package view;

import model.Book;

import java.util.List;

public class YearTitleIsbnBookPrintStrategyImpl implements BookPrintStrategy {
    @Override
    public void print(List<Book> bookList) {
        bookList.forEach(x -> System.out.println(x.getYear() + " " + x.getTitle() + " " + x.getIsbn()));
    }
}
