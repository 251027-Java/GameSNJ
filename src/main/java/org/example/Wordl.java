package org.example;
import java.util.Scanner;
import java.util.*;

public class Wordl {
    public static final String GREEN = "\u001B[32m";


    public static void main(String[] args) {
        System.out.println(GREEN + "This text is green.");
        //1 .given 5 letter blank word
        // guessedWord, correctWord
        //2. ask for input
        // userWord
        //3. compare to word
        // use correctWord as array string to compare individual guessed letters to letters in the correctWord
        //4. check if word was guessed
        //5. if correct player wins
        //6. show user wrong, correct, and partially correct letters
        //7. ask for new answer
        //8. update number of guesses our of 6
        //numGuesses
        //9. if not guessed correctly show user loses

        Scanner sc = new Scanner(System.in);
        String correctWord = "apple";
        String guess;
        int attempts = 6;

        while(attempts > 0) {
            System.out.print("Enter your guess: ");
            guess = sc.nextLine();

            if(isValidInput(guess, correctWord)) {
                System.out.println("Valid guess.");
                // continue with checks
            }else {
                attempts--;
            }

        }

    }

    public static boolean isValidInput(String userInput, String correctWord) {
        userInput = userInput.toUpperCase();

        if(userInput.isEmpty()) {
            System.out.println("The word cannot be empty.");
            return false;
        }

        if(!userInput.matches("[A-Z]+")) {
            System.out.println("The word must contain only letters (A-Z).");
            return false;
        }

        if(userInput.length() != correctWord.length()) {
            System.out.println("The word must be " + correctWord.length() + " letters long.");
            return false;
        }

        return true; // meets all valid input requirements
    }
}
