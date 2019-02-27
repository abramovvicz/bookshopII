package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

    public int getNumberFromUser() {
        int scannerTemp = 1;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(": ");
            scannerTemp = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You must enter number!");
        }
        return scannerTemp;

    }


}
