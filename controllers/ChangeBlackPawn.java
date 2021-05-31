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


public class ChangeBlackPawn{
    static ForAllFigures figure;
    @FXML
    private ImageView black_knight;
    @FXML
    private ImageView black_bishop;
    @FXML
    private ImageView black_rook;
    @FXML
    private ImageView black_queen;

    @FXML
    void initialize() {
        black_queen.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Queen("Q", FigureColor.BLACK);
                    ((Stage)black_queen.getScene().getWindow()).close();
                }

            }
        });
        black_rook.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Rook("R", FigureColor.BLACK);
                    ((Stage)black_rook.getScene().getWindow()).close();
                }

            }
        });
        black_bishop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Bishop("B", FigureColor.BLACK);
                    ((Stage)black_bishop.getScene().getWindow()).close();
                }

            }
        });
        black_knight.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Knight("N", FigureColor.BLACK);
                    ((Stage)black_knight.getScene().getWindow()).close();
                }
            }
        });
    }

    public static ForAllFigures ChangeBlackPawn(Cell cell) {
        FXMLLoader fxmlLoader = new FXMLLoader(ChangeBlackPawn.class.getResource("/chess/fxmls/ChangeBlackPawn.fxml"));
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
