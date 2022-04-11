package ilya.lab.client.Commands;

import ilya.lab.client.Exceptions.CtrlDException;
import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * add command
 */
public class AddCommand extends Command {
    public AddCommand(IOManager io, CollectionManager manager) {
        super(0, io, manager);
    }

    @Override
    public void execute(String[] args) throws WrongFileFormatException, CtrlDException {
        getManager().addNewElement(getIOManager());
    }
}
