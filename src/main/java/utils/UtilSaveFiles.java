package utils;

import enums.FileTypes;
import model.Author;
import model.Book;
import model.Category;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilSaveFiles {


    public void saveCategoryListToFile(List<Category> categoryList) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(FileTypes.NEW_CATEGORIES.getFileAddress());
            for (Category category : categoryList) {
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder pattern = stringBuilder.append(category.getCategoryID() + ";" + category.getCategoryName() + ";" + category.getPriority());
                fileWriter.write(String.valueOf(pattern));
                fileWriter.write("\n");

            }
            System.out.println("Category file has successfully saved");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("There was some problem");
        }
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
                StringBuilder pattern = new StringBuilder();
                pattern.append(book.getId() + ";" + book.getTitle() + ";" + book.getIsbn() + ";"
                        + book.getYear() + ";" + book.getBinding() + ";" + authorsToString + ";" +
                        book.getCategory().getCategoryID());
                fileWriter.write(String.valueOf(pattern));
                fileWriter.write("\n");
            }
            System.out.println("Books file has successfully saved");
            fileWriter.close();


        } catch (IOException e) {
            System.out.println("Sorry, there was error with saving file");
        }

    }

    public void saveAuthorListToFile(List<Author> listOFAuthors) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(FileTypes.NEW_AUTHORS.getFileAddress());
            for (Author listOFAuthor : listOFAuthors) {
                StringBuilder pattern = new StringBuilder();
                pattern.append(listOFAuthor.getId() + ";" + listOFAuthor.getFullName() + ";" + listOFAuthor.getAge());
                fileWriter.write(String.valueOf(pattern));
                fileWriter.write("\n");

            }
            System.out.println("Author file has successfully saved");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("There was some problem");
        }
    }
}
