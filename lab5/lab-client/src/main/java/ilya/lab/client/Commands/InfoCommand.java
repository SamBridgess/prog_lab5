package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * info command
 */
public class InfoCommand extends Command {
    public InfoCommand(IOManager io, CollectionManager manager) {
        super(0, io, manager);
    }

    @Override
    public void execute(String[] args) {
        getManager().printInfo(getIOManager());
    }
}
