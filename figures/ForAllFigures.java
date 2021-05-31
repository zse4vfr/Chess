package chess.figures;

import chess.squares.Cell;
import java.util.ArrayList;

public interface ForAllFigures {
    boolean isfirstMove();//первые две метода нужны для короля и ладьи - они для рокировки
    void setfirstMove(boolean firstMove);
    String getName();//остальные методы нужны для всех фигур
    FigureColor getFigureColor();
    ArrayList<Cell> PossibleMoves(Cell begin);
}
