package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * show command
 */
public class ShowCommand extends Command {
    private final CollectionManager manager;
    public ShowCommand(IOManager io, CollectionManager manager) {
        super(0, io);
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        manager.printCollection(getIOManager());
    }
}
