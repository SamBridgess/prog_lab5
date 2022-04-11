package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * remove_first command
 */
public class RemoveFirstCommand extends Command {
    public RemoveFirstCommand(IOManager io, CollectionManager manager) {
        super(0, io, manager);
    }

    @Override
    public void execute(String[] args) {
        getManager().removeElement(0, getIOManager());
    }
}
