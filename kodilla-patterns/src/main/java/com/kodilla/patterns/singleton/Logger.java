package com.kodilla.patterns.singleton;

public class Logger {
    private static Logger LoggerInstance = null;
    private String lastLog = "";

    public static Logger getInstance() {
        if (LoggerInstance == null) {
            synchronized(Logger.class) {
                if (LoggerInstance == null) {
                    LoggerInstance = new Logger();
                }
            }
        }
        return LoggerInstance;
    }

    public void log(String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    public String getLastLog() {
        return lastLog;
    }
}