package dao;

import enums.FileTypes;
import model.Author;
import model.Book;
import utils.Status;
import utils.UserInput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private UserInput userInput = new UserInput();
    private Status status = Status.getInstance();

    public void deleteBookByID(List<Book> bookList) {
        System.out.println("Enter book ID to delete");

        List<Book> copyOfBookList = new ArrayList<>(bookList);
        boolean flag = true;
        while (flag) {
            int idEnteredByUser = getBookIdFromUser();
            for (Book book : copyOfBookList) {
                if (book.getId() == idEnteredByUser) {
                    bookList.remove(book);
                    status.setStatus(true);

                    flag = false;
                }
            }
            System.out.println("Did`nt find book with entered ID");
            System.out.println("Please enter another ID");
        }

        /* STREAM
        Optional<Book> first = copyOfBookList.stream().filter(x -> idBook == x.getId()).findFirst();
        while (!first.isPresent()) {
            System.out.println("Did`nt find book with entered ID");
            System.out.println("Please enter another ID");
            idBook = getBookIdFromUser();
        }
       bookList.remove(first.get()); */
    }


    private int getBookIdFromUser() {
        System.out.println("Enter book ID to delete");
        return userInput.getNumberFromUser();
    }

    public void saveBookToFile(List<Book> bookList) {
        try {
            FileWriter fileWriter = new FileWriter(FileTypes.NEW_BOOKS.getFileAddress());
            for (Book book : bookList) {
                List<Integer> authorsIDs = new ArrayList<>();
                for (Author author : book.getAuthor()) {
                    authorsIDs.add(author.getId());
                }
                String authorsToString = String.valueOf(authorsIDs).substring(1, String.valueOf(authorsIDs).length() - 1);
                String pattern = book.getId() + ";" + book.getTitle() + ";" + book.getIsbn() + ";"
                        + book.getYear() + ";" + book.getBinding() + ";" + authorsToString + ";" +
                        book.getCategory().getCategoryID();
                fileWriter.write(pattern);
                fileWriter.write("\n");
            }
            System.out.println("Book has successfully saved");
            fileWriter.close();


        } catch (IOException e) {
            System.out.println("Sorry, there was error with saving file");
        }

    }

}
