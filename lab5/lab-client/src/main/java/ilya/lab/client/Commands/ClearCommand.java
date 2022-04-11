package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * clear command
 */
public class ClearCommand extends Command {
    private final CollectionManager manager;
    private IOManager io;
    public ClearCommand(IOManager io, CollectionManager manager) {
        super(0);
        this.io = io;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        manager.clearCollection(io);
    }
}
