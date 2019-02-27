package utils;

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
    private static UtilLoadFiles instance;


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

    public List<Book> loadBookFile(String file) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader.ready()) {
                String[] s = bufferedReader.readLine().trim().split(";");
                int categoryID = Integer.parseInt(s[6]);
                Category category = listFromCategoryFile.stream().filter(x -> x.getCategoryID() == categoryID).findFirst().get();

                String[] idsAuthors = s[5].split(",");
                List<Author> listAuthorsForBook = new ArrayList<>();

                for (int i = 0; i < idsAuthors.length; i++) {
                    int finalI = i; //TODO: spytać Przemka
                    listAuthorsForBook.add(listFromAuthorFile
                            .stream().filter(x -> x
                                    .getId() == Integer.valueOf(idsAuthors[finalI]))
                            .findFirst().get());
                }


/*                for (int i = 0; i < idsAuthors.length; i++) {
                    for (Author author : listFromAuthorFile) {
                        if (author.getId() == Integer.parseInt(idsAuthors[i])) {
                            listAuthorsForBook.add(author);
                        }
                    }
                }*/


                Book book = new Book(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]), s[4], listAuthorsForBook, category);
                listFromBookFile.add(book);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie można odnaleźć ścieżki do pliku");
        }
        listFromBookFile.forEach(System.out::print);
        return listFromBookFile;
    }

    public List<Author> loadAuthorFile(String file) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader.ready()) {
                String[] s = bufferedReader.readLine().trim().split(";");
                Author author = new Author(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]));
                listFromAuthorFile.add(author);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie można odnaleźć ścieżki do pliku");
        }
        return listFromAuthorFile;

    }

    public List<Category> loadCategoryFile(String file) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader.ready()) {
                String[] s = bufferedReader.readLine().trim().split(";");
                Category category = new Category(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]));
                listFromCategoryFile.add(category);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie można odnaleźć ścieżki do pliku");
        }
//        listFromCategoryFile.forEach(System.out::print);
        return listFromCategoryFile;

    }


}


//        Stream<String> stream = Files.lines(Paths.get(file));
//        String[] t = stream.map(x->x.split(";"));

      /*  for (int i = 0; i < listFromFile.size(); i++) {
            String[] someArray = listFromFile.get(i);
            for (int j = 0; j < someArray.length; j++) {
                System.out.println(someArray[j]);
            }
        }*/

