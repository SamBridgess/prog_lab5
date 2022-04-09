package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * remove_first command
 */
public class RemoveFirstCommand extends Command {
    private final int numberOfArguments = 0;
    private final CollectionManager manager;
    private IOManager io;
    public RemoveFirstCommand(IOManager io, CollectionManager manager) {
        this.io = io;
        this.manager = manager;
    }
    @Override
    public int getNumberOfArguments() {
        return numberOfArguments;
    }
    @Override
    public void execute(String[] args) {
        manager.removeElement(0, io);
    }
}
