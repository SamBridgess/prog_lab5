package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;

/**
 * info command
 */
public class InfoCommand extends Command {
    private CollectionManager manager;
    public InfoCommand(IOManager io, CollectionManager manager) {
        super(0, io);
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        getIOManager().println(manager.getInfo());
    }
}
