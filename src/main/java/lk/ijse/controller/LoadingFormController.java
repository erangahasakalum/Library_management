package lk.ijse.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.bo.LoadingTask;

public class LoadingFormController {
    @FXML
    private Rectangle mainProgressBar;

    @FXML
    private Rectangle subProgressBar;

    @FXML
    private Label loading;

    LoadingTask loadingTask = new LoadingTask();

    public void initialize(){
        loadingTask.progressProperty().addListener((ob,oldValue,newValue)->{
            String formatnumber = String.format("%.0f", newValue.doubleValue()*100);
            loading.setText(formatnumber +"%");
            subProgressBar.setWidth(mainProgressBar.getWidth()*newValue.doubleValue());

           if (newValue.doubleValue()==1.0){
               Window window = loading.getScene().getWindow();
               Stage stage = (Stage) window;
               stage.close();
           }

        });
        new Thread(loadingTask).start();
    }

}
