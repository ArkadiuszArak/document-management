package pl.com.bottega.mars;

import java.util.Scanner;

/**
 * Created by arkadiuszarak on 28/08/2016.
 */
public class MarsRoverApp {
    public static void main(String[] args) {
        MarsRover marsRover = new MarsRover();

        while (true){
            System.out.print("Enter command: (m, rl, rr)");

            String command = new Scanner(System.in).nextLine();

            if (command.equals("m")){
                marsRover.move();
                System.out.println(marsRover.position().toString());
            } else if(command.equals("rl")){
                marsRover.rotateLeft();
                System.out.println(marsRover.position().toString());
            } else if (command.equals("rr")){
                marsRover.rotateRight();
                System.out.println(marsRover.position().toString());
            }
        }
    }
}
