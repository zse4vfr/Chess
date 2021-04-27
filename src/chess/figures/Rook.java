package chess.figures;

import chess.squares.Cell;
import java.util.ArrayList;

import static chess.controllers.Game.*;

public class Rook implements ForAllFigures{
    private final String name;
    private final FigureColor figureColor;
    private ArrayList<Cell> possibleMoves;
    private int number;
    private int letter;
    private int size;
    private boolean firstMove;

    public Rook(String name, FigureColor figureColor) {
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
        possibleMoves = new ArrayList<Cell>();
        size = 0;

        RestoreCoordinates(begin);

        while(isExist(letter, ++number) && CheckCell(letter, number));

        RestoreCoordinates(begin);

        while(isExist(letter, --number) && CheckCell(letter, number));

        RestoreCoordinates(begin);

        while(isExist(++letter, number) && CheckCell(letter, number));

        RestoreCoordinates(begin);

        while(isExist(--letter, number) && CheckCell(letter, number));

        return possibleMoves;
    }

    public boolean CheckCell(int letter, int number)
    {
        //если клетка с координатами letter и number занята
        if(FindCell(letter, number).isOccupied) {
            //если в этой клетке фигура противоположного цвета и это не король
            if(this.getFigureColor() != FindCell(letter, number).figure.getFigureColor())//&& FindCell(letter, number).figure.getName().compareTo("K") != 0)
                possibleMoves.add(size++, FindCell(letter, number));//добавляем в список клетку
            return false;//если фигура того же цвета возвращаем false чтобы выйти из цикла
        }
        possibleMoves.add(size++, FindCell(letter, number));//добавляем в список клетку
        return true;//возвращаем true чтобы остаться в цикле
    }

    public void RestoreCoordinates(Cell cell)
    {
        number = cell.number;
        letter = cell.letter;
    }
}
