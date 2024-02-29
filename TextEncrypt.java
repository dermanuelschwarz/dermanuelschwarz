/*
 * Encryption_Uebungsbeispiel_7
 * class to en - and decrypt text using text and parameters inputted by user for main class Encryption
 * Author: Manuel Schwarz
 * Last Change: 7.12.2023
 */

import java.util.Scanner;

public class TextEncrypt {

    private static Scanner scanner = new Scanner(System.in);        //scanner as a class variable
    private int rotation;                                           //class variable rotation
    private String baseText;                                        //class String baseText


    /*
     * gets an input from user; the input sets by how much each position of the String is rotated
     */
    static int getRotationInput(int userInput) {

        int rotation;

        while (true) {                              //while loop getting int input from user; only stops if input is int greater zero and nextLine is empty
            System.out.print("  Enter rotation: ");
            if (scanner.hasNextInt()) {
                rotation = scanner.nextInt();
                if (scanner.nextLine().equals("")) {
                    if (userInput == 1) {
                        if (rotation > 0) {
                            break;
                        }
                    }
                    if (userInput == 2) {
                        if (rotation < 0) {
                            break;
                        }
                    }
                }
            } else {
                scanner.nextLine();
            }
        }
        return rotation;
    }

    /*
     * gets an input from user; input is the String which will be encrypted
     */
    static String getText(int rotation) {
        String baseText = "";

        if (rotation > 0) {
            System.out.print("  Enter text to encrypt: ");
        } else {
            System.out.print("  Enter text to decrypt: ");
        }
        if (scanner.hasNextLine()) {
            baseText = scanner.nextLine();
        }
        return baseText;
    }

    /*
     * shifts a letter using the ceasar cipher, needs a char and a int
     */
    static char shiftLetter(char ch, int rotation) {
        char base;                          //char variable called base used to determine if char is upper or lower case
        int lettersInAlphabet = 26;         //lettersInAlphabet is the number of letters in the english alphabet (A-Z & a-z)
        if (Character.isUpperCase(ch)) {    //if a char is uppercase --> base becomes 'A', else 'a'; determines the starting point of the rotation
            base = 'A';
        } else {
            base = 'a';
        }
        return (char) (((ch - base + rotation) % lettersInAlphabet + lettersInAlphabet) % lettersInAlphabet + base);
        /*caesar cipher rotation; result gets casted to char;
         * calculation with ASCII values of chars;
         * (ASCII(ch) - ASCII(A or a) + rotation(>0) + 26) % 26 + ASCII(A or a)
         * this ASCII value gets casted to char and we have a roatated char
         * ch - base = calculates the position of the letter in the alphabet
         * + rotation = shifts the position by rotation; +26 = ensures result is positive
         * % 26 = ensures result is in range of the alphabet
         * + base = brings result back to ASCII range of upper and lowercase letters
         */
    }

    /*
     * shifts a digit using the ceasar cipher, needs a char and a int
     */
    static char shiftDigit(char ch, int rotation) {
        int numberFromZeroToNine = 10;
        return (char) ((ch - '0' + rotation + numberFromZeroToNine) % numberFromZeroToNine + '0');
        /*caesar cipher rotation; result gets casted to char;
         * calculation with ASCII values of chars;
         * (ASCII(ch) - ASCII('0') + rotation(>0) + 10) % 10 + ASCII('0'')
         * this ASCII value gets casted to char and we have a roatated char
         * ch - '0' = calculates the position of the digit in the range 0-9
         * + rotation = shifts the position by rotation; +10 = ensures result is positive
         * % 10 = ensures result is in range of 0-9
         * + '0' = brings result back to ASCII range of digits
         */
    }

    /*
     * checks if char is Umlaut
     */
    static boolean isUmlaut(char ch) {

        return ch == 'ä' || ch == 'ö' || ch == 'ü' || ch == 'Ä' || ch == 'Ö' || ch == 'Ü';      // Check if the character is an Umlaut (ä, ö, ü, Ä, Ö, Ü)
    }

    /*
     * uses a char array and the two "shift" methods from above to rotate chars; returns a new string
     */
    static String shiftCharacters(String baseText, int rotation) {

        char[] resultArray = new char[baseText.length()];
        int index = 0;

        for (char ch : baseText.toCharArray()) {                     // Loop through each character in the input string
            if (Character.isLetter(ch) && !isUmlaut(ch)) {           // Check if the character is a letter and not a Umlaut
                resultArray[index++] = shiftLetter(ch, rotation);    // If a letter, apply shiftLetter method
            } else if (Character.isDigit(ch)) {                      // Check if the character is a digit
                resultArray[index++] = shiftDigit(ch, rotation);     // If a digit, apply shiftDigit method
            } else {                                                 // If the character is neither a letter nor a digit, leave it unchanged
                resultArray[index++] = ch;
            }
        }
        return new String(resultArray, 0, index);
        /* Convert the char array to a String and return;
         * 0 = starting point of array form which will be converted into string
         * index = ending point of said conversion up to x index cahrs will be included in Sting
         */
    }

    /*
     * prints out the encrypted text
     */
    static void printCryptedText(String baseText, int rotation) {
        String enOrDecryptedText = shiftCharacters(baseText, rotation);     //initializes String encryptetText with return value of shiftCharacters
        System.out.println("  " + enOrDecryptedText);                       //prints out String with two leading spaces
    }

    /*
     * closes Scanner
     */
    static void closeScanner() {
        scanner.close();
    }
}




