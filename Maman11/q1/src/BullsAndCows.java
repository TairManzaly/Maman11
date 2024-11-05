import javax.swing.*;
import java.util.Random;


public class BullsAndCows {


    public static void main(String[] args) {
        boolean stopGame = false;
while (!stopGame) {
    int[] code = MakeNumber();
    GameLogic game = new GameLogic(code);
    String guesses = "Your Guesses so far:";
    int[] guess = new int[4];
    String input;
    String output = "";

    while (guess != code) {
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
            guesses = guesses;
        }
        if (wrongDigits) {
            JOptionPane.showMessageDialog(null, "The guess need only include numbers", "Wrong input", JOptionPane.ERROR_MESSAGE);
            guesses = guesses;
        }
        if (repeatDigits) {
            JOptionPane.showMessageDialog(null, "You can't repeat numbers", "Wrong input", JOptionPane.ERROR_MESSAGE);
            guesses = guesses;
        } else {
            guess = stringToIntArray(input);
            if (guess == code) {
                JOptionPane.showMessageDialog(null, "Do you want another game?");
            } else {
                output = game.Output(guess);
                guesses = guesses + "\n" + input + " " + output;
            }
        }

        // JOptionPane.showMessageDialog(null,output);
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

}
