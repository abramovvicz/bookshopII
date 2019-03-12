package view;

import dao.AuthorDAO;
import dao.CategoryDAO;
import dao.DataFromFiles;
import enums.FileTypes;
import functions.BookFunctions;
import functions.DataFunctions;
import utils.UserInput;
import utils.UtilLoadFiles;

public class MenuNavigation {

    AuthorDAO authorDAO = new AuthorDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    private UserInput userInput = new UserInput();
    private UtilLoadFiles utilLoadFiles = new UtilLoadFiles();
    private DataFunctions dataFunctions = new DataFunctions();
    private BookFunctions bookFunctions = new BookFunctions();
    private DataFromFiles dataFromFiles = DataFromFiles.getInstance();
    private Menu menu = new Menu();

    public MenuNavigation() {
        utilLoadFiles.loadAuthorFileNew(FileTypes.AUTHORS.getFileAdress());
        utilLoadFiles.loadCategoryFileNew(FileTypes.CATEGORIES.getFileAdress());
        utilLoadFiles.loadBookFileNew(FileTypes.BOOKS.getFileAdress());
    }

    public void menuNavigation() {
        int numberFromUser = 0;
        do {
            menu.showMenu();
            numberFromUser = userInput.getNumberFromUser("Enter number:");

            if (numberFromUser > 14) {
                System.out.println("Please enter vaild menu number");
            }

            chooseOptionMenu(numberFromUser);

        } while (numberFromUser != 2);

    }

    public void chooseOptionMenu(int inputNumber) {
        switch (inputNumber) {
            case 0:
                menu.showMenu();
                break;
            case 1:
                System.out.println("Bookshop email: contact@bookshop.pl");
                break;
            case 2:
                System.out.println("Exit from program");
                break;
            case 3:
                dataFunctions.showAllBooks();
                break;
            case 4:
                dataFunctions.showAllAuthors();
                break;
            case 5:
                dataFunctions.showAllCategories();
                break;
            case 6:
                authorDAO.getDataFromUserAboutNewAuthor();
                break;
            case 7:
                categoryDAO.getDataFromUserAboutNewCategory();
                break;
            case 8:
                categoryDAO.getCategoryIdFromUser();
                break;
            case 9:
                authorDAO.saveAuthorListToFile(dataFromFiles.getListFromAuthorFile());
                break;
            case 10:
                bookFunctions.sortBooksByYearASC(utilLoadFiles.listFromBookFile);
                break;
            case 11:
                bookFunctions.sortBooksByYearDESC(utilLoadFiles.listFromBookFile);
                break;
            case 12:
                bookFunctions.returnBookAfter2003(utilLoadFiles.listFromBookFile);
                break;
            case 13:
                dataFunctions.showBooksFromDesignPatternsCategory();
                break;
            case 14:
                System.out.println(dataFunctions.showBooksChosenAuthorByUser());
                break;
            default:
                break;
        }
    }


}
