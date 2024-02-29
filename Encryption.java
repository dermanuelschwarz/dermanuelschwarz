

/*
 * Encryption_Uebungsbeispiel_7
 * program to en - and decrypt text using text and parameters inputted by user. Works with classes TextEncrypt and Menu
 * Author: Manuel Schwarz
 * Last Change: 7.12.2023
 */


public class Encryption {


    public static void main(String[] args) {

        int userInput;
        Menu menu = new Menu();                                                  //new Object menu
        TextEncrypt textEncrypt = new TextEncrypt();                             //new Object textEncrypt

        do
        {                                                                       //do while loop so the programm alsways ask for new user input
                                                                                //as long as user does not give input == 9 (Quit)
            userInput = menu.menu();                                           //userInput gets initialized with the menu method form the menu class
            if (userInput == 1) {                                                //if user gives input == 1
                int rotation = textEncrypt.getRotationInput(userInput);                //method encryptRotation from class textEncrypt asks for input to use as rotation varialbe
                String textToEncrypt = textEncrypt.getText(rotation);                   //method getText from textEncrypt asks for String from user
                textEncrypt.printCryptedText(textToEncrypt, rotation);        //method printEncryptedText uses the given String and encrypts String with rotation given previously
            } else if (userInput == 2) {                                        //else if user gives input == 2
                int rotation = textEncrypt.getRotationInput(userInput);                //method getEnOrDecryptRotation from class textEcrypt asks for input to use as rotation varialbe
                String textToDecrypt = textEncrypt.getText(rotation);         //method getTextToEecrypt from textEecrypt asks for String from user
                textEncrypt.printCryptedText(textToDecrypt, rotation);        //method printEnOrDecryptedText uses the given String and dercrypts String with rotation given previously
            }

        } while (userInput != 9);       //do loop breaks if userInput == 9
        menu.closeScanner();
        textEncrypt.closeScanner();
    }
}