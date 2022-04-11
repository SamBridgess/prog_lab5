package ilya.lab.client.Commands;

import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * remove_by_id command
 */
public class RemoveByIdCommand extends Command {
    private CollectionManager manager;
    public RemoveByIdCommand(IOManager io, CollectionManager manager) {
        super(1, io);
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) throws WrongFileFormatException {
        try {
            if (manager.removeRouteByID(Long.parseLong(args[0]))) {
                getIOManager().printConfirmation("Element removed successfully");
            } else {
                getIOManager().printWarning("There is no element with such ID in collection");
                if (getIOManager().getIsFile()) {
                    throw new WrongFileFormatException();
                }
            }
        } catch (NumberFormatException e) {
            getIOManager().printWarning("Invalid command's arguments!");
            if (getIOManager().getIsFile()) {
                throw new WrongFileFormatException();
            }
        }
    }
}
