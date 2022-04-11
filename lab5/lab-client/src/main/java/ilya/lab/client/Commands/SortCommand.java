package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * sort command
 */
public class SortCommand extends Command {
    private final CollectionManager manager;
    private IOManager io;
    public SortCommand(IOManager io, CollectionManager manager) {
        super(0);
        this.io = io;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        manager.sortCollection();
        io.printConfirmation("Collection sorted successfully");
    }
}
