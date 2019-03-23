package view;

import model.Book;

import java.util.List;

public class TitleYearIsbnBookPrintStrategyImpl implements BookPrintStrategy {
    @Override
    public void print(List<Book> bookList) {
        bookList.forEach(x -> System.out.println(x.getTitle() + " " + x.getYear() + " " + x.getIsbn()));

    }
}
