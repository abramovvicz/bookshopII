package utils;

import dao.DataFromFiles;
import enums.Binding;
import model.Author;
import model.Book;
import model.Category;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilLoadFiles {


    public static List<Book> listFromBookFile = new ArrayList<>();
    public static List<Author> listFromAuthorFile = new ArrayList<>();
    public static List<Category> listFromCategoryFile = new ArrayList<>();
    public DataFromFiles dataFromFiles = DataFromFiles.getInstance();
    private String splitter = ";";

    public List<Author> loadAuthorFileNew(String nameFile) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(nameFile));
            while (bufferedReader.ready()) {
                String[] dataFromFile = bufferedReader.readLine().split(splitter);
                Author author = new Author(Integer.parseInt(dataFromFile[0]), dataFromFile[1], Integer.parseInt(dataFromFile[2]));
                listFromAuthorFile.add(author);
                dataFromFiles.setListFromAuthorFile(listFromAuthorFile);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("File load failure. File not exists");

        }
        return listFromAuthorFile;
    }

    public List<Category> loadCategoryFileNew(String nameFile) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(nameFile));
            while (bufferedReader.ready()) {
                String[] dataFromFile = bufferedReader.readLine().split(splitter);
                Category category = new Category(Integer.parseInt(dataFromFile[0]), dataFromFile[1], Integer.parseInt(dataFromFile[2]));
                listFromCategoryFile.add(category);
                dataFromFiles.setListFromCategoryFile(listFromCategoryFile);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Buffer isnt ready");

        }
        return listFromCategoryFile;
    }

    public List<Book> loadBookFileNew(String nameFile) {
        String[] dataFromFile;
        BufferedReader bufferedReader = null;
        Category category;
        List<Author> listAuthorsForBook = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(nameFile));
            while (bufferedReader.ready()) {
                dataFromFile = bufferedReader.readLine().split(splitter);

                if (dataFromFiles.getListFromAuthorFile().isEmpty() || dataFromFile.length == 5) {
                    category = null;
                    listAuthorsForBook = null;
                } else {
                    category = getCategory(dataFromFile[6], dataFromFiles.getListFromCategoryFile());
                    listAuthorsForBook = getAuthorListForBook(dataFromFile[5]);
                }
                Book book = new Book(Integer.parseInt(dataFromFile[0])
                        , dataFromFile[1], Integer.parseInt(dataFromFile[2]), Integer.parseInt(dataFromFile[3]),
                        Binding.valueOf(dataFromFile[4]), listAuthorsForBook, category);
                listFromBookFile.add(book);
                dataFromFiles.setListFromBookFile(listFromBookFile);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("File load failure. File not exists");

        }
        return listFromBookFile;
    }

    private Category getCategory(String categoriesIDS, List<Category> listFromCategoryFile) {
        return listFromCategoryFile.stream().filter(x -> x.getCategoryID() == Integer.parseInt(categoriesIDS)).findFirst().get();
    }

    public List<Author> getAuthorListForBook(String authors) {
        String[] idsAuthors = authors.split(",");
        List<Author> listAuthorsForBook = new ArrayList<>();

        if (idsAuthors.length == 0) {
            System.out.println("nie ma autorów");
        }
        for (String idsAuthor : idsAuthors) {
            listAuthorsForBook.add(dataFromFiles.getListFromAuthorFile()
                    .stream().filter(x -> x.getId() == Integer.valueOf(idsAuthor))
                    .findFirst().get());
        }
        return listAuthorsForBook;
    }

}
/*
for (int i = 0; i < idsAuthors.length; i++) {
        int finalI = i; //ponieważ nie można w streamie zmieniać zmiennej
        listAuthorsForBook.add(dataFromFiles.getListFromAuthorFile()
        .stream().filter(x -> x.getId() == Integer.valueOf(idsAuthors[finalI]))
        .findFirst().get());
        }*/
