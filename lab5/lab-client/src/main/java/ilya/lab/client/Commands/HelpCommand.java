package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CommandsManager;

/**
 * help command
 */
public class HelpCommand extends Command {
    private IOManager io;
    public HelpCommand(IOManager io) {
        super(0);
        this.io = io;
    }

    @Override
    public void execute(String[] args) {
        CommandsManager.printCommandsHelp(io);
    }
}
