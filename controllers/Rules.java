package chess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static chess.controllers.ChessBoard.setFlags;

import java.io.IOException;

public class Rules {

    @FXML
    private Button button_board;

    @FXML
    private Button button_figures;

    @FXML
    private Button button_other_rules;

    @FXML
    private Button button_menu;

    @FXML
    void initialize()
    {
        button_board.setSkin(new MyButtonSkin(button_board,0.9));
        button_other_rules.setSkin(new MyButtonSkin(button_other_rules,0.7));
        button_figures.setSkin(new MyButtonSkin(button_figures,0.7));
        button_menu.setSkin(new MyButtonSkin(button_menu,0.5));

        button_menu.setOnAction(event->{
            FXMLLoader fxmlLoader = new FXMLLoader(GameTask.class.getResource("/chess/fxmls/MainMenu.fxml"));
            Open(fxmlLoader);
        });

        button_board.setOnAction(event->{
            setFlags(true, false, false);
            FXMLLoader fxmlLoader = new FXMLLoader(Rules.class.getResource("/chess/fxmls/ChessBoard.fxml"));
            Open(fxmlLoader);
        });

        button_figures.setOnAction(event->{
            setFlags(false, true, false);
            FXMLLoader fxmlLoader = new FXMLLoader(Rules.class.getResource("/chess/fxmls/ChessBoard.fxml"));
            Open(fxmlLoader);
        });

        button_other_rules.setOnAction(event->{
            setFlags(false, false, true);
            FXMLLoader fxmlLoader = new FXMLLoader(Rules.class.getResource("/chess/fxmls/ChessBoard.fxml"));
            Open(fxmlLoader);
        });
    }

    void CloseWindow()
    {
        ((Stage) button_board.getScene().getWindow()).close();
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
