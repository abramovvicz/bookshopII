package view;

import dao.AuthorDAO;
import dao.BookDAO;
import dao.CategoryDAO;
import dao.DataFromFiles;
import enums.FileTypes;
import functions.BookFunctions;
import functions.DataFunctions;
import utils.CheckApplicationState;
import utils.UserInput;
import utils.UtilLoadFiles;
import utils.UtilSaveFiles;

public class MenuNavigation {

    private AuthorDAO authorDAO = new AuthorDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();
    private BookDAO bookDAO = new BookDAO();
    private CheckApplicationState checkApplicationState = CheckApplicationState.getInstance();
    private UserInput userInput = new UserInput();
    private UtilLoadFiles utilLoadFiles = new UtilLoadFiles();
    private UtilSaveFiles utilSaveFiles = new UtilSaveFiles();
    private DataFunctions dataFunctions = new DataFunctions();
    private BookFunctions bookFunctions = new BookFunctions();
    private DataFromFiles dataFromFiles = DataFromFiles.getInstance();
    private Menu menu = new Menu();

    public MenuNavigation() {
        utilLoadFiles.loadAuthorFileNew(FileTypes.AUTHORS.getFileAddress());
        utilLoadFiles.loadCategoryFileNew(FileTypes.CATEGORIES.getFileAddress());
        utilLoadFiles.loadBookFileNew(FileTypes.BOOKS.getFileAddress());
    }

    private void saveAllFiles() {
        utilSaveFiles.saveAuthorListToFile(dataFromFiles.getListFromAuthorFile());
        utilSaveFiles.saveCategoryListToFile(dataFromFiles.getListFromCategoryFile());
        utilSaveFiles.saveBookToFile(dataFromFiles.getListFromBookFile());
        System.out.println("Save files successful");
    }


    public void menuNavigation() {
        int numberFromUser;
        do {
            menu.showMenu();
            System.out.println("Enter number:");
            numberFromUser = userInput.getNumberFromUser();

            if (numberFromUser > 21) {
                System.out.println("Please enter vaild menu number");
            }

            chooseOptionMenu(numberFromUser);

        } while (numberFromUser != 2);

    }

    private void chooseOptionMenu(int inputNumber) {
        switch (inputNumber) {
            case 0:
                menu.showMenu();
                break;
            case 1:
                System.out.println("Bookshop email: contact@bookshop.pl");
                break;
            case 2:
                if (checkApplicationState.isStatus()) {
                    System.out.println("Data has modified do You want to save? Chose: Y/N");
                    String txtFromUser = userInput.getStringFormUser();
                    if (txtFromUser.equalsIgnoreCase("y")) {
                        saveAllFiles();
                        System.out.println("Exit from program");
                        break;
                    } else {
                        System.out.println("Exit from program");
                        break;
                    }
                }
                System.out.println("Nothing to save...");
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
                utilSaveFiles.saveAuthorListToFile(dataFromFiles.getListFromAuthorFile());
                break;
            case 10:
                utilSaveFiles.saveBookToFile(dataFromFiles.getListFromBookFile());
                break;
            case 11:
                bookFunctions.sortBooksByYearASC(utilLoadFiles.listFromBookFile);
                break;
            case 12:
                bookFunctions.sortBooksByYearDESC(utilLoadFiles.listFromBookFile);
                break;
            case 13:
                bookFunctions.returnBookAfter2003(utilLoadFiles.listFromBookFile);
                break;
            case 14:
                dataFunctions.showBooksFromDesignPatternsCategory();
                break;
            case 15:
                System.out.println(dataFunctions.showBooksChosenAuthorByUser());
                break;
            case 16:
                bookDAO.deleteBookByIdStream(dataFromFiles.getListFromBookFile());
                break;
            case 17:
                authorDAO.deleteAuthorsByID(dataFromFiles.getListFromAuthorFile());
                break;
            case 18:
                categoryDAO.deleteCategoryByIDStream(dataFromFiles.getListFromCategoryFile());
                break;
            case 19:
                saveAllFiles();
                break;
            case 20:
                authorDAO.editAuthorAgeByUserStream(dataFromFiles.getListFromAuthorFile());
                break;
            case 21:
                System.out.println("Change view books as: Year/Title/Isbn");
                dataFunctions.setPrintStrategy(new YearTitleIsbnBookPrintStrategyImpl());
                break;
            case 22:
                System.out.println("Change view books as: Title/Year/Isbn");
                dataFunctions.setPrintStrategy(new TitleYearIsbnBookPrintStrategyImpl());
                break;
            case 23:
                System.out.println("Change view books as: Isbn/Title/Year");
                dataFunctions.setPrintStrategy(new IsbnTitleYearBookPrintStrategyImpl());
                break;
            default:
                break;
        }
    }


}
