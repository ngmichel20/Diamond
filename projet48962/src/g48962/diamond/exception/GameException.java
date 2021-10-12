package g48962.diamond.exception;

/**
 * This class allows to throw exceptions.
 * 
 * @author Michel
 */
public class GameException extends Exception {

    /**
     * Creates a new instance of <code>GameException</code> without detail
     * message.
     */
    public GameException() {
    }

    /**
     * Constructs an instance of <code>GameException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public GameException(String msg) {
        super(msg);
    }
}
