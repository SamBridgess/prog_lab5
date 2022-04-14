package ilya.lab.client;

import ilya.lab.client.Commands.AddCommand;
import ilya.lab.client.Commands.ClearCommand;
import ilya.lab.client.Commands.Command;
import ilya.lab.client.Commands.ExecuteScriptCommand;
import ilya.lab.client.Commands.ExitCommand;
import ilya.lab.client.Commands.FilterLessThanDistanceCommand;
import ilya.lab.client.Commands.HelpCommand;
import ilya.lab.client.Commands.InfoCommand;
import ilya.lab.client.Commands.PrintAscendingCommand;
import ilya.lab.client.Commands.PrintFieldDescendingDistanceCommand;
import ilya.lab.client.Commands.RemoveByIdCommand;
import ilya.lab.client.Commands.RemoveFirstCommand;
import ilya.lab.client.Commands.RemoveLowerCommand;
import ilya.lab.client.Commands.SaveCommand;
import ilya.lab.client.Commands.ShowCommand;
import ilya.lab.client.Commands.SortCommand;
import ilya.lab.client.Commands.UpdateCommand;
import ilya.lab.client.Exceptions.CtrlDException;
import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;
import ilya.lab.client.Utility.CollectionManager;
import ilya.lab.client.Utility.LineExecuter;
import ilya.lab.client.Utility.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) {
        try (IOManager io = new IOManager(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out, true), false)) {
            String path = "SomeFile.xml";
            /*String path;
            if (args.length != 1) {
                io.printWarning("This program only takes one argument!");
                return;
            } else {
                path = args[0];
            }*/
            CollectionManager manager;
            try {
                manager = XmlParser.convertXmlToCollection(path);
            } catch (JAXBException e) {
                io.printWarning("Couldn't load collection from file, file has wrong format! Exiting program...");
                return;
            } catch (IllegalArgumentException e) {
                io.printWarning("Couldn't load collection from file, file doesn't exist! Exiting program...");
                return;
            }
            manager.setMinId();

            HashMap<String, Command> commands = createCommandsMap(manager, io, path);
            while (io.getContinueExecutionFlag()) {
                try {
                    io.print(">>> ");

                    String s = io.readLine();
                    LineExecuter.executeLine(s, commands, io);
                } catch (WrongFileFormatException e) {
                    io.printWarning("Can't execute script further! Wrong file format");
                } catch (CtrlDException e) {
                    io.printWarning("ctrl + D detected! Exiting program...");
                    return;
                }
            }
        } catch (IOException ignored) {
        }
    }
    public static HashMap<String, Command> createCommandsMap(CollectionManager  manager, IOManager io, String path) {
        HashMap<String, Command> commands = new HashMap<>();
        commands.put("help", new HelpCommand(io));
        commands.put("info", new InfoCommand(io, manager));
        commands.put("show", new ShowCommand(io, manager));
        commands.put("add", new AddCommand(io, manager));
        commands.put("update", new UpdateCommand(io, manager));
        commands.put("remove_by_id", new RemoveByIdCommand(io, manager));
        commands.put("clear", new ClearCommand(io, manager));
        commands.put("save", new SaveCommand(io, manager, path));
        commands.put("execute_script", new ExecuteScriptCommand(io, commands));
        commands.put("exit", new ExitCommand(io));
        commands.put("remove_first", new RemoveFirstCommand(io, manager));
        commands.put("remove_lower", new RemoveLowerCommand(io, manager));
        commands.put("sort", new SortCommand(io, manager));
        commands.put("filter_less_than_distance", new FilterLessThanDistanceCommand(io, manager));
        commands.put("print_ascending", new PrintAscendingCommand(io, manager));
        commands.put("print_field_descending_distance", new PrintFieldDescendingDistanceCommand(io, manager));
        return commands;
    }

}
