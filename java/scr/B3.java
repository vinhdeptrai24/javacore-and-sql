package scr;

import java.util.LinkedHashMap;
import java.util.Map;

public class B3 {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> map = new LinkedHashMap<>();
        if (text == null||text.isBlank()) return map;

        String clean = text.toLowerCase().replaceAll("[.,!?]", "").trim();
        if (clean.isEmpty()) return map;

        for (String word : clean.split("\\s+")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    static void main(String[] args) {
        System.out.println(countWords("Java java, SQL! java"));
        System.out.println(countWords("b a b"));
        System.out.println(countWords("   "));
        System.out.println(countWords(null));
        System.out.println(countWords("...,!?"));
        System.out.println(countWords("  Hi   HI hi.  "));
    }
}
