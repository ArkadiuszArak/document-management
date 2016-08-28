package pl.com.bottega.mars;

/**
 * Created by arkadiuszarak on 28/08/2016.
 */
public class EastState extends MarsRoverState {
    public EastState(MarsRover marsRover) {
        super(marsRover);
    }

    @Override
    public void move() {
        Postition postition = marsRover.position();
        marsRover.setPosition(new Postition(postition.x() - 1 , postition.y()));
    }

    @Override
    public void rotateRight() {
        marsRover.setState(new NorthWestState(marsRover));
    }

    @Override
    public void rotateLeft() {
        marsRover.setState(new NorthEastState(marsRover));
    }

    @Override
    public String direction() {
        return null;
    }
}
