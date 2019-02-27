package utils;

import model.Author;
import model.Book;
import model.Category;
import model.FileTypes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilLoadFiles {


    public static List<Book> listFromBookFile = new ArrayList<>();
    public static List<Author> listFromAuthorFile = new ArrayList<>();
    public static List<Category> listFromCategoryFile = new ArrayList<>();
    private static UtilLoadFiles instance;
    private BufferedReader bufferedReader;
    private String[] data;

    private UtilLoadFiles() {
    }

    public static UtilLoadFiles getInstance() {
        if (instance == null) {
            synchronized (UtilLoadFiles.class) {
                if (instance == null) {
                    instance = new UtilLoadFiles();
                }
            }
        }
        return instance;
    }

    public BufferedReader createBuffer(String file) {
        try {
            return bufferedReader = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            System.out.println("Buffer is empty - please check all fillTypes addresses.");
            return null;
        }
    }

    public void readFiles(FileTypes fileTypes) {
        bufferedReader = createBuffer(fileTypes.getFileAdress());
        try {
            while (bufferedReader.ready()) {
                switch (fileTypes) {
                    case CATEGORIES:
                        loadCategoriesFile();
                        break;
                    case AUTHORS:
                        loadAuthorsFile();
                        break;
                    case BOOKS:
                        loadBooksFile();
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("All file have to be buffered and ready!");
        } catch (NullPointerException e) {
            System.out.println("All file have to be buffered and ready!");
            System.exit(1);
        }
    }


    public void loadBooksFile() throws IOException {

        data = splitStringFromBuffer();

        Category category = getCategory(data[6]);

        List<Author> listAuthorsForBook = getAuthorListForBook(data[5]);
        Book book = new Book(Integer.parseInt(data[0])
                , data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4], listAuthorsForBook, category);
        listFromBookFile.add(book);
    }

    private Category getCategory(String s) {
        int categoryID = Integer.parseInt(s);
        return listFromCategoryFile.stream().filter(x -> x.getCategoryID() == categoryID).findFirst().get();
    }

    private List<Author> getAuthorListForBook(String s) {
        String[] idsAuthors = s.split(",");
        List<Author> listAuthorsForBook = new ArrayList<>();

        for (int i = 0; i < idsAuthors.length; i++) {
            int finalI = i; //TODO: spytać Przemka - czemu taka zmienna;
            listAuthorsForBook.add(listFromAuthorFile
                    .stream().filter(x -> x
                            .getId() == Integer.valueOf(idsAuthors[finalI]))
                    .findFirst().get());
        }
        return listAuthorsForBook;
    }

    public void loadAuthorsFile() throws IOException {
        String[] s = splitStringFromBuffer();
        Author author = new Author(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]));
        listFromAuthorFile.add(author);

    }


    public void loadCategoriesFile() throws IOException {
        String[] s = splitStringFromBuffer();
        Category category = new Category(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]));
        listFromCategoryFile.add(category);
    }

    private String[] splitStringFromBuffer() throws IOException {
        return bufferedReader.readLine().split(";");
    }


    public void showAllBooks() {
        listFromBookFile.forEach(System.out::print);
    }


}


//TODO: to think about this****

//        Stream<String> stream = Files.lines(Paths.get(file));
//        String[] t = stream.map(x->x.split(";"));

      /*  for (int i = 0; i < listFromFile.size(); i++) {
            String[] someArray = listFromFile.get(i);
            for (int j = 0; j < someArray.length; j++) {
                System.out.println(someArray[j]);
            }
        }*/



/*                for (int i = 0; i < idsAuthors.length; i++) {
                    for (Author author : listFromAuthorFile) {
                        if (author.getId() == Integer.parseInt(idsAuthors[i])) {
                            listAuthorsForBook.add(author);
                        }
                    }
                }*/


