package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * print_ascending command
 */
public class PrintAscendingCommand extends Command {
    private final CollectionManager manager;
    public PrintAscendingCommand(IOManager io, CollectionManager manager) {
        super(0, io);
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        manager.printCollectionAscending(getIOManager());
    }
}
