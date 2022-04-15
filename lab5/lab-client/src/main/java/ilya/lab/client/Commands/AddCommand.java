package ilya.lab.client.Commands;

import ilya.lab.client.Classes.Route;
import ilya.lab.client.Exceptions.CtrlDException;
import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.IO.RouteCreator;
import ilya.lab.client.Utility.CollectionManager;

import java.io.IOException;

/**
 * add command
 */
public class AddCommand extends Command {
    private CollectionManager manager;
    public AddCommand(IOManager io, CollectionManager manager) {
        super(0, io);
        this.manager = manager;
    }

    /**
     * executes command with arguments
     * @param args      arguments
     * @throws WrongFileFormatException
     * @throws CtrlDException
     */
    @Override
    public void execute(String[] args) throws WrongFileFormatException, CtrlDException {
        Route route = new RouteCreator(getIOManager(), manager).createRoute();
        manager.addNewElement(route);
        getIOManager().printConfirmation("Element added successfully");
    }
}
