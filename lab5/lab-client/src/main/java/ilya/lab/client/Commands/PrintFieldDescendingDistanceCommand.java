package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * print_field_descending_distance command
 */
public class PrintFieldDescendingDistanceCommand extends Command {
    private final CollectionManager manager;
    private IOManager io;
    public PrintFieldDescendingDistanceCommand(IOManager io, CollectionManager manager) {
        super(0);
        this.io = io;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        manager.printDistanceList(io);
    }
}
