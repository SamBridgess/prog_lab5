package ilya.lab.client.Commands;

import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * filter_less_than_distance command
 */
public class FilterLessThanDistanceCommand extends Command {
    private final CollectionManager manager;
    public FilterLessThanDistanceCommand(IOManager io, CollectionManager manager) {
        super(1, io);
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) throws WrongFileFormatException {
        try {
            manager.printLessThanDistance(Float.parseFloat(args[0]), getIOManager());
        } catch (NumberFormatException e) {
            getIOManager().printWarning("Invalid command's arguments!");
            if (getIOManager().getIsFile()) {
                throw new WrongFileFormatException();
            }
        }
    }
}
