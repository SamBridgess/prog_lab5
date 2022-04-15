package ilya.lab.client.Commands;

import ilya.lab.client.Classes.Route;
import ilya.lab.client.Exceptions.CtrlDException;
import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.IO.RouteCreator;
import ilya.lab.client.Utility.CollectionManager;

import java.io.IOException;

/**
 * update command
 */
public class UpdateCommand extends Command {
    private CollectionManager manager;
    public UpdateCommand(IOManager io, CollectionManager manager) {
        super(1, io);
        this.manager = manager;
    }

    /**
     * executes command with arguments
     *
     * @param args      arguments
     * @throws WrongFileFormatException
     * @throws CtrlDException
     */
    @Override
    public void execute(String[] args) throws WrongFileFormatException, CtrlDException {
        try {
            if (manager.isElementIdPresent(Long.valueOf(args[0]))) {
                Route route = new RouteCreator(getIOManager(), manager).createRoute();
                manager.updateRouteByID(Long.valueOf(args[0]), route);
                getIOManager().printConfirmation("Updated element successfully");
            } else {
                getIOManager().printWarning("There is no object with such ID in the collection!");
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
