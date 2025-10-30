package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class Wordl {
    //public static final String GREEN = "\u001B[32m";
    public static String correctWord;
    static void main() {
        //System.out.println(GREEN + "This text is green.");
        //1 .given 5 letter blank word
        correctWord = chooseWord();
        IO.println(correctWord);
        DisplayWord(correctWord);


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

}
