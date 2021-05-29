package chess.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ChessBoard {

    @FXML
    private Button button_menu;
    @FXML
    private Button button_rules;
    @FXML
    private Label text;


    @FXML
    void initialize() {
        button_menu.setSkin(new MyButtonSkin(button_menu, 0.5));
        button_rules.setSkin(new MyButtonSkin(button_rules, 0.5));
        text.setText("  Черные и белые поля чередуются и, казалось бы, доска симметрична можно как угодно ее повернуть, ничего не изменится. Но это не так. Прежде чем начинать игру убедитесь, что ближнее к вам левое угловое поле черного цвета. \n" +"\n" +
                "   У каждого поля шахматной доски есть свое собственное имя — координаты. Для этого используют латинские буквы a, b, c, d, e, f, g, h и цифры от 1 до 8. \n" +
                "\n" +
                "   Ряды из 8 полей, находящиеся напротив каждой из цифр, называются горизонталями, а столбцы из 8 полей, находящиеся напротив каждой из букв, называются вертикалями. Соответственно горизонтали и вертикали и обозначаются своей цифрой или буквой. К примеру, поле находящееся одновременно на вертикали f и на горизонтали 4 имеет имя — поле f4. Поля шахматной доски одного цвета, находящиеся на одной линии называются диагоналями.\n");

    }


}
