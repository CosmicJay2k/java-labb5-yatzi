package edu.lernia.labb5;

import java.util.Scanner;

public class YatziMain {
    public static Die[] diceArray;
    public static boolean gameIsRunning = true;

    public static void main(String[] args) {

        CreateDiceArray();
        RunYatziGame();

    }

    private static void CreateDiceArray() {
        diceArray = new Die[5];
        for (int i = 0; i < 5; i++) {
            diceArray[i] = new Die();
        }
    }

    private static void RunYatziGame() {
        int turnCount;
        while (gameIsRunning == true) {

            turnCount = 0;
            System.out.println("Welcome to Yatzi!");

            while (turnCount < 3) {

                RollDice(turnCount);
                boolean isYatzi = CheckForYatzi(diceArray);

                if (isYatzi == true) { // If yatzi is true
                    System.out.println("You got YATZI! in " + diceArray[0].value + "'s");
                    return;
                } else {
                    if (turnCount != 2) {
                        System.out.println("Want to throw again? (y for yes, anything else for no)");
                        Scanner scRollAgain = new Scanner(System.in);
                        if (scRollAgain.next().equals("y")) {
                            ++turnCount;
                        } else {
                            gameIsRunning = !gameIsRunning;
                            break;
                        }
                    } else {
                        System.out.println("Game over! Want to play again?");
                        Scanner scPlayAgain = new Scanner(System.in);
                        if (scPlayAgain.next().equals("y")) {
                            turnCount = 0;
                        } else {
                            gameIsRunning = !gameIsRunning;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void RollDice(int turnCount) {
        System.out.println("Starting turn " + (turnCount + 1) + " of 3, rolling dice.");
        for (int i = 0; i < diceArray.length; i++) {
            diceArray[i].DieRoll();
            System.out.println(i + ": " + diceArray[i].getString());
        }
    }

    protected static boolean CheckForYatzi(Die[] dice) {
        boolean isYatzi = true;
        for (int i = 1; i < 5; i++) {
            if (dice[i].value != dice[i - 1].value) {
                isYatzi = false;
            }
        }
        return isYatzi;
    }

}