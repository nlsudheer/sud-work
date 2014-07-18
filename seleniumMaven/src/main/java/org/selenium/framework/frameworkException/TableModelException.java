package org.selenium.framework.frameworkException;

/**
 * Created by sudheerl on 7/10/14.
 */
public class TableModelException extends Exception {

    private static final long serialVersionUID = 1L;

    private Exception originalException;
    private String message;

    public TableModelException(String message, Exception exception) {
        this.originalException = exception;
        this.message = message;
    }

    public TableModelException(String message) {
        this.message = message;
    }

    public Exception getOriginalException() {
        return originalException;
    }

    public String getMessage() {
        return message;
    }
}
