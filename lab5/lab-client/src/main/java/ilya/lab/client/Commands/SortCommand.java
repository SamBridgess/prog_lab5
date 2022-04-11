package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * sort command
 */
public class SortCommand extends Command {
    public SortCommand(IOManager io, CollectionManager manager) {
        super(0, io, manager);
    }

    @Override
    public void execute(String[] args) {
        getManager().sortCollection();
        getIOManager().printConfirmation("Collection sorted successfully");
    }
}
