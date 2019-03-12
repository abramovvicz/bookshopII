import dao.AuthorDAO;
import dao.CategoryDAO;
import enums.Binding;
import model.Author;
import model.Book;
import model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.UtilLoadFiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadFilesMethodTest {

    AuthorDAO authorDAO;
    CategoryDAO categoryDAO;
    UtilLoadFiles utilLoadFiles;

    @BeforeEach
    void setUp() {
        utilLoadFiles = new UtilLoadFiles();
        authorDAO = new AuthorDAO();
        categoryDAO = new CategoryDAO();
    }


    @Test
    void saveAuthorsToFile() {
        List<Author> authorTestList = new ArrayList<>();
        List<Author> listFromAuthorFile;

        Author author1 = new Author(1, "Andrzej Sapkowski", 59);
        Author author2 = new Author(2, "S. Lem", 99);
        authorTestList.add(author1);
        authorTestList.add(author2);

        authorDAO.saveAuthorListToFile(authorTestList);
        listFromAuthorFile = utilLoadFiles.loadAuthorFileNew("authorsTestFile.csv");
        author1 = listFromAuthorFile.get(0);
        author2 = listFromAuthorFile.get(1);

        assertEquals(author1.getId(), authorTestList.get(0).getId());
        assertEquals(author2.getId(), authorTestList.get(1).getId());
        assertEquals(author1.getFullName(), authorTestList.get(0).getFullName());
        assertEquals(author2.getFullName(), authorTestList.get(1).getFullName());
        assertEquals(author1.getAge(), authorTestList.get(0).getAge());
        assertEquals(author2.getAge(), authorTestList.get(1).getAge());
    }

    @Test
    void loadBookFile() {
        List<Book> bookTestList = new ArrayList<>();
        List<Book> listFromBookFile;

        Book book1 = new Book(1, "Title 1", 132350882, 2008, Binding.T, null, null);
        Book book2 = new Book(2, "Title 2", 134685997, 1923, Binding.M, null, null);
        Book book3 = new Book(2, "Title 3", 5678, 1923, Binding.M, null, null);
        Book book4 = new Book(2, "Title 4", 5678, 1923, Binding.M, null, null);
        Book book5 = new Book(2, "Title 5", 5678, 1923, Binding.M, null, null);
        Book book6 = new Book(2, "Title 6", 5678, 1923, Binding.M, null, null);
        bookTestList.add(book1);
        bookTestList.add(book2);
        bookTestList.add(book3);
        bookTestList.add(book4);
        bookTestList.add(book5);
        bookTestList.add(book6);

//        listFromAuthorFile = utilLoadFiles.loadAuthorFileNew("authorsTestFile.csv"); //TODO  nie trzeba aldowac kategorii i autorow
//        listFromCategoryList = utilLoadFiles.loadCategoryFileNew("categoriesTestFile.csv");
        listFromBookFile = utilLoadFiles.loadBookFileNew("booksTestFile.csv");
        assertEquals(listFromBookFile.get(1).getTitle(), bookTestList.get(1).getTitle());
        assertEquals(listFromBookFile.get(1).getIsbn(), bookTestList.get(1).getIsbn());

    }

    @Test
    void loadCategoryFile() {
        List<Category> categoryTestList = new ArrayList<>();
        List<Category> listFromCategoryList;
        Category category1 = new Category(1, "Java", 3);
        Category category2 = new Category(2, "Wzorce projektowe", 1);
        Category category3 = new Category(3, "Techniki programowania", 2);
        categoryTestList.add(category1);
        categoryTestList.add(category2);
        categoryTestList.add(category3);
        listFromCategoryList = utilLoadFiles.loadCategoryFileNew("categoriesTestFile.csv");
        assertEquals(listFromCategoryList.get(0).getCategoryID(), categoryTestList.get(0).getCategoryID());
        assertEquals(listFromCategoryList.get(1).getCategoryName(), categoryTestList.get(1).getCategoryName());
        assertEquals(listFromCategoryList.get(2).getPriority(), categoryTestList.get(2).getPriority());
    }
}
