package chess.record;

import java.util.ArrayList;

public class ArrayRecordMove {//этот класс - список объектов типа RecordMove, чтобы можно было записывать всю партию
    private ArrayList<RecordMove> recordMoves;
    int size = 0;

    public ArrayRecordMove() {
        this.recordMoves = new ArrayList<RecordMove>();
    }

    public void setRecordMoves(ArrayList<RecordMove> recordMoves) {
        this.recordMoves = recordMoves;
    }

    public ArrayList<RecordMove> getRecordMoves() {
        return recordMoves;
    }

    public int getSize() {
        return size;
    }

    public void setRecordMove(int index, RecordMove recordMove) {
            recordMoves.set(index, recordMove);
    }

    public RecordMove getRecordMove(int index) {
       return recordMoves.get(index);
    }

    public void AddRecordMove(RecordMove recordMove) {
        recordMoves.add(size, recordMove);
        size++;
    }

    public void DeleteRecordMove() {
        if (size-- != 0)
            recordMoves.remove(size);
    }
}
