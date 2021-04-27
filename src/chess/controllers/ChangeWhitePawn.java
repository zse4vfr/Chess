package chess.controllers;

import chess.figures.*;
import chess.squares.Cell;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeWhitePawn {
    static ForAllFigures figure;
    @FXML
    private ImageView white_knight;
    @FXML
    private ImageView white_bishop;
    @FXML
    private ImageView white_rook;
    @FXML
    private ImageView white_queen;

    @FXML
    void initialize() {
        white_queen.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Queen("Q",  FigureColor.WHITE);
                    ((Stage)white_queen.getScene().getWindow()).close();
                }

            }
        });
        white_rook.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Rook("R", FigureColor.WHITE);
                    ((Stage)white_rook.getScene().getWindow()).close();
                }

            }
        });
        white_bishop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Bishop("B",  FigureColor.WHITE);
                    ((Stage)white_bishop.getScene().getWindow()).close();
                }

            }
        });
        white_knight.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Knight("N", FigureColor.WHITE);
                    ((Stage)white_knight.getScene().getWindow()).close();
                }
            }
        });
    }

    public static ForAllFigures ChangeWhitePawn(Cell cell) {
        FXMLLoader fxmlLoader = new FXMLLoader(ChangeWhitePawn.class.getResource("/chess/fxmls/ChangeWhitePawn.fxml"));
        Parent root = null;

        try {
            root = (Parent)fxmlLoader.load();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, 150, 400));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("chess/images/black_figures/black_knight.png"));
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setOnCloseRequest((event) -> {
            primaryStage.showAndWait();
        });
        primaryStage.showAndWait();
        return figure;
    }
}
