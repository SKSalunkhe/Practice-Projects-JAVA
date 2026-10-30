package NumGuess_4;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumGuess {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int secret = random.nextInt(10) + 1;
        int guess = 0;
        int attempts = 0;

        System.out.println("___Number guessing Game___");
        System.out.println("I picked a Number between 1-10....");

        while(guess != secret){
            System.out.println("Enter Ur Guess");

            try{
                guess = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Please enter only numbers...");
                sc.nextInt();
                continue;
            }

            if(guess < secret){
                System.out.println("Too Small...");
                continue;
            }else if(guess > secret){
                System.out.println("Too Big...");
                continue;
            }else{
                System.out.println("Congratsss the Number is " + secret + " & u guessed it correctly...");
            }
        }
        sc.close();
    }
}
