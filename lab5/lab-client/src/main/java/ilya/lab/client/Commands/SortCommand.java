package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * sort command
 */
public class SortCommand extends Command {
    private CollectionManager manager;
    public SortCommand(IOManager io, CollectionManager manager) {
        super(0, io);
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        manager.sortCollection();
        getIOManager().printConfirmation("Collection sorted successfully");
    }
}
