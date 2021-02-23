import java.util.Random;
import java.util.Scanner;
//importing necessary classes. scanner takes user input and random is a random number generator
public class GuessMyNumber {
    static int[] retVals = new int[2];
    public static int[] GameParameters() {
        // sets the game parameters
        int targetInt;
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        System.out.println("what do you want the lowest number to be");
        int min = sc.nextInt();
        System.out.println("how many numbers do you want me to set as a range?\n");
        int range = sc.nextInt();
        targetInt = rd.nextInt(range);
        targetInt += min;
        int max = min + range;
        int guesses = Math.toIntExact(Math.round(Math.log(range) / Math.log(2))); // most guesses needed using binary search algorithm
        System.out.println("you have " + guesses + " guesses to find my number between " + min + " and " + max);
        int[] retVals = new int[2];
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
            int playerGuess = sc.nextInt();
            if (playerGuess == targetInt) win = "y";
            else {
                win = "n";
            }
            guesses = guesses - 1;
            if (playerGuess > targetInt) {
                System.out.println("too high");
            } else if (targetInt > playerGuess) {
                System.out.println("too low");
            } else {
                System.out.println("???");
            }
        }

        return win;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to play my game? y or n\n");
        String gameRequest = scan.next();
        while (gameRequest.equals("y")) {
            int[] setParams = GameParameters();
            String gameResult = PlayGame(setParams);
            if(gameResult.equals("y")) {
                System.out.println("you won the game");
            }
            else if (gameResult.equals("n") && setParams[1] == 0){
                System.out.println("you lost the game :)");
                System.out.println("The number was " + setParams[0]);
            } else {
                System.out.println("try again");
            }

            System.out.println("The number was " + setParams[0]);
            System.out.println("play again? y or n\n");
            gameRequest = scan.next();

        }
    }
}

