package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;

/**
 * exit command
 */
public class ExitCommand extends Command {
    public ExitCommand(IOManager io) {
        super(0, io);
    }
    @Override
    public void execute(String[] args) {
        getIOManager().printConfirmation("Exiting...");
        getIOManager().setContinueExecutionFlag(false);
    }
}
