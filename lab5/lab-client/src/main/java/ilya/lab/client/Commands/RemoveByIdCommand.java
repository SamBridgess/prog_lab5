package ilya.lab.client.Commands;

import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * remove_by_id command
 */
public class RemoveByIdCommand extends Command {
    private final CollectionManager manager;
    public RemoveByIdCommand(IOManager io, CollectionManager manager) {
        super(1, io);
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) throws WrongFileFormatException {
        try {
            manager.removeRouteByID(Long.parseLong(args[0]), getIOManager());
        } catch (NumberFormatException e) {
            getIOManager().printWarning("Invalid command's arguments!");
            if (getIOManager().getIsFile()) {
                throw new WrongFileFormatException();
            }
        }
    }
}
