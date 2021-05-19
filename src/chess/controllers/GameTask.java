package chess.controllers;

import chess.figures.*;
import chess.squares.Cell;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static chess.controllers.ChangeWhitePawn.ChangeWhitePawn;
import static chess.controllers.Exit.ExitFunc;
import static chess.controllers.Game.*;

public class GameTask {

    static int number;

    int number_of_move = 1;
    int random1;
    int random2;
    double a;

    @FXML
    private Button button_task;

    @FXML
    private Button button_menu;

    @FXML
    private Label label_txt;

    @FXML
    private Label label_number_task;

    @FXML
    private GridPane GridPane;

    @FXML
    private StackPane A1;
    @FXML
    private ImageView a1;
    @FXML
    private StackPane B1;
    @FXML
    private ImageView b1;
    @FXML
    private StackPane H7;
    @FXML
    private ImageView h7;
    @FXML
    private StackPane C8;
    @FXML
    private ImageView c8;
    @FXML
    private StackPane G8;
    @FXML
    private ImageView g8;
    @FXML
    private StackPane E8;
    @FXML
    private ImageView e8;
    @FXML
    private StackPane F7;
    @FXML
    private ImageView f7;
    @FXML
    private StackPane B7;
    @FXML
    private ImageView b7;
    @FXML
    private StackPane B3;
    @FXML
    private ImageView b3;
    @FXML
    private StackPane G6;
    @FXML
    private ImageView g6;
    @FXML
    private StackPane E6;
    @FXML
    private ImageView e6;
    @FXML
    private StackPane C6;
    @FXML
    private ImageView c6;
    @FXML
    private StackPane F6;
    @FXML
    private ImageView f6;
    @FXML
    private StackPane D6;
    @FXML
    private ImageView d6;
    @FXML
    private StackPane G4;
    @FXML
    private ImageView g4;
    @FXML
    private StackPane E4;
    @FXML
    private ImageView e4;
    @FXML
    private StackPane C4;
    @FXML
    private ImageView c4;
    @FXML
    private StackPane A4;
    @FXML
    private ImageView a4;
    @FXML
    private StackPane H5;
    @FXML
    private ImageView h5;
    @FXML
    private StackPane F5;
    @FXML
    private ImageView f5;
    @FXML
    private StackPane D5;
    @FXML
    private ImageView d5;
    @FXML
    private StackPane B5;
    @FXML
    private ImageView b5;
    @FXML
    private StackPane G2;
    @FXML
    private ImageView g2;
    @FXML
    private StackPane E2;
    @FXML
    private ImageView e2;
    @FXML
    private StackPane C2;
    @FXML
    private ImageView c2;
    @FXML
    private StackPane A2;
    @FXML
    private ImageView a2;
    @FXML
    private StackPane H3;
    @FXML
    private ImageView h3;
    @FXML
    private StackPane F3;
    @FXML
    private ImageView f3;
    @FXML
    private StackPane D3;
    @FXML
    private ImageView d3;
    @FXML
    private StackPane A8;
    @FXML
    private ImageView a8;
    @FXML
    private StackPane H1;
    @FXML
    private ImageView h1;
    @FXML
    private StackPane F1;
    @FXML
    private ImageView f1;
    @FXML
    private StackPane D1;
    @FXML
    private ImageView d1;
    @FXML
    private StackPane B8;
    @FXML
    private ImageView b8;
    @FXML
    private StackPane D8;
    @FXML
    private ImageView d8;
    @FXML
    private StackPane A7;
    @FXML
    private ImageView a7;
    @FXML
    private StackPane B6;
    @FXML
    private ImageView b6;
    @FXML
    private StackPane A5;
    @FXML
    private ImageView a5;
    @FXML
    private StackPane A3;
    @FXML
    private ImageView a3;
    @FXML
    private StackPane B4;
    @FXML
    private ImageView b4;
    @FXML
    private StackPane B2;
    @FXML
    private ImageView b2;
    @FXML
    private StackPane C7;
    @FXML
    private ImageView c7;
    @FXML
    private StackPane C5;
    @FXML
    private ImageView c5;
    @FXML
    private StackPane C3;
    @FXML
    private ImageView c3;
    @FXML
    private StackPane C1;
    @FXML
    private ImageView c1;
    @FXML
    private StackPane E7;
    @FXML
    private ImageView e7;
    @FXML
    private StackPane E5;
    @FXML
    private ImageView e5;
    @FXML
    private StackPane E3;
    @FXML
    private ImageView e3;
    @FXML
    private StackPane E1;
    @FXML
    private ImageView e1;
    @FXML
    private StackPane F8;
    @FXML
    private ImageView f8;
    @FXML
    private StackPane F2;
    @FXML
    private ImageView f2;
    @FXML
    private StackPane F4;
    @FXML
    private ImageView f4;
    @FXML
    private StackPane G7;
    @FXML
    private ImageView g7;
    @FXML
    private StackPane G5;
    @FXML
    private ImageView g5;
    @FXML
    private StackPane G3;
    @FXML
    private ImageView g3;
    @FXML
    private StackPane G1;
    @FXML
    private ImageView g1;
    @FXML
    private StackPane H8;
    @FXML
    private ImageView h8;
    @FXML
    private StackPane H6;
    @FXML
    private ImageView h6;
    @FXML
    private StackPane H4;
    @FXML
    private ImageView h4;
    @FXML
    private StackPane H2;
    @FXML
    private ImageView h2;
    @FXML
    private StackPane A6;
    @FXML
    private ImageView a6;
    @FXML
    private StackPane D7;
    @FXML
    private ImageView d7;
    @FXML
    private StackPane D2;
    @FXML
    private ImageView d2;
    @FXML
    private StackPane D4;
    @FXML
    private ImageView d4;

    @FXML
    void initialize()
    {
        CreateList();
        ChoiseTask();
        flag_move = FigureColor.WHITE;
        flag_cell = true;

        button_task.setSkin(new MyButtonSkin(button_task,0.5));
        button_menu.setSkin(new MyButtonSkin(button_menu,0.5));

        GridPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    if (flag_cell) {
                        letter_begin = ForNumberLetter(event.getX());//определяем букву клетки куда ткнули мышкой для выбора фигуры
                        number_begin = ForNumberNumber(event.getY());//определяем цифру клетки куда ткнули мышкой для выбора фигуры
                        cell_begin = FindCell(letter_begin, number_begin);//определяем клетку куда ткнули мышкой для выбора фигуры
                        //если цвет фигуры совпадает с тем, кто должен ходить
                        if (flag_move == cell_begin.figure.getFigureColor()) {// && cell_begin.figure.getName().compareTo("E") != 0) {
                            System.out.println(cell_begin + " begin ");
                            FindImageView(cell_begin).setEffect(ds);
                            //выделяем клетки на которые может сходить фигура рамкой
                            for (Cell cell : getPossibleMovesThisFigure(cell_begin))//при этом функция getPossibleMovesThisFigure возвращает список возможных ходов после всех проверок
                                FindStackPane(cell).setStyle(FindStackPane(cell).getStyle() + "-fx-border-color: #78502B;" + "-fx-border-width: 3;" + "-fx-border-radius: 5;");
                            flag_cell = false;//меняем флаг для того, чтобы перейти на завершение хода
                        }
                    } else {
                        letter_end = ForNumberLetter(event.getX());//определяем букву клетки куда ткнули мышкой для выбора поля куда пойдет фигура
                        number_end = ForNumberNumber(event.getY());//определяем цифру клетки куда ткнули мышкой для выбора поля куда пойдет фигура
                        cell_end = FindCell(letter_end, number_end);//определяем клетку куда ткнули мышкой для выбора поля куда пойдет фигура
                        System.out.println(cell_end + " end");
                        FindImageView(cell_begin).setEffect(null);
                        ForEveryTask();
                    }
                }
            }
        });

        button_menu.setOnAction(event->{
            FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("/chess/fxmls/MainMenu.fxml"));
            Parent root = null;
            try {
                root = (Parent) fxmlLoader.load();
            } catch (IOException var4) {
                var4.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1440, 800));
            stage.setResizable(false);
            stage.setOnCloseRequest(event1 -> {
                if(ExitFunc().compareTo("yes") == 0)
                    stage.close();
            });
            stage.showAndWait();
            CloseWindow();
        });

        button_task.setOnAction(event->{
            FXMLLoader fxmlLoader = new FXMLLoader(Task.class.getResource("/chess/fxmls/Task.fxml"));
            Open(fxmlLoader);
            CloseWindow();
        });
    }

    public void ForEveryTask(){
        switch(number)
        {
            case 1 :
                if(cell_begin.figure.getName().compareTo("R") == 0 && cell_end.name().compareTo("h4") == 0 && number_of_move == 1) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;

                    ResetFigures(Cell.g5, Cell.h4);
                    MoveGraphic(Cell.g5, Cell.h4);
                }
                else if(cell_begin.figure.getName().compareTo("P") == 0 && cell_end.name().compareTo("g4") == 0 && number_of_move == 2) {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else
                    OpenIncorrectMoveWindow();

                flag_cell = true;
                //снимаем выделение клеток возможных ходов фигуры
                for(Cell cell : possibleMovesThisFigure)
                    FindStackPane(cell).setStyle(FindStackPane(cell).getStyle() + "-fx-border-width: 0;");
                break;
            case 2 :
                if(cell_begin.figure.getName().compareTo("N") == 0 && cell_end.name().compareTo("e6") == 0 && number_of_move == 1) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;

                    a = Math.random() * 4;
                    random1 = (int) a;

                    if (random1 == 0) {
                        ResetFigures(Cell.f7, Cell.e6);
                        MoveGraphic(Cell.f7, Cell.e6);
                    } else if (random1 == 1) {
                        ResetFigures(Cell.d5, Cell.e6);
                        MoveGraphic(Cell.d5, Cell.e6);
                    } else if (random1 == 2) {
                        ResetFigures(Cell.g7, Cell.g8);
                        MoveGraphic(Cell.g7, Cell.g8);
                    } else if (random1 == 3) {
                        ResetFigures(Cell.g7, Cell.h8);
                        MoveGraphic(Cell.g7, Cell.h8);
                    }
                }
                else if(number_of_move == 2 && random1 == 0 && cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("f8") == 0) {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else if(number_of_move == 2 && random1 == 1 && cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("h6") == 0){
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;

                    a = Math.random() * 3;
                    random2 = (int) a;

                    if (random2 == 0) {
                        ResetFigures(Cell.g7, Cell.h6);
                        MoveGraphic(Cell.g7, Cell.h6);
                    } else if (random2 == 1) {
                        ResetFigures(Cell.g7, Cell.g8);
                        MoveGraphic(Cell.g7, Cell.g8);
                    } else if (random2 == 2) {
                        ResetFigures(Cell.g7, Cell.h8);
                        MoveGraphic(Cell.g7, Cell.h8);
                    }
                }
                else if(number_of_move == 2 && random1 == 2 && cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("b8") == 0) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;

                    ResetFigures(Cell.d5, Cell.d8);
                    MoveGraphic(Cell.d5, Cell.d8);
                }
                else if(number_of_move == 2 && random1 == 3 && (cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("b8") == 0 || cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("f6") == 0)) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;

                    if(cell_end.name().compareTo("b8") == 0) {
                        ResetFigures(Cell.d5, Cell.d8);
                        MoveGraphic(Cell.d5, Cell.d8);
                        random2 = 0;
                    }
                    else if(cell_end.name().compareTo("f6") == 0)
                    {
                        ResetFigures(Cell.h8, Cell.g8);
                        MoveGraphic(Cell.h8, Cell.g8);
                        random2 = 1;
                    }
                }
                else if(number_of_move == 3 && random1 == 2 && cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("d8") == 0)
                {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else if(number_of_move == 3 && random1 == 1 && random2 == 0 && cell_begin.figure.getName().compareTo("B") == 0 && cell_end.name().compareTo("f8") == 0)
                {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else if(number_of_move == 3 && random1 == 1 && (random2 == 1 || random2 == 2) && cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("f8") == 0)
                {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else if(number_of_move == 3 && random1 == 3 && random2 == 0 && cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("d8") == 0)
                {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else if(number_of_move == 3 && random1 == 3 && random2 == 1 && cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("g7") == 0)
                {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else
                    OpenIncorrectMoveWindow();

                flag_cell = true;
                //снимаем выделение клеток возможных ходов фигуры
                for(Cell cell : possibleMovesThisFigure)
                    FindStackPane(cell).setStyle(FindStackPane(cell).getStyle() + "-fx-border-width: 0;");
                break;
            case 3 :
                if(cell_begin.figure.getName().compareTo("B") == 0 && cell_end.name().compareTo("e3") == 0 && number_of_move == 1) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;

                    a = Math.random() * 2;
                    random1 = (int) a;

                    if (random1 == 0) {
                        ResetFigures(Cell.f1, Cell.g3);
                        MoveGraphic(Cell.f1, Cell.g3);
                    } else if (random1 == 1) {
                        ResetFigures(Cell.f1, Cell.d3);
                        MoveGraphic(Cell.f1, Cell.d3);
                    }
                }
                else if(number_of_move == 2 && random1 == 0 && cell_begin.figure.getName().compareTo("B") == 0 && cell_end.name().compareTo("g5") == 0) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;
                    ResetFigures(Cell.g3, Cell.h4);
                    MoveGraphic(Cell.g3, Cell.h4);
                }
                else if(number_of_move == 3 && random1 == 0 && cell_begin.figure.getName().compareTo("P") == 0 && cell_end.name().compareTo("g4") == 0) {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else if(number_of_move == 2 && random1 == 1 && cell_begin.figure.getName().compareTo("P") == 0 && cell_end.name().compareTo("g4") == 0) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;
                    ResetFigures(Cell.h5, Cell.h4);
                    MoveGraphic(Cell.h5, Cell.h4);
                }
                else if(number_of_move == 3 && random1 == 1 && cell_begin.figure.getName().compareTo("B") == 0 && cell_end.name().compareTo("f2") == 0) {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else
                    OpenIncorrectMoveWindow();

                flag_cell = true;
                //снимаем выделение клеток возможных ходов фигуры
                for(Cell cell : possibleMovesThisFigure)
                    FindStackPane(cell).setStyle(FindStackPane(cell).getStyle() + "-fx-border-width: 0;");
                break;
            case 4 :
                if(cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("h7") == 0 && number_of_move == 1) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;

                    ResetFigures(Cell.f8, Cell.h7);
                    MoveGraphic(Cell.f8, Cell.h7);
                }
                else if(cell_begin.figure.getName().compareTo("R") == 0 && cell_end.name().compareTo("g6") == 0 && number_of_move == 2) {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else
                    OpenIncorrectMoveWindow();

                flag_cell = true;
                //снимаем выделение клеток возможных ходов фигуры
                for(Cell cell : possibleMovesThisFigure)
                    FindStackPane(cell).setStyle(FindStackPane(cell).getStyle() + "-fx-border-width: 0;");
                break;
            case 5 :
                if(cell_begin.figure.getName().compareTo("P") == 0 && cell_end.name().compareTo("g8") == 0 && number_of_move == 1) {
                    MoveLogic(cell_begin, cell_end);

                    MagicPawnTasks();

                    number_of_move++;

                    a = Math.random() * 2;
                    random1 = (int) a;

                    if (random1 == 0) {
                        ResetFigures(Cell.f7, Cell.g8);
                        MoveGraphic(Cell.f7, Cell.g8);
                    } else if (random1 == 1) {
                        ResetFigures(Cell.f7, Cell.f6);
                        MoveGraphic(Cell.f7, Cell.f6);
                    }
                }
                else if(number_of_move == 2 && random1 == 0 && cell_begin.figure.getName().compareTo("K") == 0 && cell_end.name().compareTo("e6") == 0) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;

                    ResetFigures(Cell.g8, Cell.h8);
                    MoveGraphic(Cell.g8, Cell.h8);
                }
                else if(number_of_move == 3 && random1 == 0 && cell_begin.figure.getName().compareTo("K") == 0 && cell_end.name().compareTo("f7") == 0) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;

                    ResetFigures(Cell.e7, Cell.e6);
                    MoveGraphic(Cell.e7, Cell.e6);
                }
                else if(number_of_move == 4 && random1 == 0 && cell_begin.figure.getName().compareTo("B") == 0 && cell_end.name().compareTo("g7") == 0) {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else if(number_of_move == 2 && random1 == 1 && cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("g7") == 0)
                {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;

                    ResetFigures(Cell.f6, Cell.f5);
                    MoveGraphic(Cell.f6, Cell.f5);
                }
                else if(number_of_move == 3 && random1 == 1 && cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("g5") == 0) {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else
                    OpenIncorrectMoveWindow();

                flag_cell = true;
                //снимаем выделение клеток возможных ходов фигуры
                for(Cell cell : possibleMovesThisFigure)
                    FindStackPane(cell).setStyle(FindStackPane(cell).getStyle() + "-fx-border-width: 0;");
                break;
            case 6 :
                if(cell_begin.figure.getName().compareTo("R") == 0 && cell_end.name().compareTo("e8") == 0 && number_of_move == 1) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;

                    a = Math.random() * 2;
                    random1 = (int) a;

                    if (random1 == 0) {
                        ResetFigures(Cell.d7, Cell.e8);
                        MoveGraphic(Cell.d7, Cell.e8);
                    } else if (random1 == 1) {
                        ResetFigures(Cell.d8, Cell.e8);
                        MoveGraphic(Cell.d8, Cell.e8);
                    }
                }
                else if(number_of_move == 2 && random1 == 0 && cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("g8") == 0) {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else if(number_of_move == 2 && random1 == 1 && cell_begin.figure.getName().compareTo("Q") == 0 && cell_end.name().compareTo("f6") == 0) {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else
                    OpenIncorrectMoveWindow();

                flag_cell = true;
                //снимаем выделение клеток возможных ходов фигуры
                for(Cell cell : possibleMovesThisFigure)
                    FindStackPane(cell).setStyle(FindStackPane(cell).getStyle() + "-fx-border-width: 0;");
                break;
            case 7 :
                System.out.println("JOPA7");
                break;
            case 8 :
                if(cell_begin.figure.getName().compareTo("B") == 0 && cell_end.name().compareTo("e6") == 0 && number_of_move == 1) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;

                    ResetFigures(Cell.e3, Cell.e6);
                    MoveGraphic(Cell.e3, Cell.e6);
                }
                else if(cell_begin.figure.getName().compareTo("R") == 0 && cell_end.name().compareTo("h8") == 0 && number_of_move == 2) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;

                    ResetFigures(Cell.g8, Cell.h8);
                    MoveGraphic(Cell.g8, Cell.h8);
                }

                else if(cell_begin.figure.getName().compareTo("R") == 0 && cell_end.name().compareTo("f8") == 0 && number_of_move == 3) {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else
                    OpenIncorrectMoveWindow();

                flag_cell = true;
                //снимаем выделение клеток возможных ходов фигуры
                for(Cell cell : possibleMovesThisFigure)
                    FindStackPane(cell).setStyle(FindStackPane(cell).getStyle() + "-fx-border-width: 0;");
                break;
            case 9 :
                System.out.println("JOPA9");
                break;
            case 10 :
                if(cell_begin.figure.getName().compareTo("R") == 0 && cell_end.name().compareTo("d5") == 0 && number_of_move == 1) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;
                    ResetFigures(Cell.c6, Cell.d5);
                    MoveGraphic(Cell.c6, Cell.d5);
                }
                else if(number_of_move == 2 && cell_begin.figure.getName().compareTo("N") == 0 && cell_end.name().compareTo("d3") == 0) {
                    MoveLogic(cell_begin, cell_end);
                    number_of_move++;
                    ResetFigures(Cell.e4, Cell.d3);
                    MoveGraphic(Cell.e4, Cell.d3);
                }
                else if(number_of_move == 3 && cell_begin.figure.getName().compareTo("P") == 0 && cell_end.name().compareTo("f4") == 0)
                {
                    MoveLogic(cell_begin, cell_end);
                    OpenWinWindow();
                }
                else
                    OpenIncorrectMoveWindow();

                flag_cell = true;
                //снимаем выделение клеток возможных ходов фигуры
                for(Cell cell : possibleMovesThisFigure)
                    FindStackPane(cell).setStyle(FindStackPane(cell).getStyle() + "-fx-border-width: 0;");
                break;
            default:
                System.out.println("JOPA DEFAULT");
                break;
        }
    }

    public void MagicPawnTasks() {
        cell_end.figure = ChangeWhitePawn(cell_end);
        FindImageView(cell_end).setImage(setWhite(cell_end.figure));
    }

    public void MoveLogic(Cell begin, Cell end) {
        if (begin.figure.getName().compareTo("P") == 0)
            begin.figure.PossibleMoves(begin);
        for (Cell curr : possibleMovesThisFigure) {
            if (end == curr) {//если клетка конца равна какому-то элементу из списка возможных ходов фигуры
                ResetFigures(begin, end);
                //рисуем ход
                MoveGraphic(begin, end);
                break;
            }
        }
    }

    public void CreateList() {
        //создаем коллекцию из всех 64 ImageView
        list.add(0, a1);
        list.add(1, a2);
        list.add(2, a3);
        list.add(3, a4);
        list.add(4, a5);
        list.add(5, a6);
        list.add(6, a7);
        list.add(7, a8);
        list.add(8, b1);
        list.add(9, b2);
        list.add(10, b3);
        list.add(11, b4);
        list.add(12, b5);
        list.add(13, b6);
        list.add(14, b7);
        list.add(15, b8);
        list.add(16, c1);
        list.add(17, c2);
        list.add(18, c3);
        list.add(19, c4);
        list.add(20, c5);
        list.add(21, c6);
        list.add(22, c7);
        list.add(23, c8);
        list.add(24, d1);
        list.add(25, d2);
        list.add(26, d3);
        list.add(27, d4);
        list.add(28, d5);
        list.add(29, d6);
        list.add(30, d7);
        list.add(31, d8);
        list.add(32, e1);
        list.add(33, e2);
        list.add(34, e3);
        list.add(35, e4);
        list.add(36, e5);
        list.add(37, e6);
        list.add(38, e7);
        list.add(39, e8);
        list.add(40, f1);
        list.add(41, f2);
        list.add(42, f3);
        list.add(43, f4);
        list.add(44, f5);
        list.add(45, f6);
        list.add(46, f7);
        list.add(47, f8);
        list.add(48, g1);
        list.add(49, g2);
        list.add(50, g3);
        list.add(51, g4);
        list.add(52, g5);
        list.add(53, g6);
        list.add(54, g7);
        list.add(55, g8);
        list.add(56, h1);
        list.add(57, h2);
        list.add(58, h3);
        list.add(59, h4);
        list.add(60, h5);
        list.add(61, h6);
        list.add(62, h7);
        list.add(63, h8);
        //создаем коллекцию из всех 64 StackPane
        List.add(0, A1);
        List.add(1, A2);
        List.add(2, A3);
        List.add(3, A4);
        List.add(4, A5);
        List.add(5, A6);
        List.add(6, A7);
        List.add(7, A8);
        List.add(8, B1);
        List.add(9, B2);
        List.add(10, B3);
        List.add(11, B4);
        List.add(12, B5);
        List.add(13, B6);
        List.add(14, B7);
        List.add(15, B8);
        List.add(16, C1);
        List.add(17, C2);
        List.add(18, C3);
        List.add(19, C4);
        List.add(20, C5);
        List.add(21, C6);
        List.add(22, C7);
        List.add(23, C8);
        List.add(24, D1);
        List.add(25, D2);
        List.add(26, D3);
        List.add(27, D4);
        List.add(28, D5);
        List.add(29, D6);
        List.add(30, D7);
        List.add(31, D8);
        List.add(32, E1);
        List.add(33, E2);
        List.add(34, E3);
        List.add(35, E4);
        List.add(36, E5);
        List.add(37, E6);
        List.add(38, E7);
        List.add(39, E8);
        List.add(40, F1);
        List.add(41, F2);
        List.add(42, F3);
        List.add(43, F4);
        List.add(44, F5);
        List.add(45, F6);
        List.add(46, F7);
        List.add(47, F8);
        List.add(48, G1);
        List.add(49, G2);
        List.add(50, G3);
        List.add(51, G4);
        List.add(52, G5);
        List.add(53, G6);
        List.add(54, G7);
        List.add(55, G8);
        List.add(56, H1);
        List.add(57, H2);
        List.add(58, H3);
        List.add(59, H4);
        List.add(60, H5);
        List.add(61, H6);
        List.add(62, H7);
        List.add(63, H8);
    }

    public void ChoiseTask() {
        switch(number)
        {
            case 1 :
                ArrangementLogic1();
                ArrangementGraphic();
                label_number_task.setText("Задача 1");
                label_txt.setText("В данной позиции преимущество белых очевидно.\nОсталось лишь найти комбинацию, ведущую к\nбыстрой победе.\n\n Ход белых. Мат в 2 хода.");
                break;
            case 2 :
                ArrangementLogic2();
                ArrangementGraphic();
                label_number_task.setText("Задача 2");
                label_txt.setText("В этой непростой позиции белые нашли\nкрасивый путь к победе.\n\nХод белых. Мат в 3 хода.");
                break;
            case 3 :
                ArrangementLogic3();
                ArrangementGraphic();
                label_number_task.setText("Задача 3");
                label_txt.setText("На доске возникла позиция из глубокого эндшпиля.\nНесмотря на небольшое количсество материала,\nбелые проводят атаку на короля соперника.\n\nХод белых. Мат в 3 хода.");
                break;
            case 4 :
                ArrangementLogic4();
                ArrangementGraphic();
                label_number_task.setText("Задача 4");
                label_txt.setText("У черных большое материальное преимущество,\nно ход в данной позиции принадлежит белым,\nи они проводят форсированную атаку.\n\nХод белых. Мат в 2 хода.");
                break;
            case 5 :
                ArrangementLogic5();
                ArrangementGraphic();
                label_number_task.setText("Задача 5");
                label_txt.setText("В данном эндшпиле, который на первый взгляд\nможет показаться равным, белые побеждают,\nблагодаря неожиданной и очень изящной\nкомбинации.\n\nХод белых. Мат в 4 хода.");
                break;
            case 6 :
                ArrangementLogic6();
                ArrangementGraphic();
                label_number_task.setText("Задача 6");
                label_txt.setText("Рашид Нежметдинов был представителем яркого\nатакующего стиля игры. В данной позиции он\nиспользовал активность своих фигур\nи добился быстрой победы.\n\nХод белых. Мат в 2 хода.");
                break;
            case 7 :
                ArrangementLogic7();
                ArrangementGraphic();
                label_number_task.setText("Задача 7");
                label_txt.setText("Перевес черных очевиден, так как одна из пешек\nскоро достигнет первой горизонтали. Но исход партии\nрешает неожиданная атака белых.\n\nХод белых. Мат в 3 хода.");
                break;
            case 8 :
                ArrangementLogic8();
                ArrangementGraphic();
                label_number_task.setText("Задача 8");
                label_txt.setText("Черные создали угрозу мата в один ход, но при этом\nупустили из виду нехитрую тактическую ловушку\nсоперника.\n\nХод белых. Мат в 3 хода.");
                break;
            case 9 :
                ArrangementLogic9();
                ArrangementGraphic();
                label_number_task.setText("Задача 9");
                label_txt.setText("В данном эндшпиле у черных материальный перевес,\nно их король находится в крайне плохой позиции.\nИспользуя это обстоятельство,белые находят\nэффектный путь к победе.\n\nХод белых. Выигрыш.");
                break;
            case 10 :
                ArrangementLogic10();
                ArrangementGraphic();
                label_number_task.setText("Задача 10");
                label_txt.setText("На первый взгляд кажется, что у белых нет никакого\nшанса спастись от поражения. Но в их распоряжении\nимеется форсированная комбинация, которая меняет\nисход партии.\n\nХод белых. Мат в 3 хода.");
                break;
            default:
                break;
        }
    }

    public void ArrangementLogic10() {
        ForAllCell();

        Cell.b7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.c6.figure = new Pawn("P", FigureColor.BLACK);
        Cell.d6.figure = new Pawn("P", FigureColor.BLACK);
        Cell.f6.figure = new Pawn("P", FigureColor.BLACK);
        Cell.e6.figure = new Rook("R", FigureColor.BLACK);
        Cell.e5.figure = new King("K", FigureColor.BLACK);
        Cell.f5.figure = new Bishop("B", FigureColor.BLACK);
        Cell.e4.figure = new Pawn("P", FigureColor.BLACK);
        Cell.f4.figure = new Knight("N", FigureColor.WHITE);
        Cell.e3.figure = new King("K", FigureColor.WHITE);
        Cell.f2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.d1.figure = new Rook("R", FigureColor.WHITE);

        ForAllCellFlags();
    }

    public void ArrangementLogic9() {
        ForAllCell();

        Cell.c6.figure = new Knight("N", FigureColor.WHITE);
        Cell.d4.figure = new Queen("Q", FigureColor.BLACK);
        Cell.a3.figure = new Pawn("P", FigureColor.BLACK);
        Cell.a2.figure = new King("K", FigureColor.BLACK);
        Cell.c2.figure = new King("K", FigureColor.WHITE);
        Cell.h1.figure = new Rook("R", FigureColor.WHITE);

        ForAllCellFlags();
    }

    public void ArrangementLogic8() {
        ForAllCell();

        Cell.g8.figure = new King("K", FigureColor.BLACK);
        Cell.g7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.c6.figure = new Pawn("P", FigureColor.BLACK);
        Cell.g6.figure = new Pawn("P", FigureColor.WHITE);
        Cell.d5.figure = new Pawn("P", FigureColor.BLACK);
        Cell.f5.figure = new Bishop("B", FigureColor.WHITE);
        Cell.a3.figure = new Pawn("P", FigureColor.WHITE);
        Cell.b3.figure = new Knight("N", FigureColor.BLACK);
        Cell.e3.figure = new Rook("R", FigureColor.BLACK);
        Cell.e2.figure = new Rook("R", FigureColor.BLACK);
        Cell.d1.figure = new King("K", FigureColor.WHITE);
        Cell.f1.figure = new Rook("R", FigureColor.WHITE);
        Cell.h1.figure = new Rook("R", FigureColor.WHITE);

        ForAllCellFlags();
    }

    public void ArrangementLogic7() {
        ForAllCell();

        Cell.b8.figure = new King("K", FigureColor.BLACK);
        Cell.f8.figure = new Rook("R", FigureColor.BLACK);
        Cell.a7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.b7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.d7.figure = new King("K", FigureColor.WHITE);
        Cell.e7.figure = new Knight("N", FigureColor.WHITE);
        Cell.d5.figure = new Knight("N", FigureColor.WHITE);
        Cell.c3.figure = new Rook("R", FigureColor.WHITE);
        Cell.f2.figure = new Pawn("P", FigureColor.BLACK);
        Cell.a1.figure = new Rook("R", FigureColor.BLACK);

        ForAllCellFlags();
    }

    public void ArrangementLogic6() {
        ForAllCell();

        Cell.a8.figure = new Rook("R", FigureColor.BLACK);
        Cell.d8.figure = new Queen("Q", FigureColor.BLACK);
        Cell.h8.figure = new King("K", FigureColor.BLACK);
        Cell.a7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.b7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.d7.figure = new Bishop("B", FigureColor.BLACK);
        Cell.f7.figure = new Queen("Q", FigureColor.WHITE);
        Cell.h7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.d6.figure = new Pawn("P", FigureColor.BLACK);
        Cell.g6.figure = new Pawn("P", FigureColor.BLACK);
        Cell.f6.figure = new Bishop("B", FigureColor.BLACK);
        Cell.f5.figure = new Pawn("P", FigureColor.BLACK);
        Cell.c4.figure = new Bishop("B", FigureColor.WHITE);
        Cell.b3.figure = new Pawn("P", FigureColor.WHITE);
        Cell.h3.figure = new Pawn("P", FigureColor.WHITE);
        Cell.a2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.c2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.d2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.f2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.g2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.e1.figure = new Rook("R", FigureColor.WHITE);
        Cell.g1.figure = new King("K", FigureColor.WHITE);

        ForAllCellFlags();
    }

    public void ArrangementLogic5() {
        ForAllCell();

        Cell.d5.figure = new King("K", FigureColor.WHITE);
        Cell.h6.figure = new Bishop("B", FigureColor.WHITE);
        Cell.e7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.f7.figure = new King("K", FigureColor.BLACK);
        Cell.g7.figure = new Pawn("P", FigureColor.WHITE);
        Cell.h7.figure = new Pawn("P", FigureColor.BLACK);

        ForAllCellFlags();
    }

    public void ArrangementLogic4() {
        ForAllCell();

        Cell.a8.figure = new Rook("R", FigureColor.BLACK);
        Cell.e8.figure = new Rook("R", FigureColor.BLACK);
        Cell.f8.figure = new Knight("N", FigureColor.BLACK);
        Cell.a7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.d6.figure = new Queen("Q", FigureColor.BLACK);
        Cell.e6.figure = new Pawn("P", FigureColor.BLACK);
        Cell.h6.figure = new King("K", FigureColor.BLACK);
        Cell.b5.figure = new Pawn("P", FigureColor.BLACK);
        Cell.h5.figure = new Knight("N", FigureColor.BLACK);
        Cell.d4.figure = new Pawn("P", FigureColor.WHITE);
        Cell.f4.figure = new Pawn("P", FigureColor.BLACK);
        Cell.h4.figure = new Pawn("P", FigureColor.BLACK);
        Cell.b3.figure = new Pawn("P", FigureColor.WHITE);
        Cell.c3.figure = new Pawn("P", FigureColor.WHITE);
        Cell.d3.figure = new Queen("Q", FigureColor.WHITE);
        Cell.f3.figure = new Pawn("P", FigureColor.WHITE);
        Cell.a2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.c2.figure = new Bishop("B", FigureColor.WHITE);
        Cell.f2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.g1.figure = new Rook("R", FigureColor.WHITE);
        Cell.h1.figure = new King("K", FigureColor.WHITE);

        ForAllCellFlags();
    }

    public void ArrangementLogic3() {
        ForAllCell();

        Cell.f5.figure = new King("K", FigureColor.WHITE);
        Cell.h5.figure = new King("K", FigureColor.BLACK);
        Cell.f4.figure = new Bishop("B", FigureColor.WHITE);
        Cell.g3.figure = new Pawn("P", FigureColor.WHITE);
        Cell.g2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.f1.figure = new Bishop("B", FigureColor.BLACK);

        ForAllCellFlags();
    }

    public void ArrangementLogic2() {
        ForAllCell();

        Cell.f8.figure = new Knight("N", FigureColor.WHITE);
        Cell.a7.figure = new Rook("R", FigureColor.BLACK);
        Cell.e7.figure = new Bishop("B", FigureColor.WHITE);
        Cell.f7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.h7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.g7.figure = new King("K", FigureColor.BLACK);
        Cell.g6.figure = new Pawn("P", FigureColor.BLACK);
        Cell.d5.figure = new Queen("Q", FigureColor.BLACK);
        Cell.f4.figure = new Queen("Q", FigureColor.WHITE);
        Cell.h4.figure = new King("K", FigureColor.WHITE);

        ForAllCellFlags();
    }

    public void ArrangementLogic1() {
        ForAllCell();

        Cell.a2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.a6.figure = new Pawn("P", FigureColor.BLACK);
        Cell.b7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.c5.figure = new Pawn("P", FigureColor.WHITE);
        Cell.c6.figure = new Pawn("P", FigureColor.BLACK);
        Cell.d1.figure = new Rook("R", FigureColor.WHITE);
        Cell.d2.figure = new Bishop("B", FigureColor.WHITE);
        Cell.e4.figure = new Rook("R", FigureColor.WHITE);
        Cell.e5.figure = new Bishop("B", FigureColor.BLACK);
        Cell.f5.figure = new Pawn("P", FigureColor.WHITE);
        Cell.f6.figure = new Pawn("P", FigureColor.BLACK);
        Cell.f8.figure = new Rook("R", FigureColor.BLACK);
        Cell.g2.figure = new King("K", FigureColor.WHITE);
        Cell.g3.figure = new Pawn("P", FigureColor.WHITE);
        Cell.g5.figure = new Pawn("P", FigureColor.BLACK);
        Cell.h3.figure = new Pawn("P", FigureColor.WHITE);
        Cell.h5.figure = new King("K", FigureColor.BLACK);
        Cell.h8.figure = new Rook("R", FigureColor.BLACK);

        ForAllCellFlags();
    }

    public static void ConditionTask(int num)
    {
       number = num;
    }

    void CloseWindow() {
        ((Stage) button_menu.getScene().getWindow()).close();
    }

    public void ForAllCell() {
        for (Cell cell : Cell.values())
            ForCapture(cell);
    }

    public void ForAllCellFlags() {
        //расставляем флаги занятости клеток
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (FindCell(i, j).figure.getName().compareTo("E") != 0)
                    FindCell(i, j).isOccupied = true;
            }
        }
    }

    void OpenWinWindow(){
        FXMLLoader fxmlLoader = new FXMLLoader(GameTask.class.getResource("/chess/fxmls/CompleteTask.fxml"));
        OpenAndWait(fxmlLoader, true);
    }

    void OpenIncorrectMoveWindow(){
        FXMLLoader fxmlLoader = new FXMLLoader(GameTask.class.getResource("/chess/fxmls/Wrong.fxml"));
        OpenAndWait(fxmlLoader, false);
    }

    void OpenWindowTasks() {
        FXMLLoader fxmlLoader = new FXMLLoader(GameTask.class.getResource("/chess/fxmls/Task.fxml"));
        Open(fxmlLoader);
    }

    void Open(FXMLLoader fxmlLoader)
    {
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

    void OpenAndWait(FXMLLoader fxmlLoader, boolean flag){
        Parent root = null;
        try {
            root = (Parent)fxmlLoader.load();
        } catch (IOException var4) {
            var4.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 240, 150));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(new Image("chess/images/black_figures/black_knight.png"));
        stage.setOnCloseRequest(event1 -> {
            if(flag) {
                CloseWindow();
                OpenWindowTasks();
            }
            stage.close();
        });
        stage.showAndWait();
    }
}
