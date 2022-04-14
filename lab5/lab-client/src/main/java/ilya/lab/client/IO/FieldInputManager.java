package ilya.lab.client.IO;

import ilya.lab.client.Exceptions.CtrlDException;
import ilya.lab.client.Exceptions.InvalidValueException;
import ilya.lab.client.Exceptions.WrongFileFormatException;
import ilya.lab.client.Utility.ValueValidator;

import java.io.IOException;
import java.util.Objects;

/**
 * manages input of a field checking input restrictions
 */
public class FieldInputManager {
    /**
     * loops input until all field requirements are fulfilled
     *
     * @param message                   message with input invitation
     * @param io                        in-out manager
     * @param clazz                     expected input type
     * @param validator                 contains input restrictions
     * @return                          returns input value converted to required type
     * @throws WrongFileFormatException throws exception in case data scanned from a file doesn't fulfil requirements
     */
    public <T> T validatedLoopInput(String message, IOManager io, Class<T> clazz, ValueValidator validator) throws WrongFileFormatException, CtrlDException {
        while (true) {
            try {
                String s;
                if (!io.getIsFile()) {
                    io.print(message);
                    s = io.readLine();
                } else {
                    s = io.getNextLineFromStack();
                }

                Object n;
                if (Objects.equals(s, "")) {
                    n = null;
                } else {
                    n = convertTo(s, clazz);
                }
                T t = (T) n;
                if (!validator.validate(n, clazz)) {
                    throw new InvalidValueException();
                }
                return t;
            } catch (NumberFormatException | InvalidValueException | IOException e) {
                io.printWarning("Invalid value!");
                if (io.getIsFile()) {
                    throw new WrongFileFormatException();
                }
            }
        }
    }

    /**
     * converts string to passed type
     *
     * @param s         string to convert
     * @param clazz     type to convert to
     * @return          returns converted object
     */
    private <T> T convertTo(String s, Class<?> clazz) {
        T t;
        if (clazz == Integer.class) {
            t = (T) Integer.valueOf(s);
        } else if (clazz == Long.class) {
            t = (T) Long.valueOf(s);
        } else if (clazz == Double.class) {
            t = (T) Double.valueOf(s);
        } else if (clazz == Float.class) {
            t = (T) Float.valueOf(s);
        } else {
            t = (T) s;
        }
        return t;
    }
}
