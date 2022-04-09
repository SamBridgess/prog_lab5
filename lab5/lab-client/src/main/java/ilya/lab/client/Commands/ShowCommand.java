package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * show command
 */
public class ShowCommand extends Command {
    private final int numberOfArguments = 0;
    private final CollectionManager manager;
    private IOManager io;
    public ShowCommand(IOManager io, CollectionManager manager) {
        this.io = io;
        this.manager = manager;
    }
    @Override
    public int getNumberOfArguments() {
        return numberOfArguments;
    }
    @Override
    public void execute(String[] args) {
        manager.printCollection(io);
    }
}
