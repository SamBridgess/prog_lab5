package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * sort command
 */
public class SortCommand extends Command {
    private final CollectionManager manager;
    public SortCommand(IOManager io, CollectionManager manager) {
        super(0, io);
        this.manager = manager;
    }

    /**
     * executes command with arguments
     *
     * @param args      arguments
     */
    @Override
    public void execute(String[] args) {
        manager.sortCollection();
        getIOManager().printConfirmation("Collection sorted successfully");
    }
}
