package ilya.lab.client.Commands;

import ilya.lab.client.Exceptions.CtrlDException;
import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.IO.RouteCreator;
import ilya.lab.client.Utility.CollectionManager;

/**
 * remove_lower command
 */
public class RemoveLowerCommand extends Command {
    private final int numberOfArguments = 0;
    private final CollectionManager manager;
    private final IOManager io;
    public RemoveLowerCommand(IOManager io, CollectionManager manager) {
        this.io = io;
        this.manager = manager;
    }
    @Override
    public int getNumberOfArguments() {
        return numberOfArguments;
    }
    @Override
    public void execute(String[] args) throws WrongFileFormatException, CtrlDException {
        manager.removeAllLower(new RouteCreator(io, manager).createRoute());
        io.printConfirmation("Elements removed successfully");
    }
}
