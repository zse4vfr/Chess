package chess.figures;

import chess.squares.Cell;
import static chess.controllers.Game.*;

import java.util.ArrayList;

public class Knight implements ForAllFigures{
    private final String name;
    private final FigureColor figureColor;
    private int size;

    public Knight(String name, FigureColor figureColor) {
        this.name = name;
        this.figureColor = figureColor;
    }

    @Override
    public boolean isfirstMove() {return false; }

    @Override
    public void setfirstMove(boolean firstMove) {}

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

        for(int i = begin.letter - 2; i <= begin.letter + 2; i += 4)
        {
            for(int j = begin.number - 1; j <= begin.number + 1; j += 2)
            {
                if(isExist(i, j))//если клетка с координатами i и j существует
                {
                    //если клетка с координатами i и j не занята или если в этой клетке стоит фигура противоположного цвета //и это не король
                    if(!FindCell(i, j).isOccupied || this.figureColor != FindCell(i, j).figure.getFigureColor()) //&& FindCell(i, j).figure.getName().compareTo("K") != 0))
                        possibleMoves.add(size++, FindCell(i, j));//добавляем в список клетку
                }
            }
        }

        for(int i = begin.letter - 1; i <= begin.letter + 1; i += 2)
        {
            for(int j = begin.number - 2; j <= begin.number + 2; j += 4)
            {
                if(isExist(i, j))//если клетка с координатами i и j существует
                {
                    //если клетка с координатами i и j не занята или если в этой клетке стоит фигура противоположного цвета //и это не король
                    if(!FindCell(i, j).isOccupied || this.figureColor != FindCell(i, j).figure.getFigureColor()) //&& FindCell(i, j).figure.getName().compareTo("K") != 0))
                        possibleMoves.add(size++, FindCell(i, j));//добавляем в список клетку
                }
            }
        }

        return possibleMoves;
    }
}