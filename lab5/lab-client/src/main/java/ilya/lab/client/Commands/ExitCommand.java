package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;

/**
 * exit command
 */
public class ExitCommand extends Command {
    private final int numberOfArguments = 0;
    private IOManager io;

    public ExitCommand(IOManager io) {
        this.io = io;
    }
    @Override
    public int getNumberOfArguments() {
        return numberOfArguments;
    }
    @Override
    public void execute(String[] args) {
        io.printConfirmation("Exiting...");
        io.setContinueExecutionFlag(false);
    }
}
