package utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class UserInput {

    public int getNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        int numberFromUser;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Please it has to be number. Write again");
                scanner.next();
            }
            numberFromUser = scanner.nextInt();
        } while (numberFromUser < 0);
        return numberFromUser;
    }

    public String getStringFormUser() {
        String stringFromUser;
        Scanner scanner = new Scanner(System.in);
        stringFromUser = scanner.nextLine();
        while (StringUtils.isNumeric(stringFromUser)) {
            System.out.println("You must enter String! Please write again");
            stringFromUser = scanner.nextLine();
        }
        return stringFromUser;
    }

}
