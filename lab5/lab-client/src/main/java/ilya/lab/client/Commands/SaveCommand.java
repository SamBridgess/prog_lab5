package ilya.lab.client.Commands;

import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;
import ilya.lab.client.Utility.XmlParser;

import java.io.IOException;

/**
 * save command
 */
public class SaveCommand extends Command {
    private CollectionManager manager;
    private String path;
    public SaveCommand(IOManager io, CollectionManager manager, String path) {
        super(0, io);
        this.manager = manager;
        this.path = path;
    }

    @Override
    public void execute(String[] args) throws IOException {
        XmlParser.convertCollectionToXml(manager, path);
        getIOManager().printConfirmation("Collection was saved successfully");
    }
}
