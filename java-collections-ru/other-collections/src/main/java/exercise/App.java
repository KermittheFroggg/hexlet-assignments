package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {

        Map<String, String> result = new LinkedHashMap<String, String>();

        for (Map.Entry<String, Object> entry : data1.entrySet()) {
            if (!data2.containsKey(entry.getKey())) {
                result.put(entry.getKey(), "deleted");
            } else {
                for (Map.Entry<String, Object> entry2 : data2.entrySet()) {
                    if (entry.equals(entry2)) {
                        result.put(entry.getKey(), "unchanged");
                    } else if (entry.getKey().equals(entry2.getKey()) && !entry.getValue().equals(entry2.getValue())) {
                        result.put(entry.getKey(), "changed");
                    } else if (!data1.containsKey(entry2.getKey())) {
                        result.put(entry2.getKey(), "added");
                    }
                }
            }
        }
        Map<String, String> sortedMap = new TreeMap<>(result);
        return sortedMap;
    }
}
//END
