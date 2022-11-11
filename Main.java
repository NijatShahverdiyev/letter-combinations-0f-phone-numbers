import java.util.ArrayList;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        List<String[]> letterArr = getLetterList(digits);
        return recursion(combinations, letterArr, 0, "");
    }


    public static List<String> recursion(List<String> combinations, List<String[]> letterArr, int position, String str) {
        if (position == letterArr.size())
            combinations.add(str);
        else {
            String[] letters = letterArr.get(position);
            for (String currentLetter : letters) {
                recursion(combinations, letterArr, position + 1, str + currentLetter);
            }
        }
        return combinations;
    }

    public static List<String[]> getLetterList(String digits){
        Map<String, String[]> letters = Map.of(
                "2", new String[]{"a", "b", "c"},
                "3", new String[]{"d", "e", "f"},
                "4", new String[]{"g", "h", "i"},
                "5", new String[]{"j", "k", "l"},
                "6", new String[]{"m", "n", "o"},
                "7", new String[]{"p", "q", "r", "s"},
                "8", new String[]{"t", "u", "v"},
                "9", new String[]{"w", "x", "y", "z"});

        List<String[]> letterList = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            letterList.add(letters.get(String.valueOf(digits.charAt(i))));
        }
        return letterList;
    }
}
