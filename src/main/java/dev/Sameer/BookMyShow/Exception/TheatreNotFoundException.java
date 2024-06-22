package dev.Sameer.BookMyShow.Exception;

public class TheatreNotFoundException extends RuntimeException {
    public TheatreNotFoundException() {
    }

    public TheatreNotFoundException(String message) {
        super(message);
    }

    public TheatreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TheatreNotFoundException(Throwable cause) {
        super(cause);
    }

    public TheatreNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
