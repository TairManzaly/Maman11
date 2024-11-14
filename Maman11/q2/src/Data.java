public class Data {

    private double temps[][] ={
            {2018,30,35,32,28,21,10,17,14,32,5,31,40},
            {2019,30,35,32,28,21,10,17,14,32,5,31,40},
            {2020,30,35,32,28,21,10,17,14,32,5,31,40},
            {2021,30,35,32,28,21,10,17,14,32,5,31,40},
            {2022,30,35,32,28,21,10,17,14,32,5,31,40},


    };
//public double[][] Data(){
//    return temps;
//}
    public double[][] getTemps() {
        double[][] res = new double[temps.length][];
        for (int i = 0; i < temps.length; i++) {
            for (int j = 0; j < temps[i].length; j++) {
                res[i][j]= temps[i][j];
            }
            
        }
        
        return res;
    }
}
