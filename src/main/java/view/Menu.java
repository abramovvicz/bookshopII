package view;

import model.AuthorDAO;
import model.CategoryDAO;
import utils.UserInput;
import utils.UtilLoadFiles;

public class Menu {

    private UserInput userInput = new UserInput();
    private UtilLoadFiles utilLoadFiles = UtilLoadFiles.getInstance();
    private AuthorDAO authorDAO = new AuthorDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();


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
        System.out.println("*************************************************");

    }

    public void menuNavigation() {
        int number;
        do {
            showMenu();
            number = userInput.getNumberFromUser();
            chooseOptionMenu(number);
            System.out.println("Number " + number);
        } while (number != 2);
    }

    public void chooseOptionMenu(int inputNumber) {
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
                //todo add new categories

                categoryDAO.getDataFromUserAboutNewCategory();

                break;
            default:
                break;
//                showMenu();
        }
    }


}
