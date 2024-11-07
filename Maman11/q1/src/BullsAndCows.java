import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.Random;


public class BullsAndCows {


    public static void main(String[] args) {
        boolean stopGame = false;
        while (!stopGame) {
            //int[] code = {1, 2, 3, 4};
            int[] code = MakeNumber();
            GameLogic game = new GameLogic(code);
            String guesses = "Your Guesses so far:";
            int[] guess = new int[4];
            String input;
            String output = "";
            int guessCount = 0;

            while (!arrayEqual(guess, code)) {
                input = JOptionPane.showInputDialog(guesses + "\n" + "Enter your guess:");
                //guess = stringToIntArray(input);
                boolean wrongLength = false, wrongDigits = false, repeatDigits = false;
                for (int i = 0; i < input.length(); i++) {
                    if (!input.matches("\\d+")) {
                        wrongDigits = true;
                    }
                    for (int j = 0; j < input.length(); j++) {
                        if (i != j && input.charAt(i) == input.charAt(j)) repeatDigits = true;
                    }

                }
                if (input.length() != 4) {
                    wrongLength = true;


                }
                if (wrongLength) {
                    JOptionPane.showMessageDialog(null, "The guess need to be 4 numbers", "Wrong input", JOptionPane.ERROR_MESSAGE);
                }
                if (wrongDigits) {
                    JOptionPane.showMessageDialog(null, "The guess need only include numbers", "Wrong input", JOptionPane.ERROR_MESSAGE);
                }
                if (repeatDigits) {
                    JOptionPane.showMessageDialog(null, "You can't repeat numbers", "Wrong input", JOptionPane.ERROR_MESSAGE);
                } else if (!wrongLength && !repeatDigits && !wrongDigits) {
                    guess = stringToIntArray(input);
                    output = game.Output(guess);
                    guesses = guesses + "\n" + input + " " + output;
                    guessCount++;

                }

                // JOptionPane.showMessageDialog(null,output);
            }

            if (arrayEqual(guess, code)) {
                int play = JOptionPane.showConfirmDialog(null, "You won the game! it tooks you only " + guessCount +
                        " trys. want another one?", "End game", JOptionPane.YES_NO_OPTION);
                if (play == JOptionPane.NO_OPTION) {
                    stopGame = true;
                }
            }


        }
    }


    public static int[] stringToIntArray(String str) {
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {

            result[i] = Character.getNumericValue(str.charAt(i));

        }
        return result;
    }

    private static int[] MakeNumber() {

        Random randomNumbers = new Random();
        int[] code = new int[4];
        int[] used = new int[10];
        for (int i = 0; i < 4; i++) {
            int num = randomNumbers.nextInt(10);
            if (used[num] == 0) {
                code[i] = num;
                used[num] = 1;

            } else i--;

        }
        return code;
    }


    private static boolean arrayEqual(int[] arr1, int[] arr2) {
        //  boolean equal = true;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;

    }

}
