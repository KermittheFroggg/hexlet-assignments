package exercise;

import java.util.List;

// BEGIN
public class App {
    public static int getCountOfFreeEmails(List<String> emailsList) {
        long count = emailsList.stream()
                .map(email -> email.split("@"))
                .filter(email -> email[1].equals("gmail.com")
                        || email[1].equals("yandex.ru") || email[1].equals("hotmail.com"))
                .count();
        return (int) count;
    }
}
// END
