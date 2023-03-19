import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        * We are going to make a GAME
        * The concept is: Generate a random, number and ask the user to guess the number
        * continue asking until you receive the number
        * after 5 times of guess show a game over message
        *
        * Here is how it works
        * Show a welcome message
        * Ask the User's name and say hello to the user
        * Ask if we should start the game
        * After receiving a positive answer generate a random number and ask for the user's guess
        * if the number is not correct, ask again until you receive the correct answer
        * As a hint, beside the first time, every time  that you are asking for a number, tell the user to guess higher or lower
        * if the user failed 5 times, show a game over and quit the game*/

        System.out.println("Welcome to the brain teaser");
        System.out.print("Input name to continue: ");

        Scanner takeUserInput = new Scanner(System.in);
        String name = takeUserInput.nextLine();
        System.out.println("Hello "+ name);

        System.out.println("Shall we begin?");
        System.out.println("\t1. Yes");
        System.out.println("\t2. No");

        int beginAnswer = takeUserInput.nextInt();

        while (beginAnswer!=1){
            System.out.println("Shall we begin?");
            System.out.println("\t1. Yes");
            System.out.println("\t2. No");

            beginAnswer = takeUserInput.nextInt();
        }
        Random random = new Random();
        int randomNumber = random.nextInt(20)+1;
        System.out.println("Please guess a number: ");
        int userInput = takeUserInput.nextInt();

        int timesTied = 0;
        boolean hasWon = false;
        boolean shouldFinish = false;

        while (!shouldFinish){
            timesTied++;

            if (timesTied< 5){
                if (userInput == randomNumber){
                    hasWon = true;
                    shouldFinish = true;
                } else if (userInput>randomNumber) {
                   System.out.println("Guess lower");
                   userInput = takeUserInput.nextInt();
                }else {
                    System.out.println("Guess higher");
                    userInput = takeUserInput.nextInt();
                }
            }else{
                shouldFinish = true;
            }
        }
        if (hasWon){
            System.out.println("Congratulation! you have guess in your "+ timesTied+ " guess.");
        }else{
            System.out.println("Game over");
            System.out.println("The number was "+ randomNumber);
        }
    }
}