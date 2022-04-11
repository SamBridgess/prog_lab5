package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * remove_first command
 */
public class RemoveFirstCommand extends Command {
    private final CollectionManager manager;
    public RemoveFirstCommand(IOManager io, CollectionManager manager) {
        super(0, io);
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        manager.removeElement(0, getIOManager());
    }
}
