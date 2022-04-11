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
    public RemoveLowerCommand(IOManager io, CollectionManager manager) {
        super(0, io, manager);
    }

    @Override
    public void execute(String[] args) throws WrongFileFormatException, CtrlDException {
        getManager().removeAllLower(new RouteCreator(getIOManager(), getManager()).createRoute());
        getIOManager().printConfirmation("Elements removed successfully");
    }
}
