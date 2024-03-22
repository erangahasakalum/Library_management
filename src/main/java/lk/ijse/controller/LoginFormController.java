package lk.ijse.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private Pane parent;

    @FXML
    private VBox vBox;

    TranslateTransition t = new TranslateTransition(Duration.seconds(1),vBox);
    public void initialize(){
        t.setToX(vBox.getLayoutX() * 20);
        t.play();

        t.setOnFinished((e)->{
            try {
                vBox.getChildren().removeAll();
                vBox.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("/view/signUp_form.fxml")));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    @FXML
    void btnSignInOnAction(ActionEvent event) {
        t.setToX(vBox.getLayoutX() * 20);
        t.play();

        t.setOnFinished((e)->{
            try {
                vBox.getChildren().removeAll();
                vBox.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("/view/signIn_form.fxml")));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    @FXML
    void btnSignOnAction(ActionEvent event) {
        t.setToX(0);
        t.play();

        t.setOnFinished((e)->{
            try {
                 FXMLLoader.load(getClass().getResource("/view/signUp_form.fxml.fxml"))
                vBox.getChildren().removeAll();
                vBox.getChildren().setAll();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
