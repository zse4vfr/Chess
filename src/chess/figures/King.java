package chess.figures;

import chess.squares.Cell;
import java.util.ArrayList;

import static chess.controllers.Game.*;

public class King implements ForAllFigures{
    private final String name;
    private final FigureColor figureColor;
    private int size;
    private boolean firstMove;

    public King(String name, FigureColor figureColor) {
        this.name = name;
        this.figureColor = figureColor;
        this.firstMove = true;
    }

    public boolean isfirstMove()
    {
        return firstMove;
    }

    public void setfirstMove(boolean firstMove)
    {
        this.firstMove = !firstMove;
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
    public ArrayList<Cell> PossibleMoves(Cell begin)
    {
        ArrayList<Cell> possibleMoves = new ArrayList<Cell>();
        size = 0;

        for(int i = begin.letter - 1; i <= begin.letter + 1; i++)
        {
            for(int j = begin.number - 1; j <= begin.number + 1; j++)
            {
                if(isExist(i, j))//если клетка с координатами i и j существует
                {
                    //если клетка с координатами i и j не занята или если в этой клетке стоит фигура противоположного цвета //и это не король
                    if(!FindCell(i, j).isOccupied || this.figureColor != FindCell(i, j).figure.getFigureColor())// && FindCell(i, j).figure.getName().compareTo("K") != 0))
                        possibleMoves.add(size++, FindCell(i, j));//добавляем в список клетку
                }
            }
        }

        if(this.isfirstMove() && this.figureColor == isFlag_move()) {//если король ходит первый раз и сейчас его ход
            if(this.figureColor == FigureColor.WHITE) {//если цвет белый
                if(!Cell.f1.isOccupied && !Cell.g1.isOccupied && Cell.h1.figure.isfirstMove()) {//если не заняты клетки для рокировки
                    if(!AttackToKing(this.figureColor, 1))//если эти клетки не битые
                        possibleMoves.add(size++, Cell.g1);//добавляем клетку
                }
                if(!Cell.b1.isOccupied && !Cell.c1.isOccupied && !Cell.d1.isOccupied && Cell.a1.figure.isfirstMove())//аналогично в другую сторону
                {
                    if(!AttackToKing(this.figureColor, 2))
                        possibleMoves.add(size++, Cell.c1);
                }
            }
            else {//аналогично для другого цвета
                if(!Cell.f8.isOccupied && !Cell.g8.isOccupied && Cell.h8.figure.isfirstMove()) {
                    if(!AttackToKing(this.figureColor, -1))
                        possibleMoves.add(size++, Cell.g8);
                }
                if(!Cell.b8.isOccupied && !Cell.c8.isOccupied && !Cell.d8.isOccupied && Cell.a8.figure.isfirstMove())
                {
                    if(!AttackToKing(this.figureColor, -2))
                        possibleMoves.add(size++, Cell.c8);
                }
            }
        }

        return possibleMoves;
    }
}
