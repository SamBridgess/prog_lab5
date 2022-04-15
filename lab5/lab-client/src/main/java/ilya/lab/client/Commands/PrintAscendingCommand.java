package ilya.lab.client.Commands;

import ilya.lab.client.Classes.Route;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

import java.util.ArrayList;
import java.util.Collections;

/**
 * print_ascending command
 */
public class PrintAscendingCommand extends Command {
    private final CollectionManager manager;
    public PrintAscendingCommand(IOManager io, CollectionManager manager) {
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
        ArrayList<Route> listCopy = new ArrayList<>(manager.getCollection());
        Collections.sort(listCopy);
        for (Route r : listCopy) {
            getIOManager().println(r);
        }
    }
}
