package pl.com.bottega.documentmanagement.application;

import java.util.Scanner;

/**
 * Created by arkadiuszarak on 23/08/2016.
 */
public class CalculateSquared implements Command {
    @Override
    public void execute() {

        System.out.println("Calculate square");
        String number = new Scanner(System.in).nextLine();
        double value = Double.parseDouble(number);

        System.out.format("The square of %.1f is %.1f", value, Math.pow(value, 2));
        System.out.println();
    }
}
