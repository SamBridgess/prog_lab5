package ilya.lab.client.Commands;

import ilya.lab.client.Exceptions.CtrlDException;
import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;
import ilya.lab.client.Utility.LineExecuter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

/**
 * execute_script command
 */
public class ExecuteScriptCommand extends Command {
    private final CollectionManager manager;
    private HashMap<String, Command> commands;
    private Stack<File> files;

    public ExecuteScriptCommand(IOManager io, CollectionManager manager, HashMap<String, Command> commands, Stack<File> files) {
        super(1, io);
        this.manager = manager;
        this.commands = commands;
        this.files = files;
    }

    @Override
    public void execute(String[] args) throws IOException, WrongFileFormatException, CtrlDException {
        File file = new File(args[0]);
        BufferedReader oldBr = getIOManager().getBufferedReader();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(args[0]));
            if (files.contains(file)) {
                getIOManager().printWarning("Recursion detected!");
                throw new WrongFileFormatException();
            }
            files.add(file);
        } catch (IOException e) {
            getIOManager().printWarning("File not found!");
            return;
        }
        getIOManager().setIsFile(true);
        getIOManager().setBufferedReader(br);

        String s = getIOManager().readLine();
        while (!Objects.equals(s, "")) {
            try {
                LineExecuter.executeLine(s, commands, getIOManager());
            } catch (WrongFileFormatException e) {
                getIOManager().setBufferedReader(oldBr);
                getIOManager().setIsFile(false);
                throw new WrongFileFormatException();
            }
            s = getIOManager().readLine();
        }

        getIOManager().setBufferedReader(oldBr);
        getIOManager().setIsFile(false);
        files.pop();
        getIOManager().printConfirmation(file.getName() + " executed successfully");
    }
}
//execute_script script.txt
