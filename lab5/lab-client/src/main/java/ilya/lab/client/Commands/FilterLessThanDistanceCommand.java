package ilya.lab.client.Commands;

import ilya.lab.client.Classes.Route;
import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * filter_less_than_distance command
 */
public class FilterLessThanDistanceCommand extends Command {
    private CollectionManager manager;
    public FilterLessThanDistanceCommand(IOManager io, CollectionManager manager) {
        super(1, io);
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) throws WrongFileFormatException {
        try {
            for (Route r : manager.getCollection()) {
                if (r.getDistance() < Float.parseFloat(args[0])) {
                    getIOManager().println(r);
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
