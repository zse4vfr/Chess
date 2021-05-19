package chess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static chess.controllers.GameTask.ConditionTask;

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
    private Button button_menu;
    @FXML
    void initialize()
    {
        button_play1.setSkin(new MyButtonSkin(button_play1, 0.9));
        button_play2.setSkin(new MyButtonSkin(button_play2,0.9));
        button_play3.setSkin(new MyButtonSkin(button_play3, 0.9));
        button_play4.setSkin(new MyButtonSkin(button_play4,0.9));
        button_play5.setSkin(new MyButtonSkin(button_play5,0.9));
        button_play6.setSkin(new MyButtonSkin(button_play6,0.9));
        button_play7.setSkin(new MyButtonSkin(button_play7,0.9));
        button_play8.setSkin(new MyButtonSkin(button_play8,0.9));
        button_play9.setSkin(new MyButtonSkin(button_play9,0.9));
        button_play10.setSkin(new MyButtonSkin(button_play10,0.9));
        button_menu.setSkin(new MyButtonSkin(button_menu,0.5));

        button_play1.setOnAction(event->{
            ConditionTask(1);
            OpenWindow();
            CloseWindow();
        });

        button_play2.setOnAction(event->{
            ConditionTask(2);
            OpenWindow();
            CloseWindow();
        });

        button_play3.setOnAction(event->{
            ConditionTask(3);
            OpenWindow();
            CloseWindow();
        });

        button_play4.setOnAction(event->{
            ConditionTask(4);
            OpenWindow();
            CloseWindow();
        });

        button_play5.setOnAction(event->{
            ConditionTask(5);
            OpenWindow();
            CloseWindow();
        });

        button_play6.setOnAction(event->{
            ConditionTask(6);
            OpenWindow();
            CloseWindow();
        });

        button_play7.setOnAction(event->{
            ConditionTask(7);
            OpenWindow();
            CloseWindow();
        });

        button_play8.setOnAction(event->{
            ConditionTask(8);
            OpenWindow();
            CloseWindow();
        });

        button_play9.setOnAction(event->{
            ConditionTask(9);
            OpenWindow();
            CloseWindow();
        });

        button_play10.setOnAction(event->{
            ConditionTask(10);
            OpenWindow();
            CloseWindow();
        });

        button_menu.setOnAction(event->{

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
