package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;

import java.io.IOException;

/**
 * exit command
 */
public class ExitCommand extends Command {
    public ExitCommand(IOManager io) {
        super(0, io);
    }

    /**
     * executes command with arguments
     *
     * @param args      arguments
     * @throws IOException
     */
    @Override
    public void execute(String[] args) throws IOException {
        getIOManager().close();
        getIOManager().printConfirmation("Exiting...");

        System.exit(0);
        getIOManager().setContinueExecutionFlag(false);
    }
}

