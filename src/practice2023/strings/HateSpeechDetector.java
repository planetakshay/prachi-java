package practice2023.strings;

import java.util.HashSet;
import java.util.Set;

public class HateSpeechDetector {
    public static Set<String> hateWords;

    static {
        hateWords = new HashSet<>() {{
            add("fool");
            add("stupid");
            add("moron");
            add("arrogant");
            add("brat");
            add("mean");
            add("rude");
        }};
    }

    public static void main(String[] args) {
        System.out.println("Is a hateful sentence: " + isHateSpeech("It is a winter night. But its not that cold outside today."));
        System.out.println("Is a hateful sentence: " + isHateSpeech("Please, Don't use the word stupid. It is not nice. You will hurt their feelings."));
        System.out.println("Is a hateful sentence: " + isHateSpeech("random strings sdfasdfa  safsdf adf sdf adsf adsfasd fdsfsadf adsf df adf asdfasdfadsferiewjirjj. Is this string long enough yet?"));
        System.out.println("Is a hateful sentence: " + isHateSpeech("    "));
    }

    public static boolean isHateSpeech(String speech) {
        if (speech == null || speech.isBlank()) {
            return true;
        }
        if (speech.length() > 150) {
            return false;
        }
        return hateWords.stream().anyMatch(speech::contains);
    }
}