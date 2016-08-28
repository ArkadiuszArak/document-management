package pl.com.bottega.mars;

/**
 * Created by arkadiuszarak on 28/08/2016.
 */
public class MarsRover {

    private Postition position;
    private MarsRoverState currentState;

    public MarsRover() {
        this.position = new Postition(0, 0);
        this.currentState = new NorthState(this);
    }

    public void move() {
        currentState.move();
    }

    public void rotateRight() {
        currentState.rotateRight();
    }

    public void rotateLeft() {
        currentState.rotateLeft();
    }

    public Postition position() {
        return position;
    }

    public void setPosition(Postition position){
        this.position = position;
    }

    public void setState(MarsRoverState state){
        this.currentState = state;
    }

    public void getDirection(){
        currentState.direction();
    }

}
