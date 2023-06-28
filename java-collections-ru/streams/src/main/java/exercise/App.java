package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static int getCountOfFreeEmails(List<String> emailsList) {
        long count = emailsList.stream()
                .filter(email -> StringUtils.isNotBlank(email))
                .map(email -> email.split("@"))
                .filter(email -> email[1].equals("gmail.com") ||
                        email[1].equals("yandex.ru") || email[1].equals("hotmail.com"))
                .count();
        return (int) count;
    }
}
// END
