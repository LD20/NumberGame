import java.util.Random;
import java.util.Scanner;
//importing necessary classes. scanner takes user input and random is a random number generator
public class GuessMyNumber {
    //static int[] retVals = new int[2];
    public static int[] GameParameters() {
        // sets the game parameters
        int targetInt;
        Scanner sc = new Scanner(System.in); // scanner to get user input
        Random rd = new Random();
        System.out.println("what do you want the lowest number to be");
        int min = sc.nextInt(); // gets lowest int
        System.out.println("how many numbers do you want me to set as a range?\n");
        int range = sc.nextInt(); //gets the range of ints
        targetInt = rd.nextInt(range); // gets a random integer between 0 and ) + range
        targetInt += min; // adds min to make the integer within the range
        int max = min + range; //
        int guesses = Math.toIntExact(Math.round(Math.log(range) / Math.log(2))); // most guesses needed using binary
        // search algorithm, used to establish number of guesses
        System.out.println("you have " + guesses + " guesses to find my number between " + min + " and " + max);
        int[] retVals = new int[2]; // array to get return values for the parameters
        retVals[0] = targetInt;
        retVals[1] = guesses;
        return retVals;
    }
    public static String PlayGame(int[] retVals) {
        Scanner sc = new Scanner(System.in);
        String win = "n";
        int targetInt = retVals[0];
        int guesses = retVals[1];
        while (win.equals("n") && guesses > 0 ) {
            // runs the game until you either win or run out of guesses
            System.out.println("you have " + guesses + " guesses left, please guess an integer in the range, you will be " +
                    "told if it is higher or lower then the target integer.\n");
            int playerGuess = sc.nextInt(); //gets player guess
            if (playerGuess == targetInt) win = "y"; // checks if guess is correct
            else {
                win = "n";
                guesses = guesses - 1; // reduces guess count after user guesses a number
                // tells user whether guess is higher or lower than target number
                if (playerGuess > targetInt) {
                    System.out.println("too high");
                } else {
                    System.out.println("too low");
                }
            }
        }
        return win;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("this game is a number guessing game, in it you will be asked to set a range of integers" +
                " to guess from, which will then be used to generate a random integer.\n" +
                "you will then have to guess what that number is with a limited number of guesses and will be told after " +
                "each guess whether your guess was higher or lower than the target.\n" +
                "This game is designed to always be possible so guess carefully"); // intro message
        System.out.println("Do you want to play my game? y or n\n");
        String gameRequest = scan.next(); //get user input as a string
        while (gameRequest.equals("y")) {
            int[] setParams = GameParameters(); // calls GameParameters to set params for the game
            String gameResult = PlayGame(setParams); // plays the game with said parameters
            // string returned from PlayGame is used to see if the user has won
            if(gameResult.equals("y")) {
                System.out.println("you won the game and have achieved basic competency");
            }
            else if (gameResult.equals("n")){
                System.out.println("you have failed in this simple game, do you even know how this works.");
                System.out.println("The number was " + setParams[0]); // tells user what the number was if they lost
            } else {
                System.out.println("try again");
            }
            System.out.println("play again? y or n\n");
            gameRequest = scan.next();

        }
    }
}

