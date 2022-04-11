package ilya.lab.client.Commands;

import ilya.lab.client.Exceptions.CtrlDException;
import ilya.lab.client.Exceptions.WrongFileFormatException;

import java.io.IOException;
/**
 * parent of all commands
 */
public abstract class Command {
    private final int numberOfArguments;
    public Command(int numberOfArguments) {
        this.numberOfArguments = numberOfArguments;
    }
    public int getNumberOfArguments() {
        return numberOfArguments;
    };
    public abstract void execute(String[] args) throws IOException, WrongFileFormatException, CtrlDException;
}
