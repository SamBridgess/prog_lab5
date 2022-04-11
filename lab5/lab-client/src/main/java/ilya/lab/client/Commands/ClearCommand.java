package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * clear command
 */
public class ClearCommand extends Command {
    private CollectionManager manager;
    public ClearCommand(IOManager io, CollectionManager manager) {
        super(0, io);
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        manager.clearCollection();
        getIOManager().printConfirmation("Collection cleared successfully");

    }
}
