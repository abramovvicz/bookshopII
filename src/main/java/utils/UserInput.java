package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    public Scanner scanner = new Scanner(System.in);

    public int getNumber() {
        try {
            System.out.println("Choose option menu: ");
            return scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("You must enter number!");
        }
        return Integer.parseInt(null); //TODO: ask how to resolved this issue
    }


}
