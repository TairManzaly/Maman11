import javax.swing.*;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;



public class BullsAndCows {

    private static int[] MakeNumber(){

       Random randomNumbers = new Random();
        int[] code =new int[4];
        int[] used = new int[10];
        for (int i = 0; i < 4; i++) {
            int num = randomNumbers.nextInt(10);
            if(used[num] ==0){
                code[i] = num;
                used[num]  = 1;

            }
            else i--;

        }
        return  code;
    }

    public static void main(String[] args) {

        int[] code = MakeNumber();
       GameLogic game = new GameLogic(code);
       String guesses ="Your Guesses so far:" ;
        int[] guess=new int[4];
        String input;
        String output="";
        while(guess!=code){
        input = JOptionPane.showInputDialog(guesses+"\n"+"Enter your guess:");
         guess = stringToIntArray(input);
         output = game.Output(guess);
        guesses= guesses+"\n"+input+" "+output;


           // JOptionPane.showMessageDialog(null,output);
        }





    }


    public  static int[] stringToIntArray(String str){
        int[] result = new  int[str.length()];
        for (int i = 0; i < str.length(); i++) {

            result[i] = Character.getNumericValue(str.charAt(i));

        }
        return result;

    }
}
