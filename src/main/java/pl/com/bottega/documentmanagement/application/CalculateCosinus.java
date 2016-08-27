package pl.com.bottega.documentmanagement.application;

import java.util.Scanner;

/**
 * Created by arkadiuszarak on 23/08/2016.
 */
public class CalculateCosinus implements Command {
    @Override
    public void execute() {
        System.out.println("Calcuate cosinus");
        String degrees = new Scanner(System.in).nextLine();
        double value = Double.parseDouble(degrees);
        double radians = Math.toRadians(value);
        System.out.format("The sine of %.1f degrees is %.2f%n", value, Math.cos(radians));
    }
}
