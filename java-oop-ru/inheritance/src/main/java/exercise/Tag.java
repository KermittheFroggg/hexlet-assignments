package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    String name;

    Map<String, String> atributes;

    public Tag(String name, Map<String, String> atributes) {
        this.name = name;
        this.atributes = atributes;
    }
    public String toString() {
        StringBuilder toString = new StringBuilder(name);
        for (Map.Entry<String,String> entry: atributes.entrySet()) {
            toString.append(String.format(" %s=\"%s\"",entry.getKey(), entry.getValue()));
        }
        toString.insert(0,"<");
        toString.append(">");
        return String.valueOf(toString);
    }
}
// END
