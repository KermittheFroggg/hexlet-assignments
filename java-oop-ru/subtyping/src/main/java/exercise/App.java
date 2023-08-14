package exercise;

import java.util.Map;

// BEGIN

// END

public class App {
    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("foo", "bar", "bar", "zoo"));
        App.swapKeyValue(storage);
        System.out.println(storage.toMap()); // => {value=key, value2=key2}
    }

    public static void swapKeyValue(KeyValueStorage map) {
        for (Map.Entry<String, String> entry : map.toMap().entrySet()) {
            map.set(entry.getValue(), entry.getKey());
            map.unset(entry.getKey());

        }
    }
}
