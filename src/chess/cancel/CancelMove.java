package chess.cancel;

import chess.figures.ForAllFigures;
import chess.squares.Cell;

import java.util.ArrayList;

public class CancelMove {//этот класс описывает каждые полхода
    private ArrayList<Cell> array_cell = new ArrayList<Cell>();
    private ForAllFigures figure_begin;
    private ForAllFigures figure_end;

    public CancelMove(Cell begin, Cell end) {
        //первый элемент списка клетка начала, второй клетка конца
        this.array_cell.add(0, begin);
        this.array_cell.add(1, end);
        this.figure_begin = begin.figure;
        this.figure_end = end.figure;
    }

    public ForAllFigures getFigure_begin() {
        return this.figure_begin;
    }

    public ForAllFigures getFigure_end() {
        return this.figure_end;
    }

    public ArrayList<Cell> getArray_Cell() {
        return this.array_cell;
    }
}
