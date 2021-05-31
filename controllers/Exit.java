package chess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Exit {

    public static boolean flag;

    @FXML
    private Button button_no;

    @FXML
    private Button button_yes;

    @FXML
    void initialize() {
        button_yes.setSkin(new MyButtonSkin(button_yes, 0.5));
        button_no.setSkin(new MyButtonSkin(button_no, 0.5));
        button_yes.setOnAction(event->{
            flag = true;
            ((Stage) button_yes.getScene().getWindow()).close();
        });
        button_no.setOnAction(event->{
            flag = false;
            ((Stage) button_no.getScene().getWindow()).close();
        });

    }

    public static boolean ExitFunc() {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("/chess/fxmls/Exit.fxml"));
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException var4) {
            var4.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 240, 150));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(new Image("chess/images/black_figures/black_knight.png"));
        stage.setOnCloseRequest(event1 -> {
            stage.close();
        });
        stage.showAndWait();
        return flag;
    }
}