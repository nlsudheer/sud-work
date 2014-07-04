package org.selenium.framework.utils;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * A common logger wrapper. All of our libraries will use this class instead of directly talking to
 * an underlying logging framework. This provides us with the flexibility to use a different logging
 * framework if necessary.
 *
 * The current implementation uses the Log4j framework.
 */
public class Logger {

    public enum LoggingLevel { ALL, TRACE, DEBUG, INFO, WARN, ERROR, FATAL };
    private org.apache.log4j.Logger logger = null;

    public static Logger getLogger(Class<?> clazz) {
        return new Logger(org.apache.log4j.Logger.getLogger(clazz));
    }

    public static Logger getLogger(String name) {
        return new Logger(org.apache.log4j.Logger.getLogger(name));
    }

    /**
     * This method is for internal use by logging framework only
     * (It is public because of Java class loading technicalities in Tomcat)
     *
     */
    public static void shutdown() {
        // implement flushing of the underlying logger if possible
        LogManager.shutdown();
    }

    public void setLevel(LoggingLevel level) {
        logger.setLevel(getInternalLevel(level));
    }

    private Level getInternalLevel(LoggingLevel level) {
        switch (level) {
            case ALL:
                return Level.ALL;
            case TRACE:
                return Level.TRACE;
            case DEBUG:
                return Level.DEBUG;
            case INFO:
                return Level.INFO;
            case WARN:
                return Level.WARN;
            case ERROR:
                return Level.ERROR;
            case FATAL:
                return Level.FATAL;
        }

        return null;
    }

    protected Logger(org.apache.log4j.Logger logger) {
        this.logger = logger;
    }

    private static String getCallerCallerName() {
        StackTraceElement[] st = (new Throwable()).getStackTrace();
        // return first class inside of this package
        for (int i = 1; i < st.length; i++) {
            if (!st[i].getClassName().startsWith(
                    Logger.class.getPackage().getName())) {
                return st[i-1].getClassName();
            }
        }
        return null;
    }

    public void logTime(String label, long startTime) {
        logger.info("finished " + label + " in " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * Log a message with <code>TRACE</code> level.
     * @param message message object
     */
    public void trace(Object message) {
        if(isTraceEnabled()){
            logger.log(getCallerCallerName(), Level.TRACE, message, null);
        }
    }

    /**
     * Log a message with <code>TRACE</code> level.
     * @param message message object
     * @param t enclosed exception object
     */
    public void trace(Object message, Throwable t) {
        if(isTraceEnabled()){
            logger.log(getCallerCallerName(), Level.TRACE, message, getSource(t) );
        }
    }

    /**
     * Log a message to the with <code>DEBUG</code> level.
     * @param message message object
     */
    public void debug(Object message) {
        if(isDebugEnabled()){
            logger.log(getCallerCallerName(), Level.DEBUG, message, null);
        }
    }

    /**
     * Log a message with <code>DEBUG</code> level.
     * @param message message object
     * @param t enclosed exception object
     */
    public void debug(Object message, Throwable t) {
        if(isDebugEnabled()){
            logger.log(getCallerCallerName(), Level.DEBUG, message, getSource(t) );
        }
    }

    /**
     * Log a message with <code>INFO</code> level.
     * @param message message object
     */
    public void info(Object message) {
        logger.log(getCallerCallerName(), Level.INFO, message, null );
    }

    /**
     * Log a message with <code>INFO</code> level.
     * @param message message object
     * @param t enclosed exception object
     */
    public void info(Object message, Throwable t) {
        logger.log(getCallerCallerName(), Level.INFO, message, getSource(t) );
    }

    /**
     * Log a message with <code>WARN</code> level.
     * @param message message object
     */
    public void warn(Object message) {
        logger.log(getCallerCallerName(), Level.WARN, message, null );
    }

    /**
     * Log a message with <code>WARN</code> level.
     * @param message message object
     * @param t enclosed exception object
     */
    public void warn(Object message, Throwable t) {
        logger.log(getCallerCallerName(), Level.WARN, message, getSource(t) );
    }

    /**
     * Log a message with <code>ERROR</code> level.
     * @param message message object
     */
    public void error(Object message) {
        logger.log(getCallerCallerName(), Level.ERROR, message, message instanceof Throwable ? (Throwable) message : null  );
    }

    /**
     * Log a message with <code>ERROR</code> level.
     * @param message message object
     * @param t enclosed exception object
     */
    public void error(Object message, Throwable t) {
        logger.log(getCallerCallerName(), Level.ERROR, message, getSource(t));
    }

    /**
     * Log a message with <code>FATAL</code> level.
     * @param message message object
     */
    public void fatal(Object message) {
        logger.log(getCallerCallerName(), Level.FATAL, message, null );
    }

    /**
     * Log a message with <code>FATAL</code> level.
     * @param message message object
     * @param t enclosed exception object
     */
    public void fatal(Object message, Throwable t) {
        logger.log(getCallerCallerName(), Level.FATAL, message, getSource(t) );
    }

    /**
     * Check whether this instance is enabled for <code>DEBUG</code> level.
     * @return true if logging is enabled, false otherwise
     */
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    /**
     * Check whether this instance is enabled for <code>ERROR</code> level.
     * @return true if logging is enabled, false otherwise
     */
    public boolean isErrorEnabled() {
        return logger.isEnabledFor(Level.ERROR);
    }

    /**
     * Check whether this instance is enabled for <code>FATAL</code> level.
     * @return true if logging is enabled, false otherwise
     */
    public boolean isFatalEnabled() {
        return logger.isEnabledFor(Level.FATAL);
    }

    /**
     * Check whether this instance is enabled for <code>INFO</code> level.
     * @return true if logging is enabled, false otherwise
     */
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    /**
     * Check whether this instance is enabled for <code>TRACE</code> level.
     * @return true if logging is enabled, false otherwise
     */
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    /**
     * Check whether this instance is enabled for <code>WARN</code> level.
     * @return true if logging is enabled, false otherwise
     */
    public boolean isWarnEnabled() {
        return logger.isEnabledFor(Level.WARN);
    }

    public Throwable getSource(Throwable throwable) {
        List<Throwable> throwables = getThrowableChain(throwable);
        return (throwables.size() > 0  ? throwables.get(throwables.size()-1) : null);
    }

    public static List<Throwable> getThrowableChain(Throwable throwable) {
        List<Throwable> throwables = new ArrayList<Throwable>();
        Throwable current = throwable;
        while (current != null) {
            throwables.add(current);
            current = current.getCause() != null? current.getCause():null;
        }
        return  throwables;
    }

    /**
     * Returns stack trace as a String.
     *
     * @param throwable
     * @return
     */
    public static String getStackTrace(Throwable throwable) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        throwable.printStackTrace(printWriter);
        return result.toString();
    }

}
