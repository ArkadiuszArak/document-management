package pl.com.bottega.mars;

/**
 * Created by arkadiuszarak on 28/08/2016.
 */
public abstract class MarsRoverState {
    protected MarsRover marsRover; //tu wie czyim jest stanem

    public MarsRoverState(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    public abstract void move();
    public abstract void rotateRight();
    public abstract void rotateLeft();
    public abstract String direction();
}
