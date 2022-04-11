package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;

/**
 * exit command
 */
public class ExitCommand extends Command {
    private IOManager io;

    public ExitCommand(IOManager io) {
        super(0);
        this.io = io;
    }
    @Override
    public void execute(String[] args) {
        io.printConfirmation("Exiting...");
        io.setContinueExecutionFlag(false);
    }
}
