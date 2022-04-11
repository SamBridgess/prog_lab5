package ilya.lab.client.Commands;

import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * remove_first command
 */
public class RemoveFirstCommand extends Command {
    private CollectionManager manager;
    public RemoveFirstCommand(IOManager io, CollectionManager manager) {
        super(0, io);
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) throws WrongFileFormatException {
        if (manager.removeRouteByIdx(0)) {
            getIOManager().printConfirmation("First element removed successfully");
        } else {
            getIOManager().printWarning("Collection is empty, no first element");
            if (getIOManager().getIsFile()) {
                throw new WrongFileFormatException();
            }
        }
    }
}
