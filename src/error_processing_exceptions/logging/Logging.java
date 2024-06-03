package error_processing_exceptions.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Logging {

    private static void configureLogging() {
        Logger LOGGER_0 = Logger.getLogger("org.stepic.java");
        Logger LOGGER_1 = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger LOGGER_2 = Logger.getLogger("org.stepic.java.logging.ClassB");
        LOGGER_0.setLevel(Level.ALL);
        LOGGER_1.setLevel(Level.ALL);
        LOGGER_2.setLevel(Level.WARNING);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new XMLFormatter());
        consoleHandler.setLevel(Level.ALL);
        LOGGER_0.addHandler(consoleHandler);
        LOGGER_0.setUseParentHandlers(false);
    }
}
