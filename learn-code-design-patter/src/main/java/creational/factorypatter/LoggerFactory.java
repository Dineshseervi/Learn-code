package main.java.creational.factorypatter;

public class LoggerFactory {

    public enum LoggerType {
        DBLOGGER, CONSOLELOGGER, FILELOGGER;
    }

    public static Logger build(LoggerType loggerType) {
        Logger logger = null;
        switch (loggerType) {
            case DBLOGGER:
                logger = new DBLogger();
                break;
            case FILELOGGER:
                logger = new FileLogger();
                break;
            case CONSOLELOGGER:
                logger = new ConsoleLogger();
                break;

            default:
                logger = new ConsoleLogger();
        }

        return logger;
    }
}
