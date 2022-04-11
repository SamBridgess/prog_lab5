package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CommandsManager;

/**
 * help command
 */
public class HelpCommand extends Command {
    public HelpCommand(IOManager io) {
        super(0, io);
    }

    @Override
    public void execute(String[] args) {
        getIOManager().println(CommandsManager.getCommandsHelp());
    }
}
