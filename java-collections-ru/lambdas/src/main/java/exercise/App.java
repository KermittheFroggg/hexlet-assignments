package exercise;

import java.util.Arrays;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        String[][] array = Arrays.stream(image)
                .flatMap(u -> Stream.of(u, u))
                .map(y -> Arrays.asList(y).stream()
                        .flatMap(x -> Arrays.asList(x, x).stream())
                        .toArray(String[]::new))
                .toArray(String[][]::new);
        return array;
    }
}
// END
