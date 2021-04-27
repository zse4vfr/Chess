package chess.squares;

import chess.figures.EmptyFigure;
import chess.figures.ForAllFigures;

public enum Cell {
        //a = 1; b = 2; c = 3; d = 4; e = 5; f = 6; g = 7; h = 8.
        a1(1, 1, new EmptyFigure("E"), false),
        b1(2, 1, new EmptyFigure("E"), false),
        c1(3, 1, new EmptyFigure("E"), false),
        d1(4, 1, new EmptyFigure("E"), false),
        e1(5, 1, new EmptyFigure("E"), false),
        f1(6, 1, new EmptyFigure("E"), false),
        g1(7, 1, new EmptyFigure("E"), false),
        h1(8, 1, new EmptyFigure("E"), false),
        a2(1, 2, new EmptyFigure("E"), false),
        b2(2, 2, new EmptyFigure("E"), false),
        c2(3, 2, new EmptyFigure("E"), false),
        d2(4, 2, new EmptyFigure("E"), false),
        e2(5, 2, new EmptyFigure("E"), false),
        f2(6, 2, new EmptyFigure("E"), false),
        g2(7, 2, new EmptyFigure("E"), false),
        h2(8, 2, new EmptyFigure("E"), false),
        a3(1, 3, new EmptyFigure("E"), false),
        b3(2, 3, new EmptyFigure("E"), false),
        c3(3, 3, new EmptyFigure("E"), false),
        d3(4, 3, new EmptyFigure("E"), false),
        e3(5, 3, new EmptyFigure("E"), false),
        f3(6, 3, new EmptyFigure("E"), false),
        g3(7, 3, new EmptyFigure("E"), false),
        h3(8, 3, new EmptyFigure("E"), false),
        a4(1, 4, new EmptyFigure("E"), false),
        b4(2, 4, new EmptyFigure("E"), false),
        c4(3, 4, new EmptyFigure("E"), false),
        d4(4, 4, new EmptyFigure("E"), false),
        e4(5, 4, new EmptyFigure("E"), false),
        f4(6, 4, new EmptyFigure("E"), false),
        g4(7, 4, new EmptyFigure("E"), false),
        h4(8, 4, new EmptyFigure("E"), false),
        a5(1, 5, new EmptyFigure("E"), false),
        b5(2, 5, new EmptyFigure("E"), false),
        c5(3, 5, new EmptyFigure("E"), false),
        d5(4, 5, new EmptyFigure("E"), false),
        e5(5, 5, new EmptyFigure("E"), false),
        f5(6, 5, new EmptyFigure("E"), false),
        g5(7, 5, new EmptyFigure("E"), false),
        h5(8, 5, new EmptyFigure("E"), false),
        a6(1, 6, new EmptyFigure("E"), false),
        b6(2, 6, new EmptyFigure("E"), false),
        c6(3, 6, new EmptyFigure("E"), false),
        d6(4, 6, new EmptyFigure("E"), false),
        e6(5, 6, new EmptyFigure("E"), false),
        f6(6, 6, new EmptyFigure("E"), false),
        g6(7, 6, new EmptyFigure("E"), false),
        h6(8, 6, new EmptyFigure("E"), false),
        a7(1, 7, new EmptyFigure("E"), false),
        b7(2, 7, new EmptyFigure("E"), false),
        c7(3, 7, new EmptyFigure("E"), false),
        d7(4, 7, new EmptyFigure("E"), false),
        e7(5, 7, new EmptyFigure("E"), false),
        f7(6, 7, new EmptyFigure("E"), false),
        g7(7, 7, new EmptyFigure("E"), false),
        h7(8, 7, new EmptyFigure("E"), false),
        a8(1, 8, new EmptyFigure("E"), false),
        b8(2, 8, new EmptyFigure("E"), false),
        c8(3, 8, new EmptyFigure("E"), false),
        d8(4, 8, new EmptyFigure("E"), false),
        e8(5, 8, new EmptyFigure("E"), false),
        f8(6, 8, new EmptyFigure("E"), false),
        g8(7, 8, new EmptyFigure("E"), false),
        h8(8, 8, new EmptyFigure("E"), false);

        public final int letter;
        public final int number;
        public boolean isOccupied;
        public ForAllFigures figure;

        Cell(int letter, int number, ForAllFigures figure, boolean isOccupied) {
            this.letter = letter;
            this.number = number;
            this.figure = figure;
            this.isOccupied = isOccupied;
        }
}
