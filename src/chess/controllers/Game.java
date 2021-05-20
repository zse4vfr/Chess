package chess.controllers;

import chess.cancel.ArrayCancelMove;
import chess.cancel.CancelMove;
import chess.figures.*;
import chess.record.RecordMove;
import chess.squares.Cell;

import static chess.controllers.ArrangePosition.ArrangePositionFunc;
import static chess.controllers.ChangeBlackPawn.ChangeBlackPawn;
import static chess.controllers.ChangeWhitePawn.ChangeWhitePawn;
import static chess.controllers.Exit.ExitFunc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Game{

    ForAllFigures figure_arrange;

    public static boolean flag_two_players;
    public static boolean flag_one_player;
    public static boolean flag_load;

    static int letter_begin;//переменные нужные для определения куда тыкают мышкой чтобы выбирать фигуры и ходить
    static int number_begin;
    static Cell cell_begin;
    static int letter_end;
    static int number_end;
    static Cell cell_end;

    static Cell cellforpawn;//клетка конца хода нужная для того, чтобы определять, нужно ли в классе пешки вызывать метод ForCapture удаляющий пешку, которую убили взятием на проходе, с доски

    public static FileChooser file_chooser = new FileChooser();//для сохранения и загрузки

    static FigureColor flag_move;//флаг отвечающий за то, чья очередь хода
    static boolean flag_cell;//флаг отвечающий за то, на каком этапе находится ход; если true - выбрали фигуру, если false - сделали(или не сделали) ход
    static boolean flag_attackking_move;//флаг отвечающий за то, был ли сделан ход или клетку конца выбрали неправильно
    boolean flag_arrange;

    static CancelMove curr;//объект класса отвечающий за отмену одного полухода
    static ArrayCancelMove arrayCancelMove = new ArrayCancelMove();//список всех объектов таких как выше

    static ObservableList<RecordMove> record = FXCollections.observableArrayList();//для таблицы чтобы вечти запись ходов
    static String record_move = "";//переменная для записи хода
    static int number_move;//счетчик количества ходов

    static ObservableList<ImageView> list = FXCollections.observableArrayList();//список из 64 ImageView
    static ObservableList<StackPane> List = FXCollections.observableArrayList();//список из 64 StackPane

    static ArrayList<Cell> possibleMovesThisFigure;//список возможных ходов фигуры после проверки на ограничения
    static ArrayList<Cell> allPossibleMoves;//список возможных ходов всех фигур после проверки на ограничения

    static DropShadow ds = new DropShadow(50.0D, Color.rgb(120, 80, 43));//эффект тени для подсветки выбранной фигуры

    public static Image empty_figure = new Image("chess/images/empty_figure.png");
    static Image black_pawn = new Image("chess/images/black_figures/black_pawn.png");
    static Image white_pawn = new Image("chess/images/white_figures/white_pawn.png");
    static Image black_knight = new Image("chess/images/black_figures/black_knight.png");
    static Image white_knight = new Image("chess/images/white_figures/white_knight.png");
    static Image black_bishop = new Image("chess/images/black_figures/black_bishop.png");
    static Image white_bishop = new Image("chess/images/white_figures/white_bishop.png");
    static Image black_rook = new Image("chess/images/black_figures/black_rook.png");
    static Image white_rook = new Image("chess/images/white_figures/white_rook.png");
    static Image black_king = new Image("chess/images/black_figures/black_king.png");
    static Image white_king = new Image("chess/images/white_figures/white_king.png");
    static Image black_queen = new Image("chess/images/black_figures/black_queen.png");
    static Image white_queen = new Image("chess/images/white_figures/white_queen.png");

    @FXML
    private GridPane GridPane;
    @FXML
    private StackPane E6;
    @FXML
    private StackPane B7;
    @FXML
    private StackPane C8;
    @FXML
    private StackPane D7;
    @FXML
    private StackPane E8;
    @FXML
    private StackPane F7;
    @FXML
    private StackPane G8;
    @FXML
    private StackPane H7;
    @FXML
    private StackPane A6;
    @FXML
    private StackPane C6;
    @FXML
    private StackPane G6;
    @FXML
    private StackPane B5;
    @FXML
    private StackPane D5;
    @FXML
    private StackPane F5;
    @FXML
    private StackPane H5;
    @FXML
    private StackPane A4;
    @FXML
    private StackPane C4;
    @FXML
    private StackPane E4;
    @FXML
    private StackPane G4;
    @FXML
    private StackPane H3;
    @FXML
    private StackPane F3;
    @FXML
    private StackPane D3;
    @FXML
    private StackPane B3;
    @FXML
    private StackPane A2;
    @FXML
    private StackPane C2;
    @FXML
    private StackPane E2;
    @FXML
    private StackPane G2;
    @FXML
    private StackPane B1;
    @FXML
    private StackPane D1;
    @FXML
    private StackPane F1;
    @FXML
    private StackPane H1;
    @FXML
    private StackPane A8;
    @FXML
    private StackPane B8;
    @FXML
    private StackPane D8;
    @FXML
    private StackPane A7;
    @FXML
    private StackPane C7;
    @FXML
    private StackPane B6;
    @FXML
    private StackPane A5;
    @FXML
    private StackPane C5;
    @FXML
    private StackPane E7;
    @FXML
    private StackPane F8;
    @FXML
    private StackPane G7;
    @FXML
    private StackPane H8;
    @FXML
    private StackPane D6;
    @FXML
    private StackPane F6;
    @FXML
    private StackPane H6;
    @FXML
    private StackPane E5;
    @FXML
    private StackPane G5;
    @FXML
    private StackPane B4;
    @FXML
    private StackPane A3;
    @FXML
    private StackPane A1;
    @FXML
    private StackPane B2;
    @FXML
    private StackPane C3;
    @FXML
    private StackPane D4;
    @FXML
    private StackPane F4;
    @FXML
    private StackPane D2;
    @FXML
    private StackPane C1;
    @FXML
    private StackPane E3;
    @FXML
    private StackPane F2;
    @FXML
    private StackPane E1;
    @FXML
    private StackPane G3;
    @FXML
    private StackPane H4;
    @FXML
    private StackPane G1;
    @FXML
    private StackPane H2;

    @FXML
    private ImageView e8;
    @FXML
    private ImageView b8;
    @FXML
    private ImageView c8;
    @FXML
    private ImageView a7;
    @FXML
    private ImageView b7;
    @FXML
    private ImageView c7;
    @FXML
    private ImageView d7;
    @FXML
    private ImageView d8;
    @FXML
    private ImageView f8;
    @FXML
    private ImageView e7;
    @FXML
    private ImageView f7;
    @FXML
    private ImageView g8;
    @FXML
    private ImageView g7;
    @FXML
    private ImageView h8;
    @FXML
    private ImageView h7;
    @FXML
    private ImageView a2;
    @FXML
    private ImageView a1;
    @FXML
    private ImageView b2;
    @FXML
    private ImageView b1;
    @FXML
    private ImageView c2;
    @FXML
    private ImageView c1;
    @FXML
    private ImageView d2;
    @FXML
    private ImageView d1;
    @FXML
    private ImageView e2;
    @FXML
    private ImageView e1;
    @FXML
    private ImageView f2;
    @FXML
    private ImageView f1;
    @FXML
    private ImageView g2;
    @FXML
    private ImageView h2;
    @FXML
    private ImageView g1;
    @FXML
    private ImageView h1;
    @FXML
    private ImageView a6;
    @FXML
    private ImageView b6;
    @FXML
    private ImageView c6;
    @FXML
    private ImageView d6;
    @FXML
    private ImageView e6;
    @FXML
    private ImageView f6;
    @FXML
    private ImageView h6;
    @FXML
    private ImageView g6;
    @FXML
    private ImageView a5;
    @FXML
    private ImageView b5;
    @FXML
    private ImageView c5;
    @FXML
    private ImageView d5;
    @FXML
    private ImageView e5;
    @FXML
    private ImageView g5;
    @FXML
    private ImageView h5;
    @FXML
    private ImageView a4;
    @FXML
    private ImageView b4;
    @FXML
    private ImageView c4;
    @FXML
    private ImageView d4;
    @FXML
    private ImageView e4;
    @FXML
    private ImageView f4;
    @FXML
    private ImageView g4;
    @FXML
    private ImageView h4;
    @FXML
    private ImageView a3;
    @FXML
    private ImageView b3;
    @FXML
    private ImageView c3;
    @FXML
    private ImageView d3;
    @FXML
    private ImageView e3;
    @FXML
    private ImageView f3;
    @FXML
    private ImageView g3;
    @FXML
    private ImageView h3;
    @FXML
    private ImageView a8;
    @FXML
    private ImageView f5;

    @FXML
    private TableView<RecordMove> tableView;
    @FXML
    private TableColumn<RecordMove, Integer> table_column_number;
    @FXML
    private TableColumn<RecordMove, String> table_column_white;
    @FXML
    private TableColumn<RecordMove, String> table_column_black;

    @FXML
    private Button save;

    @FXML
    private Button button_cancel_move;
    @FXML
    private Button button_new_game;
    @FXML
    private Button button_menu;
    @FXML
    private Button button_arrange;
    @FXML
    private Button button_delete;

    Double[] WhitePawnEval = new Double[]{
            10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0,
            5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0,
            1.0, 1.0, 2.0, 3.0, 3.0, 2.0, 1.0, 1.0,
            0.5, 0.5, 1.0, 2.5, 2.5, 1.0, 0.5, 0.5,
            0.0, 0.0, 0.0, 2.0, 2.0, 0.0, 0.0, 0.0,
            0.5, -0.5, -1.0, 0.0, 0.0, -1.0, -0.5, 0.5,
            0.5, 1.0, 1.0, -2.0, -2.0, 1.0, 1.0, 0.5,
            0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
    };

    Double[] KnightEval = new Double[]{
            -5.0, -4.0, -3.0, -3.0, -3.0, -3.0, -4.0, -5.0,
            -4.0, -2.0,  0.0,  0.0,  0.0,  0.0, -2.0, -4.0,
            -3.0,  0.5,  1.0,  1.5,  1.5,  1.0,  0.5, -3.0,
            -3.0,  0.0,  1.5,  2.0,  2.0,  1.5,  0.0, -3.0,
            -3.0,  0.0,  1.5,  2.0,  2.0,  1.5,  0.0, -3.0,
            -3.0,  0.5,  1.0,  1.5,  1.5,  1.0,  0.5, -3.0,
            -4.0, -2.0,  0.0,  0.0,  0.0,  0.0, -2.0, -4.0,
            -5.0, -4.0, -3.0, -3.0, -3.0, -3.0, -4.0, -5.0
    };

    Double[] WhiteBishopEval = new Double[]{
            -2.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0,
            -1.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -1.0,
            -1.0,  0.0,  0.5,  1.0,  1.0,  0.5,  0.0, -1.0,
            -1.0,  0.5,  0.5,  1.0,  1.0,  0.5,  0.5, -1.0,
            -1.0,  0.0,  1.0,  1.0,  1.0,  1.0,  0.0, -1.0,
            -1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0, -1.0,
            -1.0,  0.5,  0.0,  0.0,  0.0,  0.0,  0.5, -1.0,
            -2.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0
    };

    Double[] WhiteRookEval = new Double[]{
            0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5,
            -0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5,
            -0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5,
            -0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5,
            -0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5,
            -0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5,
            0.0, 0.0, 0.0, 0.5, 0.5, 0.0, 0.0, 0.0
    };

    Double[] QueenEval = new Double[]{
            -2.0, -1.0, -1.0, -0.5, -0.5, -1.0, -1.0, -2.0,
            -1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -1.0,
            -1.0, 0.0, 0.5, 0.5, 0.5, 0.5, 0.0, -1.0,
            -0.5, 0.0, 0.5, 0.5, 0.5, 0.5, 0.0, -0.5,
            -0.5, 0.0, 0.5, 0.5, 0.5, 0.5, 0.0, -0.5,
            -1.0, 0.0, 0.5, 0.5, 0.5, 0.5, 0.0, -1.0,
            -1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -1.0,
            -2.0, -1.0, -1.0, -0.5, -0.5, -1.0, -1.0, -2.0
    };

    Double[] WhiteKingEval = new Double[]{
            -3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0,
            -3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0,
            -3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0,
            -3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0,
            -2.0, -3.0, -3.0, -4.0, -4.0, -3.0, -3.0, -2.0,
            -1.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -1.0,
            2.0, 2.0, 0.0, 0.0, 0.0, 0.0, 2.0, 2.0,
            2.0, 3.0, 1.0, 0.0, 0.0, 1.0, 3.0, 2.0
    };

    @FXML
    void initialize() throws IOException {
        CreateCollection();
        SetTableData();
        number_move = 0;
        flag_arrange = false;
        Basic();
        if(flag_load) {
            Zeros();
            Stage primaryStage = new Stage();
            loadFunction(file_chooser.showOpenDialog(primaryStage).getAbsolutePath());
        }

        button_arrange.setSkin(new MyButtonSkin(button_arrange,0.5));
        button_menu.setSkin(new MyButtonSkin(button_menu,0.5));
        button_new_game.setSkin(new MyButtonSkin(button_new_game,0.5));
        button_cancel_move.setSkin(new MyButtonSkin(button_cancel_move,0.5));
        save.setSkin(new MyButtonSkin(save,0.5));

        GridPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1)
                    AllFunctions(event.getX(), event.getY());
            }
        });

        button_new_game.setOnAction(event-> {
            NewGame();
        });

        save.setOnAction(event -> {
            Save();
        });

        button_cancel_move.setOnAction(event -> {
            Cancel();
        });

        button_menu.setOnAction(event-> {
            ((Stage) button_menu.getScene().getWindow()).close();
            OpenMainMenuWindow();
        });

        button_arrange.setOnAction(event->{
            Zeros();
            Arrange();
        });
    }

    public void Zeros() {
        for (Cell cell : Cell.values()) {
            ForCapture(cell);
            FindStackPane(cell).setStyle(FindStackPane(cell).getStyle() + "-fx-border-width: 0;");
        }
        number_move = record.size();
        while (number_move != 0)
            record.remove(--number_move);
        while(arrayCancelMove.getSize() != 0)
            arrayCancelMove.DeleteArrayCancel();
        record_move = "";
        flag_arrange = false;
    }

    public void Arrange()  {
        flag_arrange = true;
        while((figure_arrange = ArrangePositionFunc()).getName().compareTo("E") != 0)
        {
            GridPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    int letter, number;
                    if (event.getClickCount() == 1) {
                        letter = ForNumberLetter(event.getX());//определяем букву клетки куда ткнули мышкой для выбора фигуры
                        number = ForNumberNumber(event.getY());//определяем цифру клетки куда ткнули мышкой для выбора фигуры
                        FindCell(letter, number).figure = figure_arrange;//определяем клетку куда ткнули мышкой для выбора фигуры
                        FindCell(letter, number).isOccupied = true;
                        if (figure_arrange.getFigureColor() == FigureColor.WHITE)
                            FindImageView(FindCell(letter, number)).setImage(setWhite(figure_arrange));
                        else
                            FindImageView(FindCell(letter, number)).setImage(setBlack(figure_arrange));
                    }
                }
            });
        }
        GridPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 1) {
                    PlayingTwo(event.getX(), event.getY());
                }
            }
        });
    }

    public static void setFlags(boolean flag_two, boolean flag_one, boolean load)  {
        flag_two_players = flag_two;
        flag_one_player = flag_one;
        flag_load = load;
    }

    public void CreateCollection() {
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

    public void SetTableData() {
        //устанавливаем значения откуда будут браться данные для таблицы

        table_column_number.setCellValueFactory(new PropertyValueFactory("number_move"));
        table_column_white.setCellValueFactory(new PropertyValueFactory("white_move"));
        table_column_black.setCellValueFactory(new PropertyValueFactory("black_move"));
        tableView.setItems(record);
        tableView.setEditable(true);

    }

    public void Basic() {
        BasicArrangementLogic();
        ArrangementGraphic();
        flag_cell = true;
        flag_move = FigureColor.WHITE;
    }

    public void BasicArrangementLogic() {
        for (Cell cell : Cell.values())
            ForCapture(cell);
        //заполняем начальную расстановку фигур
        Cell.a1.figure = new Rook("R", FigureColor.WHITE);
        Cell.b1.figure = new Knight("N", FigureColor.WHITE);
        Cell.c1.figure = new Bishop("B", FigureColor.WHITE);
        Cell.d1.figure = new Queen("Q", FigureColor.WHITE);
        Cell.e1.figure = new King("K", FigureColor.WHITE);
        Cell.f1.figure = new Bishop("B", FigureColor.WHITE);
        Cell.g1.figure = new Knight("N", FigureColor.WHITE);
        Cell.h1.figure = new Rook("R", FigureColor.WHITE);
        Cell.a8.figure = new Rook("R", FigureColor.BLACK);
        Cell.b8.figure = new Knight("N", FigureColor.BLACK);
        Cell.c8.figure = new Bishop("B", FigureColor.BLACK);
        Cell.d8.figure = new Queen("Q", FigureColor.BLACK);
        Cell.e8.figure = new King("K", FigureColor.BLACK);
        Cell.f8.figure = new Bishop("B", FigureColor.BLACK);
        Cell.g8.figure = new Knight("N", FigureColor.BLACK);
        Cell.h8.figure = new Rook("R", FigureColor.BLACK);
        Cell.a2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.b2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.c2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.d2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.e2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.f2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.g2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.h2.figure = new Pawn("P", FigureColor.WHITE);
        Cell.a7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.b7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.c7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.d7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.e7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.f7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.g7.figure = new Pawn("P", FigureColor.BLACK);
        Cell.h7.figure = new Pawn("P", FigureColor.BLACK);

        for (int i = 1; i <= 8; i++) {
            for (int j = 3; j <= 6; j++) {
                FindCell(i, j).figure = new EmptyFigure("E");
            }
        }

        //расставляем флаги занятости клеток
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (FindCell(i, j).figure.getName().compareTo("E") != 0)
                    FindCell(i, j).isOccupied = true;
            }
        }
    }

    public static void ArrangementGraphic() {
        for (Cell curr_cell : Cell.values()) {
            for (ImageView curr_image : list) {
                //если совпадает имя ячейки curr_cell и curr_image устанавливаем в curr_image картинку для фигуры которая стоит в curr_cell
                if (curr_cell.name().compareTo(curr_image.getId()) == 0) {
                    if (curr_cell.figure.getFigureColor() == FigureColor.WHITE)
                        curr_image.setImage(setWhite(curr_cell.figure));
                    else
                        curr_image.setImage(setBlack(curr_cell.figure));
                    break;
                }
            }
        }
    }

    public static Image setWhite(ForAllFigures figure) {
        //в завсисимости от имени фигуры возвращаем картинку для белых
        switch (figure.getName()) {
            case "P":
                return white_pawn;
            case "R":
                return white_rook;
            case "N":
                return white_knight;
            case "B":
                return white_bishop;
            case "K":
                return white_king;
            case "Q":
                return white_queen;
            default:
                return empty_figure;
        }
    }

    public static Image setBlack(ForAllFigures figure) {
        //в завсисимости от имени фигуры возвращаем картинку для черных
        switch (figure.getName()) {
            case "P":
                return black_pawn;
            case "R":
                return black_rook;
            case "N":
                return black_knight;
            case "B":
                return black_bishop;
            case "K":
                return black_king;
            case "Q":
                return black_queen;
            default:
                return empty_figure;
        }
    }

    public void AllFunctions(Double ex, Double ey)//в зависимости от того, что тыкнет пользователь:
    // игру вдвоем, с компом и тд будут вызываться разные функции для GridPane
    {
        if(flag_two_players || flag_load)
            PlayingTwo(ex, ey);
        else if(flag_one_player)
            PlayingOne(ex, ey);
    }

    public void PlayingTwo(Double ex, Double ey) {
        if (flag_cell) {
            letter_begin = ForNumberLetter(ex);//определяем букву клетки куда ткнули мышкой для выбора фигуры
            number_begin = ForNumberNumber(ey);//определяем цифру клетки куда ткнули мышкой для выбора фигуры
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
            letter_end = ForNumberLetter(ex);//определяем букву клетки куда ткнули мышкой для выбора поля куда пойдет фигура
            number_end = ForNumberNumber(ey);//определяем цифру клетки куда ткнули мышкой для выбора поля куда пойдет фигура
            cellforpawn = cell_end = FindCell(letter_end, number_end);//определяем клетку куда ткнули мышкой для выбора поля куда пойдет фигура
            System.out.println(cell_end + " end");
            FindImageView(cell_begin).setEffect(null);
            EndMove();
        }
    }

    public void PlayingOne(Double ex, Double ey) {
        if (flag_cell) {
            letter_begin = ForNumberLetter(ex);//определяем букву клетки куда ткнули мышкой для выбора фигуры
            number_begin = ForNumberNumber(ey);//определяем цифру клетки куда ткнули мышкой для выбора фигуры
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
            letter_end = ForNumberLetter(ex);//определяем букву клетки куда ткнули мышкой для выбора поля куда пойдет фигура
            number_end = ForNumberNumber(ey);//определяем цифру клетки куда ткнули мышкой для выбора поля куда пойдет фигура
            cellforpawn = cell_end = FindCell(letter_end, number_end);//определяем клетку куда ткнули мышкой для выбора поля куда пойдет фигура
            System.out.println(cell_end + " end");
            FindImageView(cell_begin).setEffect(null);
            EndMove();
            if (flag_move == FigureColor.BLACK) {
                if (!CheckMate(flag_move)) {
                    Minimax(FigureColor.BLACK, 3);
                    getPossibleMovesThisFigure(cell_begin);
                    EndMove();
                }
            }
        }
    }

    public void Minimax(FigureColor figureColor, int count) {
        double totalEval;
        int number = 0;
        ArrayList<Double> minimax_total = new ArrayList<Double>();
        ArrayList<Cell> minimax_cell_begin = new ArrayList<Cell>();
        ArrayList<Cell> minimax_cell_end = new ArrayList<Cell>();
        for (Cell cell : Cell.values()) {
            if (cell.figure.getFigureColor() == figureColor) {
                for (Cell curr : getPossibleMovesThisFigure(cell)) {//проходим по возможным ходам фигуры
                    MoveLogicForPossibleMoves(cell, curr);//делаем ход
                    minimax_total.add(minimax_total.size(), TotalEval());
                    minimax_cell_begin.add(minimax_cell_begin.size(), cell);
                    minimax_cell_end.add(minimax_cell_end.size(), curr);
                    CancelForPossibleMoves();//отменить ход
                }
            }
        }
        try {
            totalEval = minimax_total.get(0);
            if(figureColor == FigureColor.BLACK) {
                for (int i = 0; i < minimax_total.size(); i++) {
                    if (minimax_total.get(i) <= totalEval) {
                        totalEval = minimax_total.get(i);
                        number = i;
                    }
                }
            }
            else
            {
                for (int i = 0; i < minimax_total.size(); i++) {
                    if (minimax_total.get(i) >= totalEval) {
                        totalEval = minimax_total.get(i);
                        number = i;
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException | NullPointerException e)
        {
            e.getLocalizedMessage();
        }
        cell_begin = minimax_cell_begin.get(number);
        cell_end = minimax_cell_end.get(number);
    }

    /*public void Minimax(FigureColor figureColor, int count) {
        double totalEval;
        int flag;
        ArrayList<Double> minimax_total = new ArrayList<Double>();
        ArrayList<Cell> minimax_cell_begin = new ArrayList<Cell>();
        ArrayList<Cell> minimax_cell_end = new ArrayList<Cell>();

        ArrayList<Cell> every_level_list_begin = new ArrayList<Cell>();
        ArrayList<Cell>every_level_list_end = new ArrayList<Cell>();
        int number = 0;
        Cell begin, end;
        for (Cell cell : Cell.values()) {
            if (cell.figure.getFigureColor() == figureColor) {
                for (Cell curr : getPossibleMovesThisFigure(cell)) {//проходим по возможным ходам фигуры
                    MoveLogicForPossibleMoves(cell, curr);//делаем ход
                    minimax_total.add(minimax_total.size(), TotalEval());
                    minimax_cell_begin.add(minimax_cell_begin.size(), cell);
                    minimax_cell_end.add(minimax_cell_end.size(), curr);
                    CancelForPossibleMoves();//отменить ход
                }
            }
        }
        try {

            flag = 5;
            if(figureColor == FigureColor.BLACK) {
                while(flag— > 0 && minimax_total.size() > 0) {
                    totalEval = minimax_total.get(0);
                    for (int i = 0; i < minimax_total.size(); i++) {
                        if (minimax_total.get(i) <= totalEval) {
                            totalEval = minimax_total.get(i);
                            number = i;
                        }
                    }
                    every_level_list_begin.add(every_level_list_begin.size(), minimax_cell_begin.get(number));
                    every_level_list_end.add(every_level_list_end.size(), minimax_cell_end.get(number));
                    minimax_total.remove(number);
                    minimax_cell_begin.remove(number);
                    minimax_cell_end.remove(number);
                }
            }
            else
            {
                while(flag— > 0 && minimax_total.size() > 0) {
                totalEval = minimax_total.get(0);
                for (int i = 0; i < minimax_total.size(); i++) {
                    if (minimax_total.get(i) >= totalEval) {
                        totalEval = minimax_total.get(i);
                        number = i;
                    }
                }
                every_level_list_begin.add(every_level_list_begin.size(), minimax_cell_begin.get(number));
                every_level_list_end.add(every_level_list_end.size(), minimax_cell_end.get(number));
                minimax_total.remove(number);
                minimax_cell_begin.remove(number);
                minimax_cell_end.remove(number);
            }
            }
        }
        catch (IndexOutOfBoundsException | NullPointerException e)
        {
            e.getLocalizedMessage();
        }
//begin = minimax_cell_begin.get(number);
//end = minimax_cell_end.get(number);

        if(count != 0) {
            for (int i = 0; i < every_level_list_begin.size(); i++) {
                MoveLogicForPossibleMoves(every_level_list_begin.get(i), every_level_list_end.get(i));//делаем ход
                count--;
                if (flag_attackking_move) {
                    figureColor = ViceVersa(figureColor);
//System.out.print(count + " ");
                    Minimax(figureColor, count);
//System.out.print(count + " ");
                    if (figureColor == FigureColor.BLACK) {
                        if (count == 0 && Total <= TotalEval()) {
                            Total = TotalEval();
                            begin_minimax = every_level_list_begin.get(i);
                            end_minimax = every_level_list_end.get(i);
                        } else {
                            if (Total <= TotalEval()) {
                                Total = TotalEval();
                                begin_minimax = every_level_list_begin.get(i);
                                end_minimax = every_level_list_end.get(i);
                            }
                        }
                    } else {
                        if (count == 0 && Total >= TotalEval()) {
                            Total = TotalEval();
                            begin_minimax = every_level_list_begin.get(i);
                            end_minimax = every_level_list_end.get(i);
                        } else {
                            if (Total >= TotalEval()) {
                                Total = TotalEval();
                                begin_minimax = every_level_list_begin.get(i);
                                end_minimax = every_level_list_end.get(i);
                            }
                        }
                    }
//System.out.print(begin_minimax + " " + end_minimax + " " + Total + " ");
                    CancelForPossibleMoves();//отменить ход
                }
                count++;
            }
        }
        if(count == 3)
        {
            cell_begin = begin_minimax;
            cell_end = end_minimax;
        }
*/

    //функция MoveLogicForPossibleMoves аналогичная MoveLogic, но сделанная для выделения только возможных ходов каждой фигуры
    public static void MoveLogicForPossibleMoves(Cell begin, Cell end)  {//функция аналогичная MoveLogic, но сделанная для выделения только возможных ходов каждой фигуры
        try {
            flag_attackking_move = false;
            for (Cell curr : begin.figure.PossibleMoves(begin)) {
                if (end == curr) {//если клетка конца равна какому-то элементу из списка возможных ходов фигуры
                    arrayCancelMove.AddArrayCancel(new CancelMove(begin, end));//создаем список для отмены хода
                    ResetFigures(begin, end);
                    flag_attackking_move = true;
                    break;
                }
            }
        }
        catch (NullPointerException e)
        {
            e.getLocalizedMessage();
        }
    }
    //функция CancelForPossibleMoves аналогичная MoveLogic, но сделанная для выделения только возможных ходов каждой фигуры
    public static void CancelForPossibleMoves() {
        //если flag_cell равен true - если сейчас завершена попытка хода
        if (flag_cell) {
            curr = arrayCancelMove.getCancelMove(arrayCancelMove.getSize() - 1);//в объект типа CanceMove записываем последний элемент arrayCancelMove
            curr.getArray_Cell().get(0).figure = curr.getFigure_begin();//находим клетку начала хода и ставим туда фигуру которая ходила
            curr.getArray_Cell().get(0).isOccupied = true;//флаг занятости в эту же клетку ставим true
            curr.getArray_Cell().get(1).figure = curr.getFigure_end();//аналогично делаем с клеткой конца
            if (curr.getArray_Cell().get(1).figure.getName().compareTo("E") == 0)//если там стояла фигура, то флаг нет смылса ставить true
                curr.getArray_Cell().get(1).isOccupied = false;//если фигуры не стояло(стояла фигура EmptyFigure, то флаг занятости false
            //если ходила пешка и буква ее начальной клетки и конечной различаюся и если в конечной клетке стояла пустая фигура
            if (curr.getFigure_begin().getName().compareTo("P") == 0 && curr.getArray_Cell().get(1).letter != curr.getArray_Cell().get(0).letter && curr.getFigure_end().getName().compareTo("E") == 0 && curr.getArray_Cell().get(1).name().compareTo("a1") != 0) {
                FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number).isOccupied = true;//ставим флаг занятости в клекту на 1 выше(или ниже для белых) true, потому что там дожна стоять пешка
                if (curr.getFigure_begin().getFigureColor() == FigureColor.WHITE) {//если цвет фигуры которая ходила белый
                    //то ставим черную пешку
                    FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number).figure = new Pawn("P", FigureColor.BLACK);
                    FindImageView(FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number)).setImage(setBlack(FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number).figure));
                } else {//иначе для противоположного цвета
                    /*for(int i = 0; i < arrayCancelMove.getSize(); i++)
                    {
                        System.out.println(i + " " + arrayCancelMove.getCancelMove(i).getArray_Cell().get(0) + " " +
                                arrayCancelMove.getCancelMove(i).getArray_Cell().get(1) + " " +
                                arrayCancelMove.getCancelMove(i).getFigure_begin() + " " +
                                arrayCancelMove.getCancelMove(i).getFigure_end());
                    }*/
                    FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number).figure = new Pawn("P", FigureColor.WHITE);
                    FindImageView(FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number)).setImage(setWhite(FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number).figure));
                }
            }

            arrayCancelMove.DeleteArrayCancel();//удаляем последний элемент из списка
        }
    }

    public void EndMove(){
        MoveLogic(cell_begin, cell_end);//вызов функции логики хода
        MagicPawn();//функция замены пешки при доходе до последней горизонтали

        flag_move = ViceVersa(flag_move);//меняем значение флага отвечающего за очередь хода на противоположный
        flag_cell = true;//меняем флаг для начала хода
        CheckMateToTable();//проверка на мат для записи в таблицу

                        /*
                        if(number_move >= 5) {
                            if (tableView.getItems().get(number_move - 5).getWhite_move().compareTo(tableView.getItems().get(number_move - 3).getWhite_move()) == 0) {
                                if (tableView.getItems().get(number_move - 4).getWhite_move().compareTo(tableView.getItems().get(number_move - 2).getWhite_move()) == 0) {
                                    if (tableView.getItems().get(number_move - 5).getBlack_move().compareTo(tableView.getItems().get(number_move - 3).getBlack_move()) == 0) {
                                        if (tableView.getItems().get(number_move - 4).getBlack_move().compareTo(tableView.getItems().get(number_move - 2).getBlack_move()) == 0) {
                                            System.out.println("Draw");
                                        }
                                    }
                                }
                            }
                        }
                         */
        tableView.refresh();
        System.out.println(TotalEval());
    }

    public Double TotalEval(){
        //общая оценка всей позиции на доске
        Double totalEvaluation = 0.0;
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++)
                totalEvaluation += getAbsoluteEval(FindCell(i, j));
        }

        if(CheckMate(FigureColor.WHITE))//если на доске мат белым, то оценка уменьшается до минимума
            totalEvaluation -= 5000;
        else if(CheckMate(FigureColor.BLACK))//иначе если на доске мат черным, то оценка увеличивается до максимума
            totalEvaluation += 5000;

        return totalEvaluation;
    }

    public Double getAbsoluteEval(Cell curr) {
        //оценка фигуры на клетке
        switch (curr.figure.getName()) {
            case "P" :
                return (curr.figure.getFigureColor() == FigureColor.WHITE ? WhitePawnEval[(8 - curr.number) * 8 + curr.letter - 1] + 1 : WhitePawnEval[(curr.number - 1) * 8 + curr.letter - 1] * (-1) - 1);
            case "R" :
                return (curr.figure.getFigureColor() == FigureColor.WHITE ? WhiteRookEval[(8 - curr.number) * 8 + curr.letter - 1] + 5 : WhiteRookEval[(curr.number - 1) * 8 + curr.letter - 1] * (-1) - 5);
            case "N" :
                return (curr.figure.getFigureColor() == FigureColor.WHITE ? KnightEval[(8 - curr.number) * 8 + curr.letter - 1] + 3 : KnightEval[(curr.number - 1) * 8 + curr.letter - 1] * (-1) - 3);
            case "B" :
                return (curr.figure.getFigureColor() == FigureColor.WHITE ? WhiteBishopEval[(8 - curr.number) * 8 + curr.letter - 1] + 3 : WhiteBishopEval[(curr.number - 1) * 8 + curr.letter - 1] * (-1) - 3);
            case "Q" :
                return (curr.figure.getFigureColor() == FigureColor.WHITE ? QueenEval[(8 - curr.number) * 8 + curr.letter - 1] + 9 : QueenEval[(curr.number - 1) * 8 + curr.letter - 1] * (-1) - 9);
            case "K" :
                return (curr.figure.getFigureColor() == FigureColor.WHITE ? WhiteKingEval[(8 - curr.number) * 8 + curr.letter - 1] + 2500 : WhiteKingEval[(curr.number - 1) * 8 + curr.letter - 1] * (-1) - 2500);
            default:
                return 0.0;
        }
    }

    public void MoveLogic(Cell begin, Cell end) {
        flag_attackking_move = false;
        if(begin.figure.getName().compareTo("P") == 0)
            begin.figure.PossibleMoves(begin);
        for (Cell curr : possibleMovesThisFigure) {
            if (end == curr) {//если клетка конца равна какому-то элементу из списка возможных ходов фигуры
                arrayCancelMove.AddArrayCancel(new CancelMove(begin, end));//создаем список для отмены хода
                if(!flag_arrange)
                    RecordMoveFunction();//вызываем функцию записи ходов
                if(begin.figure.getName().compareTo("K") == 0 && begin.figure.isfirstMove()) {//если ходит король и он ходит первый раз
                    Castling(end);//функция рокировки, в которой переставляется ладья в зависимости от вида рокировки
                    begin.figure.setfirstMove(begin.figure.isfirstMove());//ставим флаг первого хода на противоположный
                }
                else if(begin.figure.getName().compareTo("R") == 0 && begin.figure.isfirstMove())//иначе если ходит ладья и ходит первый раз
                    begin.figure.setfirstMove(begin.figure.isfirstMove());//ставим флаг первого хода на противоположный
                ResetFigures(begin, end);
                //рисуем ход
                MoveGraphic(begin, end);
                //flag_save = false;
                flag_attackking_move = true;
                break;
            }
        }

        //снимаем выделение клеток возможных ходов фигуры
        for(Cell cell : possibleMovesThisFigure)
            FindStackPane(cell).setStyle(FindStackPane(cell).getStyle() + "-fx-border-width: 0;");

        if (! flag_attackking_move)//если ход не был совершен, то меняем флаг очереди хода на противоложный
            flag_move = ViceVersa(flag_move);
    }

    public void RecordMoveFunction() {
        if (flag_move == FigureColor.WHITE)
            ++number_move;

        if (cell_begin.figure.getName().compareTo("P") != 0)
            record_move = cell_begin.figure.getName() + cell_begin.name();//если ходит не пешка то запись вида Nf3
        else
            record_move = cell_begin.name();//если пешка просто ходит то запись вида e4

        record_move += "-";

        if (cell_begin.figure.getName().compareTo("P") != 0)
            record_move += cell_begin.figure.getName() + cell_end.name();//если ходит не пешка то запись вида Nf3
        else
            record_move += cell_end.name();//если пешка просто ходит то запись вида e4


        if (cell_begin.figure.getFigureColor() == FigureColor.WHITE) {//устанавливаем для таблицы ходы
            record.add(number_move - 1, new RecordMove());
            ((RecordMove) record.get(number_move - 1)).setNumber_move(number_move);
            ((RecordMove) record.get(number_move - 1)).setWhite_move(record_move);
        } else {
            ((RecordMove) record.get(number_move - 1)).setBlack_move(record_move);
            tableView.refresh();
            tableView.scrollTo(record.get(number_move - 1));
        }
    }

    public static String LETTER(int index){//функция перевода числа в заглавную букву для StackPane
        switch (index)
        {
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            case 4:
                return "D";
            case 5:
                return "E";
            case 6:
                return "F";
            case 7:
                return "G";
            default:
                return "H";
        }
    }

    public static String Letter(int index) {//функция перевода числа в заглавную букву для ImageView
        switch (index) {
            case 1:
                return "a";
            case 2:
                return "b";
            case 3:
                return "c";
            case 4:
                return "d";
            case 5:
                return "e";
            case 6:
                return "f";
            case 7:
                return "g";
            default:
                return "h";
        }
    }

    public static void MoveGraphic(Cell begin, Cell end) {
        //переставляем картинки
        FindImageView(end).setImage(empty_figure);
        FindImageView(end).setImage(FindImageView(begin).getImage());
        FindImageView(begin).setImage(empty_figure);
    }

    public FigureColor ViceVersa(FigureColor flag_move) {
        //смена значения flag_move на противоположное
        if (flag_move == FigureColor.WHITE)
            return FigureColor.BLACK;
        return FigureColor.WHITE;

    }

    public static void ResetFigures(Cell begin, Cell end) {
        //переставляем фигуры
        end.figure = begin.figure;
        begin.figure = new EmptyFigure("E");
        //переставляем флаги занятости клеток
        end.isOccupied = true;
        begin.isOccupied = false;
    }

    public void Castling(Cell end){
        if (end == Cell.g1) {//если король ходит на g1
            ResetFigures(Cell.h1, Cell.f1);//меняем фигуры стоящие на f1 и h1(ладью и пустое место
            Cell.f1.figure.setfirstMove(Cell.f1.figure.isfirstMove());//ставим у ладьи флаг первого хода на противоположный
            MoveGraphic(Cell.h1, Cell.f1);//рисуем поменянные фигуры местами
            if(!flag_arrange)
                tableView.getItems().get(number_move - 1).setWhite_move("0 - 0");//в таблице пишем вместо хода короля обозначение рокировки
        } else if (end == Cell.c1) {//аналогично тому что выше
            ResetFigures(Cell.a1, Cell.d1);
            Cell.d1.figure.setfirstMove(Cell.d1.figure.isfirstMove());
            MoveGraphic(Cell.a1, Cell.d1);
            if(!flag_arrange)
                tableView.getItems().get(number_move - 1).setWhite_move("0 - 0 - 0");
        } else if (end == Cell.g8) {//аналогично тому что выше
            ResetFigures(Cell.h8, Cell.f8);
            Cell.f8.figure.setfirstMove(Cell.f8.figure.isfirstMove());
            MoveGraphic(Cell.h8, Cell.f8);
            if(!flag_arrange)
                tableView.getItems().get(number_move - 1).setBlack_move("0 - 0");
        } else if (end == Cell.c8) {//аналогично тому что выше
            ResetFigures(Cell.a8, Cell.d8);
            Cell.d8.figure.setfirstMove(Cell.d8.figure.isfirstMove());
            MoveGraphic(Cell.a8, Cell.d8);
            if(!flag_arrange)
                tableView.getItems().get(number_move - 1).setBlack_move("0 - 0 - 0");
        }
    }

    public static ArrayList<Cell> getMoves(FigureColor figureColor) {
        ArrayList<Cell> Moves = new ArrayList<Cell>();//обнуляем список для всех фигур
        for (Cell cell : Cell.values()) {//проходим по всей доске
            if (cell.isOccupied && cell.figure.getFigureColor() != figureColor) {//если цвет фигуры не совпадает с тем что передали
                if (cell.figure.getName().compareTo("P") != 0) {//если фигура не пешка
                    for (Cell curr : cell.figure.PossibleMoves(cell))//добавляем все ее возможные ходы
                        Moves.add(Moves.size(), curr);
                } else {//иначе если фигура пешка
                    for (Cell curr : cell.figure.PossibleMoves(cell)) {
                        if (curr.letter != cell.letter)
                            Moves.add(Moves.size(), curr);//добавляем только те ходы, в которых менялась буква, то есть пешка била по диагонали
                    }
                }
            }
        }
        return Moves;
    }

    public static boolean AttackToKing(FigureColor figureColor, int count) {
        allPossibleMoves = new ArrayList<Cell>();
        allPossibleMoves = getMoves(figureColor);
        for(int i = 0; i < allPossibleMoves.size() - 1; i++) {//удаляем повторяющиеся клетки из списка
            for (int j = i + 1; j < allPossibleMoves.size(); j++) {
                if (allPossibleMoves.get(i) == allPossibleMoves.get(j)) {
                    allPossibleMoves.remove(j);
                }
            }
        }

        switch (count) {//в зависимости от параметра count вызываем разные функции для рокировок
            case 1 : return CastlingG1(allPossibleMoves);
            case 2 : return CastlingC1(allPossibleMoves);
            case -1 : return CastlingG8(allPossibleMoves);
            case -2 : return CastlingC8(allPossibleMoves);
            default: return ExaminationKing(allPossibleMoves);//по дефолту, если нужна не рокировка вызываем функцию проверки атаки на короля
        }
    }

    //функция проверки рокировки на g1
    public static boolean CastlingG1(ArrayList<Cell> arrayList) {
        for(Cell cell: arrayList)//проходим по всему списку возможных ходов
        {
            if(cell == Cell.f1 || cell == Cell.g1 || cell == Cell.e1)//если хоть одна из этих клеток есть, то возвращаем true, что значит, что клетки битые а значит нельзя рокироваться
                return true;
        }
        return false;//иначе возвращаем false, что значит, что клетки не битые и можно рокироваться
    }
    //аналогично тому что выше
    public static boolean CastlingC1(ArrayList<Cell> arrayList) {
        for(Cell cell: arrayList)
        {
            if(cell == Cell.d1 || cell == Cell.c1 || cell == Cell.e1)
                return true;
        }
        return false;
    }
    //аналогично тому что выше
    public static boolean CastlingG8(ArrayList<Cell> arrayList) {
        for(Cell cell: arrayList)
        {
            if(cell == Cell.f8 || cell == Cell.g8 || cell == Cell.e8)
                return true;
        }
        return false;
    }
    //аналогично тому что выше
    public static boolean CastlingC8(ArrayList<Cell> arrayList) {
        for(Cell cell: arrayList)
        {
            if(cell == Cell.d8 || cell == Cell.c8 || cell == Cell.e8)
                return true;
        }
        return false;
    }

    public static boolean ExaminationKing(ArrayList<Cell> arrayList) {
        for(Cell cell: arrayList)//проходим по всему списку
        {
            if(cell.figure.getName().compareTo("K") == 0)//если есть клетка с королем
                return true;//то возвращаем true, что значит, что король будет под боем
        }
        return false;//иначе король не под боем
    }

    public void CheckMateToTable(){
        //если атакован король противоположного цвета тому кто ходил
        if (AttackToKing(flag_move, 0) && flag_attackking_move)//и при этом ход был совершен
        {
            if (flag_move == FigureColor.BLACK) {//если черный цвет
                if (CheckMate(flag_move)) {//если на доске стоит мат
                    if(!flag_arrange)
                        record_move = tableView.getItems().get(number_move - 1).getWhite_move() + "#";
                    //здесь надо будет выводить окно с надписью того, кто победил
                    OpenWindowWhiteWin();
                }
                else//иначе если шах
                    if(!flag_arrange)
                        record_move = tableView.getItems().get(number_move - 1).getWhite_move() + "+";
                if(!flag_arrange)
                    ((RecordMove) record.get(number_move - 1)).setWhite_move(record_move);
            } else {//аналогично для другого цвета
                if (CheckMate(flag_move)) {
                    if(!flag_arrange)
                        record_move = tableView.getItems().get(number_move - 1).getBlack_move() + "#";
                    //здесь надо будет выводить окно с надписью того, кто победил
                    OpenWindowBlackWin();
                } else
                    if(!flag_arrange)
                         record_move = tableView.getItems().get(number_move - 1).getBlack_move() + "+";
                if(!flag_arrange)
                    ((RecordMove) record.get(number_move - 1)).setBlack_move(record_move);
            }
        }
    }

    public boolean CheckMate(FigureColor figureColor){
        for(Cell cell : Cell.values())//проходим по всем клеткам
        {
            if(cell.figure.getFigureColor() == figureColor)//если цвет фигуры в клетке равен цвету фигуры, чей король возможно под матом
            {
                if(getPossibleMovesThisFigure(cell).size() != 0)//то если список ее возможных ходов не нулевой, то возвращаем false, что значит, что королю мата нет
                    return false;
            }
        }
        return true;//если список всех возможных ходов всех возможных фигур нулевой то на доске мат - возвращаем true
    }

    public void OpenMainMenuWindow(){
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("/chess/fxmls/MainMenu.fxml"));
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
    }


    void OpenWin(FXMLLoader fxmlLoader){
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
            ((Stage)button_new_game.getScene().getWindow()).close();
            OpenMainMenuWindow();
        });
        stage.show();
    }
    public void OpenWindowWhiteWin() {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("/chess/fxmls/WhiteWin.fxml"));
        OpenWin(fxmlLoader);
    }

    public void OpenWindowBlackWin(){
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("/chess/fxmls/BlackWin.fxml"));
        OpenWin(fxmlLoader);
    }

    void OpenDraw() {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("/chess/fxmls/Draw.fxml"));
        OpenWin(fxmlLoader);
    }

    public void MagicPawn() {
        //если белая пешка дошла до 8 горизонтали
        if (cell_end.figure.getFigureColor() == FigureColor.WHITE && cell_end.figure.getName().compareTo("P") == 0 && cell_end.number == 8) {
            if(flag_one_player)
                cell_end.figure = new Queen("Q", FigureColor.WHITE);
            else
                cell_end.figure = ChangeWhitePawn(cell_end);
            FindImageView(cell_end).setImage(setWhite(cell_end.figure));
            record_move = tableView.getItems().get(number_move - 1).getWhite_move() + "-" + cell_end.figure.getName();
            ((RecordMove) record.get(number_move - 1)).setWhite_move(record_move);
        }
        //иначе если черная пешка дошла до 1 горизонтали
        else if (cell_end.figure.getFigureColor() == FigureColor.BLACK && cell_end.figure.getName().compareTo("P") == 0 && cell_end.number == 1) {
            if(flag_one_player)
                cell_end.figure = new Queen("Q", FigureColor.BLACK);
            else
                cell_end.figure = ChangeBlackPawn(cell_end);
            FindImageView(cell_end).setImage(setBlack(cell_end.figure));
            record_move = tableView.getItems().get(number_move - 1).getBlack_move() + "-" + cell_end.figure.getName();
            ((RecordMove) record.get(number_move - 1)).setBlack_move(record_move);
        }
    }

    public static int ForNumberLetter(double num) {
        //получаем значения номера буквы клетки
        return (int) (num / 90.0D + 1);
    }

    public static int ForNumberNumber(double num) {
        //получаем значения номера клетки
        return (int) ((720 - num) / 90.0D + 1);
    }

    public static Cell FindCell(int letter, int number) {
        Cell curr = Cell.a1;
        for (Cell cell : Cell.values()) {
            //проходим по всему перечислению
            if (cell.letter == letter && cell.number == number) {//если значения буквы и цифры совпадают
                curr = cell;
                break;
            }
        }
        return curr;
    }

    public static ImageView FindImageView(Cell cell) {
        ImageView image = new ImageView(empty_figure);
        //проходим по всему списку
        for (ImageView curr : list) {
            if (curr.getId().compareTo(cell.name()) == 0) {//если имя ImageView совпадает с именем клетки из перечисления
                image = curr;
                break;
            }
        }

        return image;
    }

    public static ArrayList<Cell> getPossibleMovesThisFigure(Cell begin){
        possibleMovesThisFigure = new ArrayList<Cell>();//создаем новый список
        for (Cell cell : begin.figure.PossibleMoves(begin)) {//проходим по всем возможным ходам фигуры без ограничений
            cellforpawn = cell;
            MoveLogicForPossibleMoves(begin, cell);//делаем ход
            if (!(AttackToKing(cell.figure.getFigureColor(), 0) && flag_attackking_move))//если свой король не атакован
                possibleMovesThisFigure.add(possibleMovesThisFigure.size(), cell);//то записываем этот ход в список возможных ходов для данной фигуры
            CancelForPossibleMoves();//отменить ход
        }
        return possibleMovesThisFigure;
    }

    public static StackPane FindStackPane(Cell cell) {
        StackPane stackPane = new StackPane();
        //проходим по всему списку
        for (StackPane curr : List) {
            if (curr.getId().compareTo(LETTER(cell.letter) + cell.number) == 0) {//если имя StackPane совпадает с именем клетки из перечисления
                stackPane = curr;
                break;
            }
        }

        return stackPane;
    }

    public void NewGame() {
        Zeros();
        Basic();
    }

    public void Save(){
        Stage SaveAsStage = new Stage();

        try {
            record_move = "";

            for(int i = 0; i < record.size(); i++)//записываем все ходы в одну строку
                record_move += record.get(i).getNumber_move() + " " + record.get(i).getWhite_move() + " " + record.get(i).getBlack_move() + " ";

            SaveForFile(file_chooser.showSaveDialog(SaveAsStage).getAbsolutePath());//вызываем функцию SaveForFile передавая как параметр имя выбранного файла
        } catch (IOException | NullPointerException e) {//исключения
            e.printStackTrace();
        }
        if(flag_move == FigureColor.BLACK)//если очередь хода черных
            record_move = tableView.getItems().get(number_move - 1).getWhite_move();//записываем в переменную последний ход белых
        else//иначе наоборот
            record_move = tableView.getItems().get(number_move - 1).getBlack_move();
    }

    public void SaveForFile(String filename) throws IOException {
        File save_file = new File(filename);
        PrintWriter printWriter = new PrintWriter(save_file);
        printWriter.println(SaveGamePositionInString());//записываем в файл позицию, номер хода, запись партии и чей ход
        printWriter.println(record_move);
        printWriter.println(number_move);
        printWriter.print(flag_move.name());
        printWriter.close();
    }

    public String SaveGamePositionInString() {
        String str = "";
        Cell[] arr = Cell.values();

        for(int i = 0; i < arr.length; i++) {//проходим по всей доске
            Cell curr = arr[i];
            if (curr.isOccupied) {//если клетка занята
                if (curr.figure.getFigureColor() == FigureColor.WHITE)//если фигура белая, то пишем запись типа WNf3
                    str += "W" + curr.figure.getName() + curr.name() + " ";
                else//иначе если черная то BNf3
                    str += "B" + curr.figure.getName() + curr.name() + " ";
            }
        }

        return str;
    }

    public void loadFunction(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String game_position = bufferedReader.readLine();
        Arrangement(game_position);
        RecordCollection(bufferedReader.readLine());
        SetTableData();
        number_move = Integer.parseInt(bufferedReader.readLine());
        if (bufferedReader.readLine().compareTo("WHITE") == 0)
            flag_move = FigureColor.WHITE;
        else
            flag_move = FigureColor.BLACK;

        bufferedReader.close();
    }

    public void RecordCollection(String record_move) {
        int flag = 1;

        number_move = 0;
        int i = 0;

        for(int count = 0; i < record_move.length(); ++i) {
            if (record_move.toCharArray()[i] == ' ' || record_move.toCharArray()[i] == '\n') {
                char[] array = new char[i - count];
                System.arraycopy(record_move.toCharArray(), count, array, 0, i - count);
                String str = new String(array);
                if (flag == 1) {
                    ++number_move;
                    record.add(number_move - 1, new RecordMove());
                    ((RecordMove) record.get(number_move - 1)).setNumber_move(number_move);
                    ++flag;
                } else if (flag == 2) {
                    ((RecordMove) record.get(number_move - 1)).setWhite_move(str);
                    ++flag;
                } else {
                    ((RecordMove) record.get(number_move - 1)).setBlack_move(str);
                    flag = 1;
                }
                count = i + 1;
            }
        }
    }

    public void Arrangement(String game_position){
        char[] arr_cell = new char[2];
        int i = 0;

        for(int count = 0; i < game_position.length(); ++i) {
            if (game_position.toCharArray()[i] == ' ' || game_position.toCharArray()[i] == '\n') {
                char[] array = new char[i - count];
                System.arraycopy(game_position.toCharArray(), count, array, 0, i - count);
                arr_cell[1] = array[array.length - 1];
                arr_cell[0] = array[array.length - 2];
                String str_cell = new String(arr_cell);
                char[] arr_figure = new char[array.length - arr_cell.length];
                System.arraycopy(array, 0, arr_figure, 0, arr_figure.length);
                String str_figure = new String(arr_figure);

                Cell[] arr = Cell.values();
                int size = arr.length;

                for(int j = 0; j < size; j++) {
                    Cell curr = arr[j];
                    if (curr.name().compareTo(str_cell) == 0) {
                        curr.figure = FactoryFigure(str_figure);
                        curr.isOccupied = true;
                        break;
                    }
                }

                count = i + 1;
            }
        }
        ArrangementGraphic();
    }

    public ForAllFigures FactoryFigure(String str) {
        switch(str)
        {
            case "WP":
                return new Pawn("P", FigureColor.WHITE);
            case "BP":
                return new Pawn("P", FigureColor.BLACK);
            case "WB":
                return new Bishop("B", FigureColor.WHITE);
            case "BB":
                return new Bishop("B", FigureColor.BLACK);
            case "WN":
                return new Knight("N", FigureColor.WHITE);
            case "BN":
                return new Knight("N", FigureColor.BLACK);
            case "WK":
                return new King("K", FigureColor.WHITE);
            case "BK":
                return new King("K", FigureColor.BLACK);
            case "WQ":
                return new Queen("Q", FigureColor.WHITE);
            case "BQ":
                return new Queen("Q", FigureColor.BLACK);
            case "WR":
                return new Rook("R", FigureColor.WHITE);
            case "BR":
                return new Rook("R", FigureColor.BLACK);
            default:
                return new EmptyFigure("E");
        }
    }

    public void Cancel() {
        //если flag_cell равен true - если сейчас завершена попытка хода
        if (flag_cell) {
            curr = arrayCancelMove.getCancelMove(arrayCancelMove.getSize() - 1);//в объект типа CanceMove записываем последний элемент arrayCancelMove
            curr.getArray_Cell().get(0).figure = curr.getFigure_begin();//находим клетку начала хода и ставим туда фигуру которая ходила
            curr.getArray_Cell().get(0).isOccupied = true;//флаг занятости в эту же клетку ставим true
            curr.getArray_Cell().get(1).figure = curr.getFigure_end();//аналогично делаем с клеткой конца
            if (curr.getArray_Cell().get(1).figure.getName().compareTo("E") == 0)//если там стояла фигура, то флаг нет смылса ставить true
                curr.getArray_Cell().get(1).isOccupied = false;//если фигуры не стояло(стояла фигура EmptyFigure, то флаг занятости false
            //если ходила пешка и буква ее начальной клетки и конечной различаюся и если в конечной клетке стояла пустая фигура
            if (curr.getFigure_begin().getName().compareTo("P") == 0 && curr.getArray_Cell().get(1).letter != curr.getArray_Cell().get(0).letter && curr.getFigure_end().getName().compareTo("E") == 0) {
                FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number).isOccupied = true;//ставим флаг занятости в клекту на 1 выше(или ниже для белых) true, потому что там дожна стоять пешка
                if (curr.getFigure_begin().getFigureColor() == FigureColor.WHITE) {//если цвет фигуры которая ходила белый
                    //то ставим черную пешку
                    FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number).figure = new Pawn("P", FigureColor.BLACK);
                    FindImageView(FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number)).setImage(setBlack(FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number).figure));
                } else//иначе для противоположного цвета
                {
                    FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number).figure = new Pawn("P", FigureColor.WHITE);
                    FindImageView(FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number)).setImage(setWhite(FindCell(curr.getArray_Cell().get(1).letter, curr.getArray_Cell().get(0).number).figure));
                }
            } else if (curr.getFigure_begin().getName().compareTo("K") == 0) {//если фигура которой ходили была король
                curr.getFigure_begin().setfirstMove(curr.getFigure_begin().isfirstMove());//ставим флаг первого хода противоположным
                if (curr.getArray_Cell().get(1) == Cell.g1) {//если клетка куда ходили это g1
                    ResetFigures(Cell.f1, Cell.h1);
                    Cell.h1.figure.setfirstMove(Cell.h1.figure.isfirstMove());//в f1 ставим пустую
                    MoveGraphic(Cell.f1, Cell.h1);
                    tableView.getItems().get(number_move - 1).setWhite_move(" ");//обновляем таблицу записи убирая последний ход
                } else if (curr.getArray_Cell().get(1) == Cell.c1) {//аналогично тому, что выше
                    ResetFigures(Cell.d1, Cell.a1);
                    Cell.a1.figure.setfirstMove(Cell.a1.figure.isfirstMove());
                    MoveGraphic(Cell.d1, Cell.a1);
                    tableView.getItems().get(number_move - 1).setWhite_move(" ");
                } else if (curr.getArray_Cell().get(1) == Cell.g8) {//аналогично тому, что выше
                    ResetFigures(Cell.f8, Cell.h8);
                    Cell.h8.figure.setfirstMove(Cell.h8.figure.isfirstMove());
                    MoveGraphic(Cell.f8, Cell.h8);
                    tableView.getItems().get(number_move - 1).setBlack_move(" ");
                } else if (curr.getArray_Cell().get(1) == Cell.c8) {//аналогично тому, что выше
                    ResetFigures(Cell.d8, Cell.a8);
                    Cell.a8.figure.setfirstMove(Cell.a8.figure.isfirstMove());
                    MoveGraphic(Cell.d8, Cell.a8);
                    tableView.getItems().get(number_move - 1).setBlack_move(" ");
                }
            }

            if (curr.getFigure_begin().getFigureColor() == FigureColor.WHITE)//если цвет фигуры белый для клетки начала
                //то ставим белую картинку
                FindImageView(curr.getArray_Cell().get(0)).setImage(setWhite(curr.getFigure_begin()));
            else//иначе черную
                FindImageView(curr.getArray_Cell().get(0)).setImage(setBlack(curr.getFigure_begin()));

            if (this.curr.getFigure_end().getFigureColor() == FigureColor.WHITE)//если цвет фигуры белый для клетки конца
                //то ставим белую картинку
                FindImageView(curr.getArray_Cell().get(1)).setImage(setWhite(curr.getFigure_end()));
            else//иначе черную
                FindImageView(curr.getArray_Cell().get(1)).setImage(setBlack(curr.getFigure_end()));

            if(!flag_arrange) {
                if (flag_move == FigureColor.WHITE) {//если сейчас ход белых
                    //то ставим в таблице на место хода черных пробел, чтобы там было "пусто"
                    ((RecordMove) tableView.getItems().get(number_move - 1)).setBlack_move(" ");
                    record_move = tableView.getItems().get(number_move - 1).getWhite_move();//для взятия на проходе записываем в record_move последний ход соперника
                } else {//иначе
                    //уменьшаем счетчик ходов на 1 и удаляем из таблицы целиком последний элемент
                    //--number_move;
                    if (--number_move != 0)
                        record_move = tableView.getItems().get(number_move - 1).getBlack_move();//для взятия на проходе записываем в record_move последний ход соперника
                    record.remove(number_move);
                }

                tableView.refresh();
            }//перерисовываем таблицу, чтобы изменения вступили в силу
            flag_move = ViceVersa(flag_move);//меняем значение flag_move на противоложный
            arrayCancelMove.DeleteArrayCancel();//удаляем последний элемент из списка
        }
    }

    public static boolean isExist(int letter, int number) {
        //проверка на принадлежность координат доске
        return (letter >= 1 && letter <= 8) && (number >= 1 && number <= 8);
    }

    public static Cell isCellEnd() {
        return cellforpawn;//вернуть значение клетки конца хода
    }

    public static String Capture() {
        return record_move;//вернуть запись последнего хода
    }

    public static void ForCapture(Cell cell)//функция удаления пешки, которую убили взятием на проходе
    {
        if(cell.figure.getName().compareTo("E") != 0) {
            cell.figure = new EmptyFigure("E");
            cell.isOccupied = false;
            FindImageView(cell).setImage(empty_figure);
        }
    }

    public static FigureColor isFlag_move(){
        return flag_move;//вернуть флаг очереди хода
    }

    private void Print() {
        for (int i = 8; i >= 1; i--) {
            for (int j = 1; j <= 8; j++) {
                //System.out.print(FindCell(j, i).figure.getName() + FindCell(j, i).name() + " ");
                System.out.print(FindCell(j, i).isOccupied + " ");
            }
            System.out.println();
        }
    }




   /*public Double[] reverse(Double[] array)//переворот массива, чтобы использовать при игре с компьютером
    {
        Double temp;
       for (int i = 0; i < array.length; i++)
       {
           temp = array[i];
           array[i] = array[array.length - i - 1];
           array[array.length - i - 1] = temp;
       }
       return array;
    }*/

    /*
    void playMashine()
    {
        var minimaxRoot =function(depth, game, isMaximisingPlayer) {

        var newGameMoves = game.ugly_moves();
        var bestMove = -9999;
        var bestMoveFound;

        for(var i = 0; i < newGameMoves.length; i++) {
            var newGameMove = newGameMoves[i]
            game.ugly_move(newGameMove);
            var value = minimax(depth - 1, game, -10000, 10000, !isMaximisingPlayer);
            game.undo();
            if(value >= bestMove) {
                bestMove = value;
                bestMoveFound = newGameMove;
            }
        }
        return bestMoveFound;
    };

        var minimax = function (depth, game, alpha, beta, isMaximisingPlayer) {
        positionCount++;
        if (depth === 0) {
            return -evaluateBoard(game.board());
        }

        var newGameMoves = game.ugly_moves();

        if (isMaximisingPlayer) {
            var bestMove = -9999;
            for (var i = 0; i < newGameMoves.length; i++) {
                game.ugly_move(newGameMoves[i]);
                bestMove = Math.max(bestMove, minimax(depth - 1, game, alpha, beta, !isMaximisingPlayer));
                game.undo();
                alpha = Math.max(alpha, bestMove);
                if (beta <= alpha) {
                    return bestMove;
                }
            }
            return bestMove;
        } else {
            var bestMove = 9999;
            for (var i = 0; i < newGameMoves.length; i++) {
                game.ugly_move(newGameMoves[i]);
                bestMove = Math.min(bestMove, minimax(depth - 1, game, alpha, beta, !isMaximisingPlayer));
                game.undo();
                beta = Math.min(beta, bestMove);
                if (beta <= alpha) {
                    return bestMove;
                }
            }
            return bestMove;
        }
    };

        var absoluteValue = getAbsoluteValue(piece, piece.color === 'w', x ,y);
        return piece.color === 'w' ? absoluteValue : -absoluteValue;
    };
    }
    */

}