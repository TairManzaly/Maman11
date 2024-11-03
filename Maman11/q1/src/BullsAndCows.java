import java.util.Scanner;



public class BullsAndCows {

    private static void MakeNumber(){
        
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number:");
        String theArray = input.nextLine();
        int[] nums = stringToIntArray(theArray);
        BullsAndCowsController.Output(nums);

    }


    public  static int[] stringToIntArray(String str){
        int[] result = new  int[str.length()];
        for (int i = 0; i < str.length(); i++) {

            result[i] = Character.getNumericValue(str.charAt(i));

        }
        return result;

    }
}
