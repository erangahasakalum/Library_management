package lk.ijse.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import lk.ijse.bo.LoadingTask;

import java.io.IOException;

public class LoadingFormController {
    @FXML
    private Rectangle mainProgressBar;

    @FXML
    private Rectangle subProgressBar;

    @FXML
    private Label loading;

    LoadingTask loadingTask = new LoadingTask();

    public void initialize() {
        loadingTask.progressProperty().addListener((ob, oldValue, newValue) -> {
            String formatnumber = String.format("%.0f", newValue.doubleValue() * 100);
            loading.setText(formatnumber + "%");
            subProgressBar.setWidth(mainProgressBar.getWidth() * newValue.doubleValue());

            if (newValue.doubleValue() == 1.0) {
               Window window = loading.getScene().getWindow();
                Stage stage =  (Stage) window ;
                stage.close();

                try {
                    Stage stage1 = new Stage();
                    stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login_form.fxml"))));
                    stage1.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        });
        new Thread(loadingTask).start();

    }
}
