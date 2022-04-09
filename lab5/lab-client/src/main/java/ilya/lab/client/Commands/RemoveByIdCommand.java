package ilya.lab.client.Commands;

import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * remove_by_id command
 */
public class RemoveByIdCommand extends Command {
    private final int numberOfArguments = 1;
    private final CollectionManager manager;
    private final IOManager io;
    public RemoveByIdCommand(IOManager io, CollectionManager manager) {
        this.io = io;
        this.manager = manager;
    }
    @Override
    public int getNumberOfArguments() {
        return numberOfArguments;
    }
    @Override
    public void execute(String[] args) throws WrongFileFormatException {
        try {
            manager.removeRouteByID(Long.parseLong(args[0]), io);
        } catch (NumberFormatException e) {
            io.printWarning("Invalid command's arguments!");
            if (io.getIsFile()) {
                throw new WrongFileFormatException();
            }
        }
    }
}
