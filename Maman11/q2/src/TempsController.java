import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class TempsController {

    @FXML
    private Canvas canvas;

    @FXML
    private Label yearLabel;
    // int[][] data = Data.getTemps();
    private Data data = new Data();
    double[][] tempsData = data.getTemps();
    int countYear = 0;

    @FXML
    void ChangeYearOnPressed(ActionEvent event) {
        int year = (int) tempsData[countYear][0];

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        yearLabel.setText(Integer.toString(year));
        int text = 0;

        for (int i = (int)canvas.getHeight()-10; i > 0; i = i - 30) {
            gc.strokeText(Integer.toString(text), 10, i);
            text = text + 5;}

        double x = 25;
        for (int j = 1; j < tempsData[countYear].length; j++) {
            double temp = tempsData[countYear][j];
            double MaxTemp = 45;
            double height = canvas.getHeight();
            double y = height-(temp/MaxTemp)*height+50;
            x=x+25;


            if (maxTemp(countYear, j)) {
                gc.setFill(Color.RED);
//                gc.fillRect(x,y,50,height);


            }
            if (minTemp(countYear, j)) {
                gc.setFill(Color.BLUE);
//                gc.fillRect(x,y,50,height);
            } else if(!minTemp(countYear,j)&&(!maxTemp(countYear,j))){
                gc.setFill(Color.GRAY);

            }


        }
        countYear++;
        if (countYear == tempsData.length)countYear=0;
    }

//        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
//        yearLabel.setText(Double.toString(data.getTemps()[0][0]));
//        int text = 0;
//        for (int i = 295; i > 0; i = i - 30) {
//            gc.strokeText(Integer.toString(text), 10, i);
//            text = text + 5;
//        }


//}

    private boolean maxTemp(int i, int j) {
        for (int k = 0; k < tempsData[i].length; k++) {
            if (k != j && tempsData[i][k] > tempsData[i][j]) return false;
        }


        return true;
    }

    private boolean minTemp(int i, int j) {
        for (int k = 0; k < tempsData[i].length; k++) {
            if (k != j && tempsData[i][k] < tempsData[i][j]) return false;
        }
        return true;

    }
}






