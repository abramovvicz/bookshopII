package utils;

import org.apache.commons.lang3.StringUtils;

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
        while (StringUtils.isNumeric(stringFromUser)) {
            System.out.println("You must enter String! Please write again");
            stringFromUser = scanner.nextLine();
        }
        return stringFromUser;
    }

}
