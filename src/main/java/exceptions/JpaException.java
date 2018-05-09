package exceptions;

public class JpaException extends Exception {

    public JpaException() {
    }

    public JpaException(String message) {
        super(message);
    }
}
