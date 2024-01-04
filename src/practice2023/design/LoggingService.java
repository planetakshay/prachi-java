package practice2023.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoggingService {
    private List<LogMessage> messages;
    private static LoggingService service;

    private LoggingService(List<LogMessage> messages) {
        this.messages = messages;
    }

    public static LoggingService getInstance() {
        if(service == null) {
            synchronized (LoggingService.class) {
                if(service == null) {
                    service = new LoggingService(Collections.synchronizedList(new ArrayList<LogMessage>()));
                }
            }
        }
        return service;
    }
}

class LogMessage {
    int id;
    String message;
}