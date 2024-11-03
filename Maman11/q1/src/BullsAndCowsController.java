public class BullsAndCowsController {
   private int[] num = new int[3]; // the computer
    //num = [1,2,3,4];
    // the input

   // private makeNum()

   private int Hits(int[ ] ans){
       int hitsCount = 0;
       for (int i = 0 ; i < num.length ; i++){
           if(num[i] == ans[i]) hitsCount++;
       }
       return hitsCount;

   }

   private  int Bulls(int[] ans){
       int bulllsCount = 0;
       for (int i = 0; i < num.length; i++) {
           for (int j = 0; j < ans.length; j++){

               if(i!=j && num[i] == ans[j]) bulllsCount++;

           }

       }
       return bulllsCount;
   }
   public  void Output(int arr[]){
        int[] ans = new int[3];
       ans = arr;

       System.out.println("there is "+ Hits(ans) + "hits and "+ Bulls(ans) +"Bulls");

   }


}
