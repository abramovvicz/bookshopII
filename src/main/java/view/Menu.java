package view;

import utils.UserInput;

public class Menu {

    private int number = 0;
    private UserInput userInput = new UserInput();

    public void showMenu() {

        System.out.println();
        System.out.println("*************************************************");
        System.out.println("      MENU -> choose option                      ");
        System.out.println("                                                 ");
        System.out.println("      1. Show adress email                       ");
        System.out.println("                                                 ");
        System.out.println("      2. Exti program                            ");
        System.out.println("                                                 ");
        System.out.println("      3. Show books                              ");
        System.out.println("*************************************************");

    }

    public void chooseOptionMenu() {
        showMenu();
        while (number != 2) {
            number = userInput.getNumber();

            switch (number) {
                case 1:
                    System.out.println("Adres księgarni to: kontakt@ksiegarnia.pl");
                    break;
                case 2:
                    // wyjście z programu
                    break;
                case 3:
                    //pokazuje książki
                    break;
                default:
                    showMenu();
            }
        }
    }

}
