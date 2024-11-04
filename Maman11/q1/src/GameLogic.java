public class GameLogic {
   private int[] num ;


    public  GameLogic(int[] num) {
        this.num = num;
    }

    private int Cows(int[ ] guess){
       int hitsCount = 0;
       for (int i = 0 ; i < num.length ; i++){
           if(num[i] == guess[i]) hitsCount++;
       }
       return hitsCount;

   }

   private  int Bulls(int[] guess){
       int bulllsCount = 0;
       for (int i = 0; i < num.length; i++) {
           for (int j = 0; j < guess.length; j++){

               if(i!=j && num[i] == guess[j]) bulllsCount++;

           }

       }
       return bulllsCount;
   }
   public  String Output(int arr[]){


      return ("Cows: "+ Cows(arr) + ", Bulls: "+ Bulls(arr) +".");

   }


}
