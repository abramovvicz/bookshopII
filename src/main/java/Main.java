import model.AuthorDAO;
import model.BookDAO;
import view.Menu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        AuthorDAO author = new AuthorDAO();
        BookDAO bookDAO = new BookDAO();
        Menu menu = new Menu();
        menu.chooseOptionMenu();

    }

}
