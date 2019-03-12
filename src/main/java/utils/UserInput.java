package utils;

import java.util.Scanner;

public class UserInput {

    public int getNumberFromUser(String message) {
        Scanner scanner = new Scanner(System.in);
        int numberFromUser;
        do {
            System.out.println(message);
            while (!scanner.hasNextInt()) {
                System.out.println("Please it have to be number. Write again");
                scanner.next();
            }
            numberFromUser = scanner.nextInt();
        } while (numberFromUser <= 0);
        return numberFromUser;
    }

    public String getStringFormUser(String message) {
        String stringFromUser;
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        stringFromUser = scanner.nextLine();
        while (!isAlphabet(stringFromUser)) {
            System.out.println("You must enter String! Please write again");
            stringFromUser = scanner.nextLine();
        }
        return stringFromUser;
    }

    private boolean isAlphabet(String s) {
        return s.matches("[A-Z a-z]+");
    }
}
