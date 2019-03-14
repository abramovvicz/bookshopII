package utils;

import dao.DataFromFiles;
import enums.Binding;
import model.Author;
import model.Book;
import model.Category;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilLoadFiles {


    public static List<Book> listFromBookFile = new ArrayList<>();
    public static List<Author> listFromAuthorFile = new ArrayList<>();
    public static List<Category> listFromCategoryFile = new ArrayList<>();
    public DataFromFiles dataFromFiles = DataFromFiles.getInstance();


    public List<Author> loadAuthorFileNew(String nameFile) {
        boolean bufferStatus = false;
        BufferedReader bufferedReader = null;
        String sCurrentLine;

      
        try {
            bufferedReader = new BufferedReader(new FileReader(nameFile));
            bufferStatus = true;
        } catch (FileNotFoundException e) {
            System.out.println("File load failure");

        }
        while (bufferStatus) {   //TODO czy to o chodziło? // pomyslec czy da sie inaczej niz while(true)
            try {
                if (!bufferedReader.ready()) {
                    break;
                }
                String[] dataFromFile = bufferedReader.readLine().split(";");
                Author author = new Author(Integer.parseInt(dataFromFile[0]), dataFromFile[1], Integer.parseInt(dataFromFile[2]));
                listFromAuthorFile.add(author);
                dataFromFiles.setListFromAuthorFile(listFromAuthorFile);
            } catch (IOException e) {
                System.out.println("File load failure");
            }

        }
        return listFromAuthorFile;
    }


    public List<Category> loadCategoryFileNew(String nameFile) {
        boolean bufferStatus = false;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(nameFile));
            bufferStatus = true;
        } catch (FileNotFoundException e) {
            System.out.println("File not exists");
        }
        while (bufferStatus) {
            try {
                if (!bufferedReader.ready()) {
                    break;
                }
                String[] dataFromFile = bufferedReader.readLine().split(";");
                Category category = new Category(Integer.parseInt(dataFromFile[0]), dataFromFile[1], Integer.parseInt(dataFromFile[2]));
                listFromCategoryFile.add(category);
                dataFromFiles.setListFromCategoryFile(listFromCategoryFile);
            } catch (IOException e) {
                System.out.println("File not exists");
            }

        }
        return listFromCategoryFile;
    }

    public List<Book> loadBookFileNew(String nameFile) {
        boolean bufferStatus = false;
        String[] dataFromFile;
        BufferedReader bufferedReader = null;
        Category category;
        List<Author> listAuthorsForBook;
        try {
            bufferedReader = new BufferedReader(new FileReader(nameFile));
            bufferStatus = true;
        } catch (FileNotFoundException e) {
            System.out.println("File not exists");
        }
        while (bufferStatus) {
            try {
                if (!bufferedReader.ready()) {
                    break;
                }
                dataFromFile = bufferedReader.readLine().split(";");

                if (dataFromFile.length == 5) {
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
            } catch (IOException e) {
                System.out.println("Buffer is not ready");

            }
        }
        return listFromBookFile;

    }

    private Category getCategory(String categoriesIDS, List<Category> listFromCategoryFile) {
        return listFromCategoryFile.stream().filter(x -> x.getCategoryID() == Integer.parseInt(categoriesIDS)).findFirst().get();
    }

    public List<Author> getAuthorListForBook(String authors) {
        String[] idsAuthors = authors.split(",");
        List<Author> listAuthorsForBook = new ArrayList<>();

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
