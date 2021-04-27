package chess.figures;

import chess.squares.Cell;
import java.util.ArrayList;

public class Queen implements ForAllFigures {
    private final String name;
    private final FigureColor figureColor;
    private ArrayList<Cell> possibleMoves;
    private int number;
    private int letter;
    private int size;

    public Queen(String name, FigureColor figureColor) {
        this.name = name;
        this.figureColor = figureColor;
    }

    @Override
    public boolean isfirstMove() {
        return false;
    }

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
    public ArrayList<Cell> PossibleMoves(Cell begin) {
        possibleMoves = new ArrayList<Cell>();
        size = 0;

        Bishop bishop = new Bishop("B", this.figureColor);
        Rook rook = new Rook("R", this.figureColor);
        possibleMoves = bishop.PossibleMoves(begin);
        size = possibleMoves.size();
        for (Cell cell : rook.PossibleMoves(begin))
            possibleMoves.add(size++, cell);

        return possibleMoves;
    }
}