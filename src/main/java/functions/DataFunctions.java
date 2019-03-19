package functions;

import model.Author;
import model.Book;
import dao.DataFromFiles;
import model.Category;
import utils.UserInput;

import java.util.ArrayList;
import java.util.List;

public class DataFunctions {

    public DataFromFiles dataFromFiles = DataFromFiles.getInstance();
    public UserInput userInput = new UserInput();


    public void showAllBooks() {
        dataFromFiles.getListFromBookFile().forEach(System.out::print);
    }


    public void showAllAuthors() {
        dataFromFiles.getListFromAuthorFile().forEach(System.out::print);
    }

    public void showAllCategories() {
        dataFromFiles.getListFromCategoryFile().forEach(System.out::println);
    }


    public void showBooksFromDesignPatternsCategory() {
        dataFromFiles.getListFromBookFile().stream().filter(x -> x.getCategory().getCategoryID() == 2).forEach(System.out::println);
    }

    public List<Book> showBooksChosenAuthorByUser() {
        System.out.println("Enter Author ID to show authors books: ");
        dataFromFiles.getListFromAuthorFile().forEach(x -> System.out.println(x.getId() + ": " + x.getFullName()));
        int authorId = userInput.getNumberFromUser("");
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
