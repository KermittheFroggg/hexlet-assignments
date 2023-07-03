package exercise;

import java.util.Arrays;
import java.util.stream.Stream;


// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        String[][] array = Arrays.stream(image)
                .flatMap(u -> Stream.of(u, u))
                .map(y -> Arrays.asList(y).stream()
                        .flatMap(x -> Stream.of(x, x))
                        .toArray(String[]::new))
                .toArray(String[][]::new);
        return array;
    }
}
// END
