package IV1350_seminar_3.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * displaying information about the error to the user
 */
public class ErrorMessageHandler {
    public void showErrorMessage(String errorMessage) {
        StringBuilder message = new StringBuilder();
        message.append("[USER_LOG] ");
        message.append(createTime());
        message.append(": [ERROR] ");
        message.append(errorMessage);
        System.out.println(message);
    }
    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
}
