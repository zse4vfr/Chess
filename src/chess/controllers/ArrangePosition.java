package chess.controllers;
import java.io.IOException;

import chess.figures.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static chess.controllers.Game.flag_move;

public class ArrangePosition {
    static ForAllFigures figure;
    @FXML
    public Button button_OK;
    @FXML
    public CheckBox check_box_white;
    @FXML
    public CheckBox check_box_black;
    @FXML
    private ImageView black_queen;
    @FXML
    private ImageView black_king;
    @FXML
    private ImageView white_queen;
    @FXML
    private ImageView white_rook;
    @FXML
    private ImageView white_bishop;
    @FXML
    private ImageView black_rook;
    @FXML
    private ImageView black_bishop;
    @FXML
    private ImageView white_knight;
    @FXML
    private ImageView black_knight;
    @FXML
    private ImageView white_pawn;
    @FXML
    private ImageView black_pawn;
    @FXML
    private ImageView white_king;

    @FXML
    void initialize() {
        white_king.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new King("K", FigureColor.WHITE);
                    ((Stage)white_king.getScene().getWindow()).close();
                }

            }
        });
        white_queen.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Queen("Q", FigureColor.WHITE);
                    ((Stage)white_king.getScene().getWindow()).close();
                }

            }
        });
        white_rook.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Rook("R", FigureColor.WHITE);
                    ((Stage)white_king.getScene().getWindow()).close();
                }

            }
        });
        white_bishop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Bishop("B", FigureColor.WHITE);
                    ((Stage)white_king.getScene().getWindow()).close();
                }

            }
        });
        white_knight.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Knight("N", FigureColor.WHITE);
                    ((Stage)white_king.getScene().getWindow()).close();
                }

            }
        });
        white_pawn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Pawn("P", FigureColor.WHITE);
                    ((Stage)white_king.getScene().getWindow()).close();
                }

            }
        });
        black_king.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new King("K", FigureColor.BLACK);
                    ((Stage)black_king.getScene().getWindow()).close();
                }

            }
        });
        black_queen.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Queen("Q", FigureColor.BLACK);
                    ((Stage)black_king.getScene().getWindow()).close();
                }

            }
        });
        black_rook.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Rook("R", FigureColor.BLACK);
                    ((Stage)black_king.getScene().getWindow()).close();
                }

            }
        });
        black_bishop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Bishop("B", FigureColor.BLACK);
                    ((Stage)black_king.getScene().getWindow()).close();
                }

            }
        });
        black_knight.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Knight("N", FigureColor.BLACK);
                    ((Stage)black_king.getScene().getWindow()).close();
                }

            }
        });
        black_pawn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    figure = new Pawn("P", FigureColor.BLACK);
                    ((Stage)black_king.getScene().getWindow()).close();
                }

            }
        });
        button_OK.setOnAction((event) -> {
            figure = new EmptyFigure("E");
            if (check_box_black.isSelected() && !check_box_white.isSelected())
                flag_move = FigureColor.BLACK;
            else
                flag_move = FigureColor.WHITE;

            ((Stage)button_OK.getScene().getWindow()).close();
        });
    }

    public static ForAllFigures ArrangePositionFunc() {
        FXMLLoader fxmlLoader = new FXMLLoader(ArrangePosition.class.getResource("/chess/fxmls/ArrangePositionOk.fxml"));
        Parent root = null;
        try {
            root = (Parent)fxmlLoader.load();
        } catch (IOException var4) {
            var4.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 240, 600));
        stage.setResizable(false);
        stage.setX(20.0D);
        stage.setY(10.0D);
        stage.getIcons().add(new Image("chess/images/black_figures/black_knight.png"));
        stage.setOnCloseRequest(event -> {
            stage.close();
        });
        stage.showAndWait();
        return figure;
    }
}
