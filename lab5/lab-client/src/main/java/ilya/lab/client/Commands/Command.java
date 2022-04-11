package ilya.lab.client.Commands;

import ilya.lab.client.Exceptions.CtrlDException;
import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;

import java.io.IOException;
/**
 * parent of all commands
 */
public abstract class Command {
    private final int numberOfArguments;
    private IOManager io;
    public Command(int numberOfArguments, IOManager io) {
        this.numberOfArguments = numberOfArguments;
        this.io = io;
    }
    public int getNumberOfArguments() {
        return numberOfArguments;
    };
    public IOManager getIOManager() {
        return io;
    }
    public abstract void execute(String[] args) throws IOException, WrongFileFormatException, CtrlDException;
}
