package chess.figures;

import chess.squares.Cell;
import java.util.ArrayList;

import static chess.controllers.Game.*;


public class Pawn implements ForAllFigures {
    private final String name;
    private final FigureColor figureColor;
    private ArrayList<Cell> possibleMoves;
    private int size;

    public Pawn(String name, FigureColor figureColor) {
        this.name = name;
        this.figureColor = figureColor;
    }

    @Override
    public boolean isfirstMove() {
        return false;
    }

    @Override
    public void setfirstMove(boolean firstMove) {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public FigureColor getFigureColor() {
        return figureColor;
    }

    @Override
    public ArrayList<Cell> PossibleMoves(Cell begin) {
        possibleMoves = new ArrayList<Cell>();
        size = 0;
        String last_move_left;
        String last_move_right;

        if (this.getFigureColor() == FigureColor.WHITE) {//если пешка белая
            if(!FindCell(begin.letter, begin.number + 1).isOccupied) {//если клетка перед пешкой не занята
                possibleMoves.add(size++, FindCell(begin.letter, begin.number + 1));//добавляем в список эту клетку
                if(begin.number == 2) {//если белая пешка стоит в начальной позиции
                    if (!FindCell(begin.letter, begin.number + 2).isOccupied)//если клетка через одну не занята
                        possibleMoves.add(size++, FindCell(begin.letter, begin.number + 2));//добавляем в список эту клетку
                }
            }
            if(begin.number == 5) {
                last_move_left = Letter(begin.letter - 1) + "7-" + Letter(begin.letter - 1) + "5";//делаем запись вида d7 - d5 буквой левее
                last_move_right = Letter(begin.letter + 1) + "7-" + Letter(begin.letter + 1) + "5";//делаем запись вида d7 - d5 буквой правее
                if (Capture().compareTo(last_move_left) == 0) {
                    if (isExist(begin.letter - 1, 6)) {//если существует такая клетка буквой левее
                        possibleMoves.add(size++, FindCell(begin.letter - 1, 6));//добавляем в массив
                        if (FindCell(begin.letter - 1, 6) == isCellEnd())//если клетка куда хочет сходить пользователь равна клетке взятия на проходе
                            ForCapture(FindCell(begin.letter - 1, 5));//делаем вместо черной пешки на клетке где она стоит пустоту
                    }
                } else if (Capture().compareTo(last_move_right) == 0) {//аналогично для буквы правее
                    if (isExist(begin.letter + 1, 6)) {
                        possibleMoves.add(size++, FindCell(begin.letter + 1, 6));
                        if (FindCell(begin.letter + 1, 6) == isCellEnd())
                            ForCapture(FindCell(begin.letter + 1, 5));
                    }
                }
            }
            if(isExist(begin.letter + 1, begin.number + 1))//если существует клетка справа по диагонали от пешки
                CheckCell(begin.letter + 1, begin.number + 1);//вызываем функцию
            if(isExist(begin.letter - 1, begin.number + 1))//если существует клетка слева по диагонали от пешки
                CheckCell(begin.letter - 1, begin.number + 1);//вызываем функцию

        } else {
            if(!FindCell(begin.letter, begin.number - 1).isOccupied) {//если клетка перед пешкой не занята
                possibleMoves.add(size++, FindCell(begin.letter, begin.number - 1));//добавляем в список эту клетку
                if (begin.number == 7) {//если белая пешка стоит в начальной позиции
                    if (!FindCell(begin.letter, begin.number - 2).isOccupied)//если клетка через одну не занята
                        possibleMoves.add(size++, FindCell(begin.letter, begin.number - 2));//добавляем в список эту клетку
                }
            }
            if (begin.number == 4) {//аналогично для пешки черного цвета
                last_move_left = Letter(begin.letter - 1) + "2-" + Letter(begin.letter - 1) + "4";
                last_move_right = Letter(begin.letter + 1) + "2-" + Letter(begin.letter + 1) + "4";
                if (Capture().compareTo(last_move_left) == 0) {
                    if (isExist(begin.letter - 1, 3)) {
                        possibleMoves.add(size++, FindCell(begin.letter - 1, 3));
                        if (FindCell(begin.letter - 1, 3) == isCellEnd())
                            ForCapture(FindCell(begin.letter - 1, 4));
                    }
                } else if (Capture().compareTo(last_move_right) == 0) {
                    if (isExist(begin.letter + 1, 3)) {
                        possibleMoves.add(size++, FindCell(begin.letter + 1, 3));
                        if (FindCell(begin.letter + 1, 3) == isCellEnd())
                            ForCapture(FindCell(begin.letter + 1, 4));
                    }
                }
            }
            if(isExist(begin.letter + 1, begin.number - 1))//если существует клетка справа по диагонали от пешки
                CheckCell(begin.letter + 1, begin.number - 1);//вызываем функцию
            if(isExist(begin.letter - 1, begin.number - 1))//если существует клетка слева по диагонали от пешки
                CheckCell(begin.letter - 1, begin.number - 1);//вызываем функцию
        }

        return possibleMoves;
    }

    public void CheckCell(int letter, int number) {
        //если в клетке с координатами letter и number фигура противоположного цвета //и это не король
        if (FindCell(letter, number).isOccupied && this.getFigureColor() != FindCell(letter, number).figure.getFigureColor())// && FindCell(letter, number).figure.getName().compareTo("K") != 0)
            possibleMoves.add(size++, FindCell(letter, number));//добавляем в список клетку
    }
}