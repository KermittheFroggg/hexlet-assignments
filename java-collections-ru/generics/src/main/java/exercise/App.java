package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static <T> List<Map<String, String>> findWhere(List<T> books, T selection) {
        List<Map<String, String>> result = new ArrayList<>();
        Map<?, ?> selection2 = (Map) selection;
        for (T book : books) {
            Map<?, ?> book2 = (Map) book;
            int count = 0;
            for (Map.Entry<?, ?> entry : book2.entrySet()) {
                if (selection2.containsKey(entry.getKey())){
                    if (selection2.get(entry.getKey()).equals(entry.getValue())) {
                        count = count + 1;
                        if (count == selection2.size()) {
                            result.add((Map<String, String>) book);
                        }
                    }
                }
            }
        }
        return result;
    }
}
//END
