package IV1350_seminar_3.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class LogHandler {
    /**
     * logging information about the exception to the developer
     * @param exception is the exception caught
     */
    public void logErrorMessage(Exception exception) {
        StringBuilder message = new StringBuilder();
        message.append(createTime());
        message.append(", [[DEVELOPER_LOG] Exception was thrown]: \t");
        message.append(exception.getMessage());
        message.append(exception.getStackTrace().toString());
        System.out.println(message);
    }
    private String createTime() {
        /**
         * creating a readable time data string
         */
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
}