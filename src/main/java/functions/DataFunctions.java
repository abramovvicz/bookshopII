package functions;

import dao.DataFromFiles;
import lombok.Setter;
import model.Author;
import model.Book;
import utils.UserInput;
import view.BookPrintStrategy;
import view.YearTitleIsbnBookPrintStrategyImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataFunctions {

    public DataFromFiles dataFromFiles = DataFromFiles.getInstance();
    public UserInput userInput = new UserInput();
    @Setter
    private BookPrintStrategy printStrategy = new YearTitleIsbnBookPrintStrategyImpl();


    public void showAllBooks() {
        printStrategy.print(dataFromFiles.getListFromBookFile());
    }


    public void showAllAuthors() {
        dataFromFiles.getListFromAuthorFile().forEach(System.out::print);
    }

    public void showAllCategories() {
        dataFromFiles.getListFromCategoryFile().forEach(System.out::println);
    }


    public void showBooksFromDesignPatternsCategory() {
        printStrategy.print(dataFromFiles.getListFromBookFile().stream().filter(x -> x.getCategory().getCategoryID() == 2).collect(Collectors.toList()));
    }

    public List<Book> showBooksChosenAuthorByUser() {
        System.out.println("Enter Author ID to show authors books: ");
        dataFromFiles.getListFromAuthorFile().forEach(x -> System.out.println(x.getId() + ": " + x.getFullName()));
        int authorId = userInput.getNumberFromUser();
        List<Book> resultBookList = new ArrayList<>();
        for (Book book : dataFromFiles.getListFromBookFile()) {
            for (Author author : book.getAuthor()) {
                if (author.getId() == authorId) {
                    resultBookList.add(book);
                }
            }
        }
        return resultBookList;
    }
}
