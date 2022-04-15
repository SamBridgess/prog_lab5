package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * print_field_descending_distance command
 */
public class PrintFieldDescendingDistanceCommand extends Command {
    private final CollectionManager manager;
    public PrintFieldDescendingDistanceCommand(IOManager io, CollectionManager manager) {
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
        for (Float f : manager.createDistanceList()) {
            getIOManager().println(f);
        }
    }
}
