package model;

import utils.UtilLoadFiles;

import java.io.IOException;
import java.util.List;

public class BookDAO {
    UtilLoadFiles utilLoadFiles = UtilLoadFiles.getInstance();
    private Book book;
    private List<Book> listOfBooks;
    private AuthorDAO authorDAO = new AuthorDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();

    public BookDAO() throws IOException {
        utilLoadFiles.loadBookFile(FileTypes.BOOKS.getFileAdress());
    }

    private List<Book> writeBooksFromList(List<Book> dataFromFile) {

//        for (Book s : dataFromFile) {
//            book = new Book(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]));
//            listOfBooks.add(book);
//        }

//        listOfBooks.forEach(System.out::print);
        return listOfBooks;
    }
}
