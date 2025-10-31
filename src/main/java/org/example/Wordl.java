package org.example;
import java.util.Scanner;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.example.ColoredLetters.*;


public class Wordl {
    //public static final String GREEN = "\u001B[32m";
    public static String correctWord;
    int guessesLeft = 6;
    public static boolean gameWon = false;
    public static List<String> myStringList = new ArrayList<>();
    public static int attempts = 6;
    static void main() {

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
        String guess;
        correctWord = chooseWord();
        IO.println(correctWord);

        while(attempts > 0) {
            System.out.println(ColoredLetters.RESET + "You have " + attempts + " attempts left: ");
            System.out.print(ColoredLetters.RESET + "\nEnter your guess: ");
            guess = sc.nextLine();

            if (!isValidInput(guess, correctWord)) {
                continue;
            }
            if (checkUserGuess(guess, correctWord, attempts)) { //Objects.equals(guess, correctWord)
                System.out.println("The word was " + correctWord + " you win!");
                break;
            }
            //IO.println(wordl.checkUserGuess(guess, correctWord, attempts));
            attempts--;

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

    public static String chooseWord() {
        try {

            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/example/words.txt"));
            String line = reader.readLine();
            List<String> words = new ArrayList<String>();
            while (line != null) {
                String[] wordsLine = line.split(" ");
                words.addAll(Arrays.asList(wordsLine));
                line = reader.readLine();
            }

            Random rand = new Random(System.currentTimeMillis());
            correctWord = words.get(rand.nextInt(words.size()));
        } catch (Exception e) { IO.println("File not found!");}
        return correctWord;
    }
    public static boolean checkUserGuess(String guess, String correctWord, int attempts) {
        StringBuilder returnWord = new StringBuilder(); //Creates an empty String for the word to be returned
        if (guess.toUpperCase().equals(correctWord.toUpperCase())) {
            gameWon = true;        //if the guessed word is the same as the correct word sets the game won setting to true
            returnWord = new StringBuilder((GREEN + correctWord));    //and returns an all green word
            return gameWon;
        }
        for (int i = 0; i < correctWord.length(); i++){
            if (guess.charAt(i) == correctWord.charAt(i)){
                returnWord.append(GREEN).append(guess.charAt(i));
            }
            else if(correctWord.indexOf(guess.charAt(i)) != -1){
                returnWord.append(YELLOW).append(guess.charAt(i));
            }
            else{
                returnWord.append(RESET).append(guess.charAt(i));
            }
        }
        myStringList.add(returnWord.toString());
        System.out.println(returnWord);
        return gameWon;
    }

}
