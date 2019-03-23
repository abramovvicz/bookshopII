package view;

import model.Book;

import java.util.List;

public class IsbnTitleYearBookPrintStrategyImpl implements BookPrintStrategy {
    @Override
    public void print(List<Book> bookList) {
        bookList.forEach(x -> System.out.println(x.getIsbn() + " " + x.getTitle() + " " + x.getYear()));

    }
}
