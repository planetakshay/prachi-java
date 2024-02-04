package practice2023.strings;

import java.util.*;
import java.util.stream.Collectors;

public class HateSpeechDetector {
    public static Set<String> hateWords;

    static {
        hateWords = new HashSet<>() {{
            add("hate");
            add("kill");
            add("punch");
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
        String sample = "I hate eating meat. I think all the meat eaters in the world should give their food choices a second thought.\n";
        System.out.println("The post is " + String.format("%.2f", percent()) + "% hateful.");
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

    public static double percent() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your post: ");
        String speech = in.nextLine();
        if (speech == null || speech.isBlank()) {
            return 0;
        }
        String[] words = speech.split("\\s+");
        long badWords = Arrays.stream(words).filter(hateWords::contains).collect(Collectors.counting());
        int total = words.length;
        // System.out.println("No of words: " + total);
        // System.out.println("Bad words: " + badWords);
        return ((double) badWords / total) * 100;
    }

    public void determineHateSpeech() {
        System.out.println("Is a hateful sentence: " + isHateSpeech("It is a winter night. But its not that cold outside today."));
        System.out.println("Is a hateful sentence: " + isHateSpeech("Please, Don't use the word stupid. It is not nice. You will hurt their feelings."));
        System.out.println("Is a hateful sentence: " + isHateSpeech("random strings sdfasdfa  safsdf adf sdf adsf adsfasd fdsfsadf adsf df adf asdfasdfadsferiewjirjj. Is this string long enough yet?"));
        System.out.println("Is a hateful sentence: " + isHateSpeech("    "));
    }
}