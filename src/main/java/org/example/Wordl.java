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
    private static boolean gameWon = false;
    public List<String> myStringList = new ArrayList<>();
    static void main() {

        //1 .given 5 letter blank word
        correctWord = chooseWord();
        IO.println(correctWord);

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

        Wordl wordl = new Wordl();

        while(wordl.guessesLeft > 0 && !gameWon) {
            System.out.print("Enter your guess: ");
            guess = sc.nextLine();

            if(isValidInput(guess, correctWord)) {
                System.out.println("Valid guess.");
                // continue with checks
            }else {
                break;
            }
            gameWon = wordl.checkUserGuess(guess,correctWord);
            wordl.guessesLeft--;

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
                for (String word : wordsLine) {
                    words.add(word);
                }
                line = reader.readLine();
            }

            Random rand = new Random(System.currentTimeMillis());
            correctWord = words.get(rand.nextInt(words.size()));
        } catch (Exception e) { IO.println("File not found!");}
        return correctWord;
    }
    public boolean checkUserGuess(String guess, String correctWord) {
        String returnWord = ""; //Creates an empty String for the word to be returned
        if (guess.equalsIgnoreCase(correctWord)) {
            IO.println(GREEN + correctWord + RESET);    //and returns an all green word
            IO.println("Congratulations, you guessed the Wordl!");
            return true;
        }
        for (int i = 0; i < correctWord.length(); i++){
            if (guess.charAt(i) == correctWord.charAt(i)){
                returnWord = (returnWord + GREEN + guess.charAt(i) + RESET);
            }
            else if(correctWord.indexOf(guess.charAt(i)) != -1){
                returnWord = (returnWord + YELLOW + guess.charAt(i) + RESET);
            }
            else{
                returnWord += (RESET + guess.charAt(i));
            }
        }
        this.myStringList.add(returnWord);
        for(String word : this.myStringList){
            IO.println(word);
        }
        return false;
    }

}
