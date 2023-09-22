package fr.tyr.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Override
    public String format(LogRecord record) {
        String time = dateFormat.format(new Date(record.getMillis()));
        String className = record.getSourceClassName();
        String level = record.getLevel().toString();
        String message = formatMessage(record);
        String color = switch (record.getLevel().getName()) {
            case "INFO" -> "\u001B[0;32m";
            case "WARNING" -> "\u001B[0;33m";
            case "SEVERE" -> "\u001B[0;31m";
            default -> "\u001B[0;37m";
        };
        return "%s[%s] [%s/%s]: %s\n".formatted(color, time, className, level, message);
    }
}
