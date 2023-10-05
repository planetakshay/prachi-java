package practice2023.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagicDictionary {
    Map<Integer, List<String>> possibilities;

    public MagicDictionary(String[] dictionary) {
        buildDict(dictionary);
    }

    public static void main(String[] args) {
        String[] dictionary = new String[]{"duck", "goose", "gander"};
        MagicDictionary magicDictionary = new MagicDictionary(dictionary);
        System.out.println("Corrected spelling for gonder: " + magicDictionary.search("gonder"));
        System.out.println("Corrected spelling for gamder: " + magicDictionary.search("gamder"));
        System.out.println("Corrected spelling for gnnder: " + magicDictionary.search("gnnder"));
        System.out.println("Corrected spelling for garden: " + magicDictionary.search("garden"));
    }

    public void buildDict(String[] dictionary) {
        possibilities = new HashMap<>();
        if (dictionary != null) {
            for (String word : dictionary) {
                int len = word.length();
                possibilities.computeIfAbsent(len, list -> new ArrayList<>()).add(word);
            }
        }
    }

    public boolean search(String searchWord) {
        if (searchWord == null || searchWord.length() == 0) {
            return false;
        }
        int len = searchWord.length();
        if (!possibilities.containsKey(len)) {
            return false;
        }
        List<String> suggestions = possibilities.get(len);
        for (String word : suggestions) {
            int deviation = 0;
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    if (++deviation > 1) {
                        break;
                    }
                }
            }
            if (deviation == 1) {
                return true;
            }
        }
        return false;
    }
}