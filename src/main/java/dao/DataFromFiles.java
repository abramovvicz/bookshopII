package dao;

import model.Author;
import model.Book;
import model.Category;

import java.util.ArrayList;
import java.util.List;

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

    public List<Category> getListFromCategoryFile() {
        return listFromCategoryFile;
    }

    public void setListFromCategoryFile(List<Category> listFromCategoryFile) {
        this.listFromCategoryFile = listFromCategoryFile;
    }

    public List<Author> getListFromAuthorFile() {
        return listFromAuthorFile;
    }

    public void setListFromAuthorFile(List<Author> listFromAuthorFile) {
        this.listFromAuthorFile = listFromAuthorFile;
    }

    public List<Book> getListFromBookFile() {
        return listFromBookFile;
    }

    public void setListFromBookFile(List<Book> listFromBookFile) {
        this.listFromBookFile = listFromBookFile;
    }
}
