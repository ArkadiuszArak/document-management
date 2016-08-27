package pl.com.bottega.documentmanagement.application;

/**
 * Created by arkadiuszarak on 23/08/2016.
 */
public class MathematicsCommandFactory implements CommandFactory {
    @Override
    public Command createCommand(String command) {
        if (command.equals("1"))
            return new QuadraticEquation();
        else if (command.equals("2"))
            return new CalculateSinus();
        else if (command.equals("3"))
            return new CalculateCosinus();
        else if (command.equals("4"))
            return new CalculateSquared();
        return new UnknownCommand();
    }
}
