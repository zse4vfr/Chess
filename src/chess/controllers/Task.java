package chess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Task {
    @FXML
    private Button button_play1;
    @FXML
    private Button button_play2;
    @FXML
    private Button button_play3;
    @FXML
    private Button button_play4;
    @FXML
    private Button button_play5;
    @FXML
    private Button button_play6;
    @FXML
    private Button button_play7;
    @FXML
    private Button button_play8;
    @FXML
    private Button button_play9;
    @FXML
    private Button button_play10;

    @FXML
    void initialize()
    {
        button_play1.setOnAction(event->{
            OpenWindow();
            CloseWindow();
        });

        button_play2.setOnAction(event->{
            OpenWindow();
            CloseWindow();
        });
    }

    void OpenWindow()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(GameTask.class.getResource("/chess/fxmls/GameFxmlLubaTasks.fxml"));
        Parent root = null;
        try {
            root = (Parent)fxmlLoader.load();
        } catch (IOException var4) {
            var4.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 1440, 800));
        stage.setResizable(false);
        stage.getIcons().add(new Image("chess/images/black_figures/black_knight.png"));
        stage.setOnCloseRequest(event1 -> {
            stage.close();
        });
        stage.show();
    }
    void CloseWindow()
    {
        ((Stage) button_play1.getScene().getWindow()).close();
    }
}