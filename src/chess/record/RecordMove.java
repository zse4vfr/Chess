package chess.record;

public class RecordMove {//этот класс - запись одного хода
    private int number_move;
    private String white_move = " ";
    private String black_move = " ";


    public int getNumber_move() {
        return number_move;
    }

    public String getWhite_move() {
        return white_move;
    }

    public String getBlack_move() {
        return black_move;
    }

    public void setWhite_move(String white_move) {
        this.white_move = white_move;
    }

    public void setNumber_move(int number_move) {
        this.number_move = number_move;
    }

    public void setBlack_move(String black_move) {
        this.black_move = black_move;
    }
}