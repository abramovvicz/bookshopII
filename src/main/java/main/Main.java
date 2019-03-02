package main;

import model.AuthorDAO;
import model.BookDAO;
import model.CategoryDAO;
import view.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.menuNavigation();
//        CategoryDAO categoryDAO = new CategoryDAO();
//        AuthorDAO authorDAO = new AuthorDAO();
        BookDAO bookDAO = new BookDAO();

    }

}
