package chess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static chess.controllers.Game.setFlags;
import static chess.controllers.Exit.ExitFunc;

public class MainMenu {

    @FXML
    private Button button_load;
    @FXML
    private Button button_rules;
    @FXML
    private Button button_exit;
    @FXML
    private Button button_play2;
    @FXML
    private Button button_play_comp;
    @FXML
    private Button button_task;

    @FXML
    void initialize() {
        button_exit.setSkin(new MyButtonSkin(button_exit, 0.5));
        button_play_comp.setSkin(new MyButtonSkin(button_play_comp,0.5));
        button_play2.setSkin(new MyButtonSkin(button_play2,0.5));
        button_task.setSkin(new MyButtonSkin(button_task,0.5));
        button_rules.setSkin(new MyButtonSkin(button_rules,0.5));
        button_load.setSkin(new MyButtonSkin(button_load,0.5));

        button_rules.setOnAction(event->{
            FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("/chess/fxmls/Rules.fxml"));
            Open(fxmlLoader);
            CloseWindow();
        });

        button_load.setOnAction(event->{
            setFlags(false, false, true);
            OpenWindow();
            CloseWindow();
        });

        button_exit.setOnAction(event->{
            if(ExitFunc())
                CloseWindow();
        });

        button_play_comp.setOnAction(event->{
            setFlags(false, true, false);
            OpenWindow();
            CloseWindow();
        });

        button_play2.setOnAction(event->{
            setFlags(true, false, false);
            OpenWindow();
            CloseWindow();
        });

        button_task.setOnAction(event->{
            FXMLLoader fxmlLoader = new FXMLLoader(Task.class.getResource("/chess/fxmls/Task.fxml"));
            Open(fxmlLoader);
            CloseWindow();
        });
    }

    void OpenWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("/chess/fxmls/GameFxmlLuba.fxml"));
        Open(fxmlLoader);
    }

    void Open(FXMLLoader fxmlLoader)
    {
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
        ((Stage) button_exit.getScene().getWindow()).close();
    }
}
