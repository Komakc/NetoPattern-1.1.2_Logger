import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerSingleton {
    private static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    protected int num = 1;

    public void log(String msg) {
        System.out.println("[" + DEFAULT_TIME_FORMATTER.format(LocalDateTime.now()) + " " + num++ + "] " + msg);
    }

    private static LoggerSingleton instance = null;

    private LoggerSingleton() {
    }

    public static LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }
}