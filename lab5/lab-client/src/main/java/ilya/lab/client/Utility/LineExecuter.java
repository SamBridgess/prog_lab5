package ilya.lab.client.Utility;

import ilya.lab.client.Commands.Command;
import ilya.lab.client.Exceptions.CtrlDException;
import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.IO.IOManager;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/**
 * executes a scanned line
 */
public final class LineExecuter {
    private LineExecuter() {
    }

    /**
     * tries to execute a scanned line
     *
     * @param s                 String with a line to execute
     * @param commands          list of all commands
     * @throws WrongFileFormatException
     * @throws IOException
     */
    public static void executeLine(String s, HashMap<String, Command> commands, IOManager io) throws IOException, WrongFileFormatException, CtrlDException {
        String[] words = s.trim().split("\\s++");

        String command = words[0];
        String[] args = Arrays.copyOfRange(words, 1, words.length);

        if (Objects.equals(command, "")) {
            return;
        }
        CommandsManager.execute(command, args, commands, io);
    }

}
