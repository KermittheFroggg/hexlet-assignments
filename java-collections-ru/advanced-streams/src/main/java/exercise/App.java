package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String str) {
        String sortedStr = Arrays.stream(str.split("\n"))
                .filter(field -> field.startsWith("environment"))
                .map(field2 -> field2.replaceAll("environment=",","))
                .map(field4 -> field4.replaceAll("\"",""))
                .collect(Collectors.joining(","));
        String sortedStr2 = Arrays.stream(sortedStr.split(","))
                .filter(field -> field.startsWith("X_FORWARDED_"))
                .map(field3 -> field3.replaceAll("X_FORWARDED_",""))
                .collect(Collectors.joining(","));
        return sortedStr2;
    }
}
//END
