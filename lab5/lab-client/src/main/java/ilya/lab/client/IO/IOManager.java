package ilya.lab.client.IO;

import ilya.lab.client.Exceptions.CtrlDException;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

/**
 * in-out manager
 */
public class IOManager implements AutoCloseable{
    private final String ansiReset = "\u001B[0m";
    private final String ansiRed = "\u001B[31m";
    private final String ansiGreen = "\u001B[32m";
    private BufferedReader reader;
    private PrintWriter writer;
    private boolean isFile;
    private boolean continueExecutionFlag;

    private Stack<File> files = new Stack<>();
    private Stack<BufferedReader> readers = new Stack<>();
    private Stack<ArrayList<String>> executionStack = new Stack<>();

    /**
     * creates new IOManager
     *
     * @param reader    current reader
     * @param writer    current writer
     * @param isFile    whether working with file
     */
    public IOManager(BufferedReader reader, PrintWriter writer, boolean isFile) {
        this.reader = reader;
        this.writer = writer;
        this.isFile = isFile;
        this.continueExecutionFlag = true;
    }
    public void closeAllReaders() throws IOException {
        while (!readers.isEmpty()) {//todo закрывается только в случае рекурсии?
            BufferedReader br = readers.pop();
            br.close();
        }
    }

    public boolean isLastFileExecuted() {
        if(executionStack.peek().isEmpty()) {
            executionStack.pop();
            return true;
        }
        return false;
    }
    public String getNextLineFromStack() {
        String s = executionStack.peek().get(0);
        executionStack.peek().remove(0);
        return s;
    }
    public boolean fillExecutionStack(File file) throws IOException, CtrlDException {
        if (files.contains(file)) {
            return false;//recursion detected
        }
        files.add(file);
        readers.add(reader);

        reader = new BufferedReader(new FileReader(file));

        ArrayList<String> commandsFromFile = new ArrayList<>();
        String s = readLine();
        while (!Objects.equals(s, null)) {
            commandsFromFile.add(s);
            s = readLine();
        }
        executionStack.add(commandsFromFile);
        close();
        reader = readers.pop();
        return true;
    }

    public void setContinueExecutionFlag(boolean b) {
        continueExecutionFlag = b;
    }
    public boolean getContinueExecutionFlag() {
        return continueExecutionFlag;
    }
    /**
     * sets whether manager is working with a file in a given moment to isFile
     */
    public void setIsFile(boolean b) {
        isFile = b;
    }
    /**
     * returns whether manager is working with a file in a given moment to isFile
     */
    public boolean getIsFile() {
        return isFile;
    }

    /**
     * sets buffered reader
     */
    public  void setBufferedReader(BufferedReader buf) {
        reader = buf;
    }

    /**
     * returns current buffered reader
     */
    public  BufferedReader getBufferedReader() {
        return reader;
    }

    /**
     * reads one line
     *
     * @return returns read line
     */
    public String readLine() throws IOException, CtrlDException {
        String s = reader.readLine();
        if (s == null & !isFile) {
            throw new CtrlDException();
        }
        return s;
    }

    /**
     * closes reader
     */
    public void close() throws IOException {
        reader.close();
    }

    /**
     * prints passed object without new
     *
     * @param o object to print
     */
    public  void print(Object o) {
        writer.printf("%s", o);
    }
    /**
     * prints passed object with new line
     *
     * @param o object to print
     */
    public  void println(Object o) {
        writer.println(o);
    }

    /**
     * prints passed warning message
     *
     * @param o object to print
     */
    public void printWarning(Object o) {
        writer.println(ansiRed + o + ansiReset);
    }

    public void printConfirmation(Object o) {
        writer.println(ansiGreen + o + ansiReset);
    }
}
