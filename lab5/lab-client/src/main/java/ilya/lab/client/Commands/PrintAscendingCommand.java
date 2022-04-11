package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * print_ascending command
 */
public class PrintAscendingCommand extends Command {
    public PrintAscendingCommand(IOManager io, CollectionManager manager) {
        super(0, io, manager);
    }

    @Override
    public void execute(String[] args) {
        getManager().printCollectionAscending(getIOManager());
    }
}
