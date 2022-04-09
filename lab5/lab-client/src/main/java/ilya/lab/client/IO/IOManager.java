package ilya.lab.client.IO;

import ilya.lab.client.Exceptions.CtrlDException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * in-out manager
 */
public class IOManager {
    private final String ansiReset = "\u001B[0m";
    private final String ansiRed = "\u001B[31m";
    private final String ansiGreen = "\u001B[32m";
    private BufferedReader reader;
    private PrintWriter writer;
    private boolean isFile;
    private boolean continueExecutionFlag;

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
        if (s == null) {
            throw new CtrlDException();
        }
        return s;
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
