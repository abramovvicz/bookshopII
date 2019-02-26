package model;

import utils.UtilLoadFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    UtilLoadFiles utilLoadFiles = UtilLoadFiles.getInstance();
    private Book book;
    private List<String[]> dataFromFile = utilLoadFiles.loadFile(FileTypes.BOOKS.getFileTypes());
    private List<Book> listOfBooks = new ArrayList<>();


    public BookDAO() throws IOException {
        writeBooksFromList(dataFromFile);
    }

    private List<Book> writeBooksFromList(List<String[]> dataFromFile) {

        for (String[] s : dataFromFile) {
            book = new Book(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            listOfBooks.add(book);
        }

        listOfBooks.forEach(System.out::print);
        return listOfBooks;
    }
}
