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
    private final int numberOfArguments = 1;
    private final CollectionManager manager;
    private IOManager io;
    private HashMap<String, Command> commands;
    private Stack<File> files;

    public ExecuteScriptCommand(IOManager io, CollectionManager manager, HashMap<String, Command> commands, Stack<File> files) {
        this.io = io;
        this.manager = manager;
        this.commands = commands;
        this.files = files;
    }

    @Override
    public int getNumberOfArguments() {
        return numberOfArguments;
    }

    @Override
    public void execute(String[] args) throws IOException, WrongFileFormatException, CtrlDException {
        File file = new File(args[0]);
        BufferedReader oldBr = io.getBufferedReader();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(args[0]));
            if (files.contains(file)) {
                io.printWarning("Recursion detected!");
                throw new WrongFileFormatException();
            }
            files.add(file);
        } catch (IOException e) {
            io.printWarning("File not found!");
            return;
        }
        io.setIsFile(true);
        io.setBufferedReader(br);
        String s;
        while (!Objects.equals(s = io.readLine(), "")) {
            try {
                LineExecuter.executeLine(s, commands, io);
            } catch (WrongFileFormatException e) {
                io.setBufferedReader(oldBr);
                io.setIsFile(false);
                throw new WrongFileFormatException();
            }
        }
        io.setBufferedReader(oldBr);
        io.setIsFile(false);
        files.pop();
        io.printConfirmation(file.getName() + " executed successfully");
    }
}
//execute_script script.txt
