package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        String lowerSymbols = symbols.toLowerCase();
        List<String> listSymbols = new ArrayList<String>(Arrays.asList(lowerSymbols.split("")));

        String lowerWord = word.toLowerCase();
        String[] arrayWord = lowerWord.split("");

        for (var i = 0; i < arrayWord.length; i++) {
            if (!listSymbols.contains(arrayWord[i])) {
                return false;
            } else if (listSymbols.contains(arrayWord[i])) {
                listSymbols.remove(arrayWord[i]);
            }
        }
        return true;
    }
}
//END
