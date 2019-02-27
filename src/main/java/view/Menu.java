package view;

import utils.UserInput;
import utils.UtilLoadFiles;

public class Menu {

    private UserInput userInput = new UserInput();
    private UtilLoadFiles utilLoadFiles = UtilLoadFiles.getInstance();

    public void showMenu() {

        System.out.println();
        System.out.println("*************************************************");
        System.out.println("      MENU -> choose option                      ");
        System.out.println("                                                 ");
        System.out.println("      1. Show adress email                       ");
        System.out.println("                                                 ");
        System.out.println("      2. Exti program                            ");
        System.out.println("                                                 ");
        System.out.println("      3. Show all books                           ");
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
            default:
                break;
//                showMenu();
        }
    }

}
