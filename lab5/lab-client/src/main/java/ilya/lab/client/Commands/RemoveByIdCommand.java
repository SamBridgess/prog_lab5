package ilya.lab.client.Commands;

import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * remove_by_id command
 */
public class RemoveByIdCommand extends Command {
    public RemoveByIdCommand(IOManager io, CollectionManager manager) {
        super(1, io, manager);
    }

    @Override
    public void execute(String[] args) throws WrongFileFormatException {
        try {
            getManager().removeRouteByID(Long.parseLong(args[0]), getIOManager());
        } catch (NumberFormatException e) {
            getIOManager().printWarning("Invalid command's arguments!");
            if (getIOManager().getIsFile()) {
                throw new WrongFileFormatException();
            }
        }
    }
}
