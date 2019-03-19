package dao;

import lombok.Getter;
import lombok.Setter;
import model.Author;
import model.Book;
import model.Category;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class DataFromFiles {

    private static DataFromFiles instance = new DataFromFiles();
    private List<Book> listFromBookFile = new ArrayList<>();
    private List<Author> listFromAuthorFile = new ArrayList<>();
    private List<Category> listFromCategoryFile = new ArrayList<>();

    private DataFromFiles() {
    }

    public static DataFromFiles getInstance() {
        if (instance == null) {
            synchronized (DataFromFiles.class) {
                if (instance == null) {
                    instance = new DataFromFiles();
                }
            }
        }
        return instance;
    }

}
