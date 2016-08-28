package pl.com.bottega.mars;

/**
 * Created by arkadiuszarak on 28/08/2016.
 */
public class Position {

    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("(%d , %d)", x, y);
    }
}
