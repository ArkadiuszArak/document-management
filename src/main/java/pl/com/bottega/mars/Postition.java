package pl.com.bottega.mars;

/**
 * Created by arkadiuszarak on 28/08/2016.
 */
public class Postition {
    private int x, y;

    public Postition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Postition{" +
                "x= " + x +
                ", y= " + y +
                '}';
    }
}
