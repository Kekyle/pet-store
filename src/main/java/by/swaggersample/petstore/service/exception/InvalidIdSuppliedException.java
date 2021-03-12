package by.swaggersample.petstore.service.exception;

public class InvalidIdSuppliedException extends RuntimeException {
    public InvalidIdSuppliedException() {
        super();
    }

    public InvalidIdSuppliedException(String message) {
        super(message);
    }

    public InvalidIdSuppliedException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIdSuppliedException(Throwable cause) {
        super(cause);
    }

    protected InvalidIdSuppliedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
