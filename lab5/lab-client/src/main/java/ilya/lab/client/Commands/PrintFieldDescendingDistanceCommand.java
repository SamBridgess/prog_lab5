package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * print_field_descending_distance command
 */
public class PrintFieldDescendingDistanceCommand extends Command {
    public PrintFieldDescendingDistanceCommand(IOManager io, CollectionManager manager) {
        super(0, io, manager);
    }

    @Override
    public void execute(String[] args) {
        getManager().printDistanceList(getIOManager());
    }
}
