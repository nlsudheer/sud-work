package org.selenium.framework.frameworkException;

/**
 * Created by sudheerl on 6/9/14.
 */
public class FrameworkException extends Exception {
    private static final long serialVersionUID = 1L;

    private Exception originalException;
    private String message;

    public FrameworkException(String message, Exception exception) {
        this.originalException = exception;
        this.message = message;
    }

    public FrameworkException(String message) {
        this.message = message;
    }

    public Exception getOriginalException() {
        return originalException;
    }

    public String getMessage() {
        return message;
    }


}
