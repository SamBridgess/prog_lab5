package ilya.lab.client.Commands;

import ilya.lab.client.Classes.Route;
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

    /**
     * executes command with arguments
     *
     * @param args      arguments
     */
    @Override
    public void execute(String[] args) {
        for (Route r : manager.getCollection()) {
            getIOManager().println(r);
        }
    }
}
