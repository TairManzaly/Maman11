public class GameLogic {
   private int[] num ;


    public  GameLogic(int[] num) {
        this.num = num;
    }

//    private int Cows(int[ ] guess){
//       int hitsCount = 0;
//       for (int i = 0 ; i < num.length ; i++){
//           if(num[i] == guess[i]) hitsCount++;
//       }
//       return hitsCount;
//
//   }
//
//   private  int Bulls(int[] guess){
//       int bulllsCount = 0;
//       for (int i = 0; i < num.length; i++) {
//           for (int j = 0; j < guess.length; j++){
//
//               if(i!=j && num[i] == guess[j]) bulllsCount++;
//
//           }
//
//       }
//       return bulllsCount;
  // }
   public  String Output(int arr[]){// bulls- exact place, cows- not the exact place
        int bullsCount = 0 , cowsCount = 0;

        int[] guess = arr;
        int[] code = num;


       for (int i = 0; i < guess.length; i++) {
           for (int j = 0; j < code.length; j++) {
               if(i==j&& guess[i] == code[j]){ // bullls
                   bullsCount++;
               } else if (i!= j && guess[i] == code[j] ) {
                   cowsCount++;
               }
           }

       }


      return ("Bulls: "+ bullsCount + ", Cows: "+cowsCount +".");

   }


}
