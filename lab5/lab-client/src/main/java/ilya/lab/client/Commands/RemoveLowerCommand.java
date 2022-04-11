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
    private CollectionManager manager;
    public RemoveLowerCommand(IOManager io, CollectionManager manager) {
        super(0, io);
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) throws WrongFileFormatException, CtrlDException {
        manager.removeAllLower(new RouteCreator(getIOManager(), manager).createRoute());
        getIOManager().printConfirmation("Elements removed successfully");
    }
}
