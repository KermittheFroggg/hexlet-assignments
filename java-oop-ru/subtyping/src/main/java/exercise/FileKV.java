package exercise;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String stringPath;
    public FileKV(String stringPath, Map<String, String> map) {
        Map<String, String> newMap = new HashMap<String,String>(map);
        String serialized = Utils.serialize(newMap);
        Utils.writeFile(stringPath, serialized);
        this.stringPath = stringPath;
    }

    public void set(String key, String value) {
        String json = Utils.readFile(stringPath);
        Map<String, String> newMap = Utils.unserialize(json);
        newMap.put(key, value);
        String serialized = Utils.serialize(newMap);
        Utils.writeFile(stringPath, serialized);
    }

    public void unset(String key) {
        String json = Utils.readFile(stringPath);
        Map<String, String> newMap = Utils.unserialize(json);
        newMap.remove(key);
        String serialized = Utils.serialize(newMap);
        Utils.writeFile(stringPath, serialized);
    }

    public String get(String key, String defaultValue) {
        String json = Utils.readFile(stringPath);
        Map<String, String> map = Utils.unserialize(json);
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return defaultValue;
        }
    }

    public Map<String, String> toMap() {
        String json = Utils.readFile(stringPath);
        Map<String, String> map = Utils.unserialize(json);
        return new HashMap<>(map);
    }
}
// END
