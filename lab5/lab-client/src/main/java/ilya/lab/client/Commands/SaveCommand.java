package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;
import ilya.lab.client.Utility.XmlParser;

import java.io.IOException;

/**
 * save command
 */
public class SaveCommand extends Command {
    private final int numberOfArguments = 0;
    private final CollectionManager manager;
    private IOManager io;
    private String path;

    public SaveCommand(IOManager io, CollectionManager manager, String path) {
        this.io = io;
        this.manager = manager;
        this.path = path;
    }
    @Override
    public int getNumberOfArguments() {
        return numberOfArguments;
    }
    @Override
    public void execute(String[] args) throws IOException {
        XmlParser.convertCollectionToXml(manager, path);
        io.printConfirmation("Collection was saved successfully");
    }
}
