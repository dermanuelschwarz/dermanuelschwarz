/*
 * Encryption_Uebungsbeispiel_7
 * class print out a menu for main clas Encryption
 * Author: Manuel Schwarz
 * Last Change: 7.12.2023
 */

import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private int userInput;

    /*
     * prints out the main menu for the user, including seperation lines and command overview
     */
    static int baseMenu() {
        int z = 1;
        for (int i = 0; i < 80; i++) {
            if (i <= 80) {
                System.out.print("-");
            }
        }
        System.out.println("");
        System.out.println("1 - Encrypt text");
        System.out.println("2 - Decrypt text");
        System.out.println("9 - Quit");

        for (int counter = 0; counter < 80; counter++) {
            if (counter <= 80) {
                System.out.print("-");
            }
        }
        System.out.println("");
        return z;
    }

    /*
     * gets an input from user; input has to be 1, 2 or 9; returns one of the three possible int values
     */
    static int menu() {
        baseMenu();
        int input;
        while (true) {
            System.out.print("> ");                         // double blank space
            if (scanner.hasNextInt()) {                     //checks if input is int
                input = scanner.nextInt();                // initializes variable with value of scanner
                if (scanner.nextLine().equals("")) {        // checks if next line is empty
                    if ((input == 1) || (input == 2) || (input == 9)) {                      // checks if int is 1 ,2 or 9
                        break;
                    } else {
                        baseMenu();
                    }
                } else {
                    baseMenu();
                    scanner.nextLine();
                }
            } else {
                baseMenu();
                scanner.nextLine();
            }
        }
        return input;
    }

    /*
     * closes Scanner
     */
    static void closeScanner() {
        scanner.close();
    }
}

