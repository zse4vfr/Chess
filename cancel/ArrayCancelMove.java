package chess.cancel;

import java.util.ArrayList;

public class ArrayCancelMove {//этот класс - список из объектов типа CancelMove, чтобы можно было удалить все ходы до начала партии
    private ArrayList<CancelMove> array_cancel;
    private int size;

    public ArrayCancelMove() {
        this.size = 0;
        this.array_cancel = new ArrayList<CancelMove>();
    }

    public int getSize() {
        return size;
    }

    public CancelMove getCancelMove(int index) {
        return array_cancel.get(index);
    }

    public void AddArrayCancel(CancelMove cancelMove) {
        array_cancel.add(size, cancelMove);
        size++;
    }

    public void DeleteArrayCancel() {
        if (size-- != 0)
            array_cancel.remove(size);
    }
}
