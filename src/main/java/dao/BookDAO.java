package dao;

import enums.FileTypes;
import model.Author;
import model.Book;
import utils.ApplicationStatus;
import utils.UserInput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDAO {

    private UserInput userInput = new UserInput();
    private ApplicationStatus applicationStatus = ApplicationStatus.getInstance();

    public void deleteBookByID(List<Book> bookList) {
        if (bookList.isEmpty()) {
            System.out.println("Book list is empty");
        } else {
            System.out.println("Enter book ID to delete");
            List<Book> copyOfBookList = new ArrayList<>(bookList);
            boolean flag = true;
            while (flag) {
                int idEnteredByUser = getBookIdFromUser();
                for (Book book : copyOfBookList) {
                    if (book.getId() == idEnteredByUser) {
                        bookList.remove(book);
                        System.out.println("Remove successful");
                        applicationStatus.setStatus(true);
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println("Did`int find any ids. Renter ID:");
                }
            }
        }
    }


    public void deleteBookByIdStream(List<Book> bookList) {
        if (bookList.isEmpty()) {
            System.out.println("Book list is empty");
        } else {
            System.out.println("Enter book ID to delete");
            List<Book> copyOfBookList = new ArrayList<>(bookList);
            while (true) {
                int idBook = userInput.getNumberFromUser();
                Optional<Book> first = copyOfBookList.stream().filter(x -> idBook == x.getId()).findFirst();
                if (first.isPresent()) {
                    bookList.remove(first.get());
                    applicationStatus.setStatus(true);
                    System.out.println("Successfully remove book of if: " + idBook);
                    break;
                } else {
                    System.out.println("Did`int find any ids. Renter ID:");
                }
            }
        }

    }

    private int getBookIdFromUser() {
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
            System.out.println("Books file has successfully saved");
            fileWriter.close();


        } catch (IOException e) {
            System.out.println("Sorry, there was error with saving file");
        }

    }

}
