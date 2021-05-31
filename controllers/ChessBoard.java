package chess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessBoard {
    static boolean flag_board;
    static boolean flag_figures;
    static boolean flag_other_rules;

    Image chess_board = new Image("chess/images/Rules/ChessBoard.png");
    Image chess_figures = new Image("chess/images/Rules/chess_rules.png");
    Image chess_other_rules = new Image("chess/images/Rules/question_mark_1.png");

    @FXML
    private Button button_menu;
    @FXML
    private Button button_rules;
    @FXML
    private Label label_text;
    @FXML
    private Text text;
    @FXML
    private ImageView image_view;

    @FXML
    void initialize() {
        button_menu.setSkin(new MyButtonSkin(button_menu, 0.5));
        button_rules.setSkin(new MyButtonSkin(button_rules, 0.5));
        if(flag_board) {
            image_view.setImage(chess_board);
            text.setText("Шахматная доска");
            label_text.setText("  Черные и белые поля чередуются и, казалось бы, доска симметрична можно как угодно ее повернуть, ничего не изменится. Но это не так. Прежде чем начинать игру убедитесь, что ближнее к вам левое угловое поле черного цвета.\n" + "\n" +
                    "   У каждого поля шахматной доски есть свое собственное имя — координаты. Для этого используют латинские буквы a, b, c, d, e, f, g, h и цифры от 1 до 8. \n" +
                    "\n" +
                    "   Ряды из 8 полей, находящиеся напротив каждой из цифр, называются горизонталями, а столбцы из 8 полей, находящиеся напротив каждой из букв, называются вертикалями. Соответственно горизонтали и вертикали и обозначаются своей цифрой или буквой. К примеру, поле находящееся одновременно на вертикали f и на горизонтали 4 имеет имя — поле f4. Поля шахматной доски одного цвета, находящиеся на одной линии называются диагоналями.\n");
        }else if(flag_figures) {
            image_view.setImage(chess_figures);
            text.setText("Шахматные фигуры");
            label_text.setText("  Обычно шахматные фигуры представляют собой классы средневекового общества. 8 пешек символизируют рабочих или солдат. Могут ходить только прямо, по одной клетке за ход. Однако, если пешка ходит в первый раз, то может сходить сразу на две клетки. Кроме того, пешка может атаковать соперника только по диагонали перед собой. Когда пешка достигает противоположной стороны доски, она может быть заменена на любую другую фигуру, кроме короля и пешки. Также у пешки есть спецефическое взятие на проходе, согласно которому, пешка сделавшая первый ход, может быть взята пешкой соперника расположенной на 5-ой горизонтали(для черных аналогично пешка может быть взята фигурой противника, расположенной на 4-ой горизонтали).\n" +
                    "   Что касается коня, то большинство людей наверно слышали фразу 'Конь ходит буквой г', так вот, это правда. Ход коня - передвижение сначала в одну из 4 сторон(вверх, вниз, влево или вправо) на 2 клетки, а затем перемещение в любую, перпендикулярную первой, сторону на 1 клекту.\n" +
                    "   Слон может ходить через любое количество клеток в диагональном направлении своего цвета, но он не может перепрыгивать фигуры, как конь.\n" +
                    "   Ладья аналогично слону может ходить через любое количество клеток, но только в вертикальном и горизонтальном направлениях. Также не может перепрыгивать через фигуры.\n" +
                    "   Ферзь объединяет в себе две фигуры - ладью и слона. Он может ходить в любом направлении(вверх, влево, вправо, вниз, по любой диагонали) на любое количество клеток, но также не умеет перепрыгивать через фигуры.\n" +
                    "   Король может ходить в любом направлении, но только на одну клетку от себя. Также у короля есть спецефический ход - рокировка. Рокировка возможна только если ни король ни ладья не делали ходов, а также если на пути короля нет битых полей.");
        }else if(flag_other_rules) {
            image_view.setImage(chess_other_rules);
            text.setText("Другие правила");
            label_text.setText("   Шахматы - это сражение между двумя игроками, выражаемое в поочередных ходах шахматными фигурами, белыми и черными. Шахматные фигуры могут перемещаться как на пустые клетки, так и на клетки, занятые фигурами противника. Атакованная фигура противника снимается с доски. Главная цель иггры - объявить мат королю противника, но этому должно предшествовать осторожное маневрирование шахматными фигурами, позволяющее колнтролировать пространство на доске и собрать силы для финальной атаки.\n" +
                    "   Короля необходимо защищать, но он может быть и мощной атакующей единицей, например в конце игры. Когда король подвергается прямой атаке шахматной фигурой противника, ему объявляется шах. В такой ситуации у игрока есть выбор: убрать короля из-под шаха, то есть переместиться на клетку, где король не будет атакован; убить шахматную фигуру, которая атакует своего короля; своя фигура может встать на пути атаки и закрыть короля собой. " +
                    "Если поставлен шах, от которого нельзя защититься ни одним из способов, говорят, что королю объявлен мат и игра заканчивается.");
        }
        button_menu.setOnAction(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader(ChessBoard.class.getResource("/chess/fxmls/MainMenu.fxml"));
            Open(fxmlLoader);
        });

        button_rules.setOnAction(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader(ChessBoard.class.getResource("/chess/fxmls/Rules.fxml"));
            Open(fxmlLoader);
        });
    }

    public static void setFlags(boolean flag1, boolean flag2, boolean flag3)
    {
        flag_board = flag1;
        flag_figures = flag2;
        flag_other_rules = flag3;
    }

    void Open(FXMLLoader fxmlLoader) {
        CloseWindow();
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (
                IOException var4) {
            var4.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 1440, 800));
        stage.setResizable(false);
        stage.getIcons().add(new Image("chess/images/black_figures/black_knight.png"));
        stage.setOnCloseRequest(event1 ->{
            stage.close();
        });
        stage.show();
    }

    void CloseWindow() {
        ((Stage) button_menu.getScene().getWindow()).close();
    }
}
