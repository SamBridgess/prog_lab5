package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CommandsManager;

/**
 * help command
 */
public class HelpCommand extends Command {
    private final int numberOfArguments = 0;
    private IOManager io;
    public HelpCommand(IOManager io) {
        this.io = io;
    }
    @Override
    public int getNumberOfArguments() {
        return numberOfArguments;
    }
    @Override
    public void execute(String[] args) {
        CommandsManager.printCommandsHelp(io);
    }
}
