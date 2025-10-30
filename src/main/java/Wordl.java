import org.example.ColoredLetters;


import java.util.ArrayList;
import java.util.List;

import static org.example.ColoredLetters.*;

public class Wordl {
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
    int guessesLeft = 6;
    private boolean gameWon = false;
    public List<String> myStringList = new ArrayList<>();

    public static void main(){
        Wordl wordl = new Wordl();
        String word = "board";
        String cone = "board";
        IO.println(wordl.checkUserGuess(word, cone));
    }

    public String checkUserGuess(String guess, String correctWord) {
        String returnWord = ""; //Creates an empty String for the word to be returned
        if (guess.toUpperCase().equals(correctWord)) {
            this.gameWon = true;        //if the guessed word is the same as the correct word sets the game won setting to true
            return(GREEN + correctWord);    //and retursn an all green word
        }
        for (int i = 0; i < correctWord.length(); i++){
            if (guess.charAt(i) == correctWord.charAt(i)){
                returnWord = (returnWord + GREEN + guess.charAt(i));
            }
            else if(correctWord.indexOf(guess.charAt(i)) != -1){
                returnWord = (returnWord + YELLOW + guess.charAt(i));
            }
            else{
                returnWord += (RESET + guess.charAt(i));
            }
        }
        this.myStringList.add(returnWord);
        return returnWord;
    }

}
