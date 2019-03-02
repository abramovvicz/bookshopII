package view;

import model.AuthorDAO;
import model.CategoryDAO;
import utils.UserInput;
import utils.UtilLoadFiles;

import java.io.IOException;

public class Menu {

    private UserInput userInput = new UserInput();
    private UtilLoadFiles utilLoadFiles = UtilLoadFiles.getInstance();
    private AuthorDAO authorDAO = new AuthorDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();

    public Menu() throws IOException {
    }


    public void showMenu() {


        System.out.println();
        System.out.println("*************************************************");
        System.out.println("      MENU -> choose option                      ");
        System.out.println("                                                 ");
        System.out.println("      1. Show adress email                       ");
        System.out.println("                                                 ");
        System.out.println("      2. Exti program                            ");
        System.out.println("                                                 ");
        System.out.println("      3. Show all Books                          ");
        System.out.println("                                                 ");
        System.out.println("      4. Show all Authors                        ");
        System.out.println("                                                 ");
        System.out.println("      5. Show all Categories                     ");
        System.out.println("                                                 ");
        System.out.println("      6. Add new Author                          ");
        System.out.println("                                                 ");
        System.out.println("      7. Add new Category                        ");
        System.out.println("                                                 ");
        System.out.println("      8. Save authors to file                   ");
        System.out.println("*************************************************");

    }

    private void showCategoryMenus() {
        System.out.println();
        System.out.println("*************************************************");
        System.out.println("      Category menu -> choose option             ");
        System.out.println("                                                 ");
        System.out.println("      1. Show only category names                ");
        System.out.println("                                                 ");
        System.out.println("      2. Show  all categories                    ");
        System.out.println("                                                 ");
        System.out.println("      3. Show all Books                          ");
        System.out.println("                                                 ");
        System.out.println("      4. Show all Authors                        ");
        System.out.println("                                                 ");
        System.out.println("      5. back to Main Menu                       ");
        System.out.println("*************************************************");
    }

    public void menuNavigation() throws IOException {
        int number;
        do {
            showMenu();
            number = userInput.getNumberFromUser();
            chooseOptionMenu(number);
            System.out.println("Number " + number);
        } while (number != 2);
    }

    public void chooseOptionMenu(int inputNumber) throws IOException {
        switch (inputNumber) {
            case 1:
                System.out.println("Adres księgarni to: kontakt@ksiegarnia.pl");
                break;
            case 2:
                // wyjście z programu
                break;
            case 3:
                utilLoadFiles.showAllBooks();
                break;
            case 4:
                utilLoadFiles.showAllAuthors();
                break;
            case 5:
                utilLoadFiles.showAllCategories();
                break;
            case 6:
                authorDAO.getDataFromUserAboutNewAuthor();
                break;
            case 7:
                categoryDAO.getDataFromUserAboutNewCategory();
                break;

            case 8:
              authorDAO.saveAuthorListToFile();
                break;
            default:
                break;
//                showMenu();
        }
    }


}
