package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map getWordCount(String sentence) {
        String lowerSentence = sentence.toLowerCase();
        String[] arraySentence = lowerSentence.split(" ");
        Map<String, Integer> result = new HashMap<>();

        if (sentence.equals("")) {
            return result;
        }
        for (var i = 0; i < arraySentence.length; i++) {
            Integer count = 1;
            if (result.containsKey(arraySentence[i])) {
                Integer count2 = result.get(arraySentence[i]) + 1;
                result.put(arraySentence[i], count2);
            } else {
                result.put(arraySentence[i], count);
            }
        }
        return result;
    }

    public static String toString(Map numbersOfWord) {
        Map<String, Integer> numbersOfWord2 = numbersOfWord;
        if (numbersOfWord2.isEmpty()) {
            return "{}";
        }
        String result = "{";
        for (Map.Entry<String, Integer> word: numbersOfWord2.entrySet()) {
            result = result + "\n  " + word.getKey() + ": " + word.getValue();
        }
        return result + "\n}";
    }
}

//END
