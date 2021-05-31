package chess.figures;

import chess.squares.Cell;
import java.util.ArrayList;

public class EmptyFigure implements ForAllFigures{
    private String name;

    public EmptyFigure(String name)
    {
        this.name = name;
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
        return null;
    }

    @Override
    public ArrayList<Cell> PossibleMoves(Cell begin)
    {
        return null;
    }
}
