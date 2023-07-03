package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.util.*;


// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> people) {
        List<Map<String, String>> mutablePeople = new ArrayList<>(people);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Collections.sort(mutablePeople, Comparator.comparing(man  -> LocalDate.parse(man.get("birthday"), formatter)));
        return mutablePeople.stream()
                .filter(man -> man.get("gender").equals("male"))
                .map(man -> man.get("name"))
                .collect(Collectors.toList());
    }
}
// END
