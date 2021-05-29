package chess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class OtherRules {
    @FXML
    public Button button_1;
    @FXML
    public Button button_2;
    @FXML
    public Button button_3;
    @FXML
    public Button button_4;
    @FXML
    public Button button_5;
    @FXML
    public Button button_menu;
    @FXML
    public Button button_rules;

    @FXML
    void initialize() {
        button_1.setSkin(new MyButtonSkin(button_1, 0.9));
        button_2.setSkin(new MyButtonSkin(button_2, 0.9));
        button_3.setSkin(new MyButtonSkin(button_3, 0.9));
        button_4.setSkin(new MyButtonSkin(button_4, 0.9));
        button_5.setSkin(new MyButtonSkin(button_5, 0.9));
        button_rules.setSkin(new MyButtonSkin(button_rules, 0.5));
        button_menu.setSkin(new MyButtonSkin(button_menu, 0.5));
        button_menu.setOnAction(event->{
            FXMLLoader fxmlLoader = new FXMLLoader(GameTask.class.getResource("/chess/fxmls/OtherRules1.fxml"));
            Open(fxmlLoader);
        });
        button_rules.setOnAction(event->{
            FXMLLoader fxmlLoader = new FXMLLoader(GameTask.class.getResource("/chess/fxmls/Rules.fxml"));
            Open(fxmlLoader);
        });
        button_menu.setOnAction(event->{
            FXMLLoader fxmlLoader = new FXMLLoader(GameTask.class.getResource("/chess/fxmls/MainMenu.fxml"));
            Open(fxmlLoader);
        });
        button_menu.setOnAction(event->{
            FXMLLoader fxmlLoader = new FXMLLoader(GameTask.class.getResource("/chess/fxmls/MainMenu.fxml"));
            Open(fxmlLoader);
        });
        button_menu.setOnAction(event->{
            FXMLLoader fxmlLoader = new FXMLLoader(GameTask.class.getResource("/chess/fxmls/MainMenu.fxml"));
            Open(fxmlLoader);
        });


    }
    void CloseWindow()
    {
        ((Stage) button_menu.getScene().getWindow()).close();
    }
    void Open(FXMLLoader fxmlLoader)
    {
        CloseWindow();
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
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

}
