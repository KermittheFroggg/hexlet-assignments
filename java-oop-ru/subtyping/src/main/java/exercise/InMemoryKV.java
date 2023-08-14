package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private static Map<String, String> map;

    public InMemoryKV(Map<String, String> map) {
        Map newMap = new HashMap<String,String>(map);
        this.map = newMap;
    }

    public void set(String key, String value) {
        Map newMap = new HashMap<String,String>(map);
        newMap.put(key, value);
        this.map = newMap;
    }

    public void unset(String key) {
        Map newMap = new HashMap<String,String>(map);
        newMap.remove(key);
        this.map = newMap;
    }

    public String get(String key, String defaultValue) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return defaultValue;
        }
    }

    public Map<String, String> toMap() {
        return new HashMap<>(map);
    }
}
// END
