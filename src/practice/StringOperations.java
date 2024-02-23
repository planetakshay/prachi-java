package practice;

import java.util.*;
import java.util.List;

public class StringOperations {

    private static final char l_paren = '(';
    private static final char r_paren = ')';
    private static final char l_brace = '{';
    private static final char r_brace = '}';
    private static final char l_bracket = '[';
    private static final char r_bracket = ']';

    public static void main(String args[]) {

        StringOperations stringOps = new StringOperations();

        /* System.out.println(stringOps.countOccurenceRecursion("prachiakshay", 'a'));

        System.out.println(stringOps.countOccurrenceNoRecursion("prachiakshay", 'a'));

        System.out.println(stringOps.isAnagram("prachi", "ihcarp"));

        System.out.println("First Non Repeated Character: " + stringOps.firstNonRepeatedCharacter("above"));

        System.out.println("Its a number: " + stringOps.isNumeric("12345.3"));
        System.out.println("Its a number: " + stringOps.isNumeric("12345"));
        System.out.println("Its a number: " + stringOps.isNumeric("-12345"));
        System.out.println("Its a number: " + stringOps.isNumeric("-12345.399977"));
        System.out.println("Its a number: " + stringOps.isNumeric("sdfsdsfa"));

        System.out.println("AAAAAAA: " + stringOps.countCharacters("AAAAAAA"));

        System.out.println("AAABBBCCCDDD: " + stringOps.countCharacters("AAABBBCCCDDD"));

        System.out.println("ABCDE: " + stringOps.countCharacters("ABCDE"));

        System.out.println("AABBCCDDE: " + stringOps.countCharacters("AABBCCDDE"));

        System.out.println("Is racecar palindrome? " + stringOps.isPalindrome("racecar"));

        System.out.println("Is test palindrome? " + stringOps.isPalindrome("test"));

        List<String> input = new ArrayList<String>();

        input.add("10");
        input.add("4");
        input.add("6");
        input.add("+");
        input.add("*");
        input.add("3");
        input.add("-");

        System.out.println("10 4 6 + * 3 - :" + stringOps.compute(input));

        System.out.println("Longest substring with unique characters: " + stringOps.longestSubOfUniqueCharacters("SAMARTH"));

        System.out.println("Longest substring with unique characters: " + stringOps.longestSubOfUniqueCharacters("SAMARTHAKSHAYDEODHAR"));

        System.out.println("Longest substring with unique characters: " + stringOps.longestSubOfUniqueCharacters("PRACHIDEODHAR"));

        System.out.println("Longest substring with unique characters: " + stringOps.longestSubOfUniqueCharacters("a123a45a6"));

        System.out.println(stringOps.replaceUsWithThem("It usually rains when the bus comes to us"));
        System.out.println(stringOps.isBalancedParantheses("((((())))"));

        System.out.println(stringOps.isBalancedParantheses("({[]})(([]))((({{{{}}}})))"));

        System.out.println(stringOps.isBalancedParantheses("a(b(c{d[e(f(g)h)i]j}k)l)m"));

        System.out.println(stringOps.isBalancedParantheses("(())aa(({[aa(a(yyy)b)bb)])}bb{}[]"));

        System.out.println(stringOps.isBalancedParantheses("]")); */
        String paran = "()())()";
        // paran = ")(())((((()(";
        // paran = ")(())((((()()))()()(()))";
        paran = "((()((s((((()";
        long start = System.currentTimeMillis();
        stringOps.removeInvalidParentheses(paran, new HashSet<>(), minRemovals(paran));
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
        //removeInvalidParanthesisBFS(paran);
        String[] words = new String[] {"abba","baba","bbaa","cd","cd"};
        stringOps.removeAllAnagrams(words);
    }

    // case insensitive comparison.

    public int countOccurrenceNoRecursion(String s, char c) {

        if (s != null) {

            int occurrences = 0;

            int index = 0;

            while (index < s.length()) {

                if (s.charAt(index) == c) {

                    occurrences++;
                }

                index++;
            }

            return occurrences;
        }
        return 0;
    }

    public int countOccurenceRecursion(String s, char c) {

        if (s.length() == 1) {

            if (s.charAt(0) == c) {

                return 1;
            } else {

                return 0;
            }
        }

        if (s.charAt(0) == c) {

            return 1 + countOccurenceRecursion(s.substring(1), c);
        } else {

            return 0 + countOccurenceRecursion(s.substring(1), c);
        }
    }

    /**
     * LinkedIn phone screen (Year 2011)
     *
     * @param given
     * @return
     */
    public boolean isNumeric(String given) {

        // Regular expression for number strings - (\\+|-)?([0-9]+(\\.[0-9]+))
        // An alternative regular expression - "[-+]?\\d+(\\.\\d+)?"
        // Refer this website has many different ways of solving this problem. -
        // http://rosettacode.org/wiki/Determine_if_a_string_is_numeric#Java

        String // pattern = "(\\+|-)?([0-9]+((\\.[0-9]+)?))";
                pattern = "[-+]?\\d+(\\.\\d+)?";
        return given.matches(pattern);
    }

    /**
     * O(NlogN) time complexity
     * O(1) space complexity.
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean isAnagram(String str1, String str2) {
        char[] charSequenceStr1 = str1.toCharArray();
        char[] charSequenceStr2 = str2.toCharArray();
        if (charSequenceStr1.length != charSequenceStr2.length) {
            return false;
        }
        Arrays.sort(charSequenceStr1);
        Arrays.sort(charSequenceStr2);
        return Arrays.equals(charSequenceStr1, charSequenceStr2);
    }
    /**
     * O(N) time complexity
     * O(N) space complexity.
     *
     * When your input has unicode characters instead of ASCII
     * use HashMap for storing frequencies of characters.
     * Using a huge continuous array will be extremely terrible
     * as it could lead to almost million characters.
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramEfficient(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        // only lowercase english alphabets.
        int[] frequency = new int[26];
        int len = s.length();

        for(int i=0;i<len;i++) {
            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }

        for(int freq : frequency) {
            if(freq != 0) {
                return false;
            }
        }
        return true;
    }
    public List<String> removeAllAnagrams(String[] words) {
        Map<String, List<String>> allAnagrams = new HashMap<>();
        for(int i=0;i<words.length;i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> temp = allAnagrams.getOrDefault(key, new ArrayList<>());
            temp.add(word);
            allAnagrams.put(key, temp);
        }
        List<String> noAnagrams = new ArrayList<>();
        for(String key : allAnagrams.keySet()) {
            noAnagrams.add(allAnagrams.get(key).get(0));
        }
        return noAnagrams;
    }

    /**
     * https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/description/
     * @param words
     * @return
     */
    public List<String> removeAdjacentAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        result.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!isAnagram(words[i], words[i - 1])) {
                result.add(words[i]);
            }
        }

        return result;
    }

    /**
     * PayPal on-site
     *
     * @param str
     * @return
     */
    public char firstNonRepeatedCharacter(String str) {
        Map<Character, Integer> charFrequency = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            int frequency = 0;
            char c = str.charAt(i);
            if (charFrequency.containsKey(c)) {
                frequency = charFrequency.get(c);
            }
            charFrequency.put(c, ++frequency);
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charFrequency.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }

    /**
     * HP - ArcSight on-site
     *
     * @param input
     * @return
     */
    public String countCharacters(String input) {

        StringBuilder output = new StringBuilder();

        String subStr = "";

        int count = 1;

        if (input == null || input.isEmpty()) {

            return input;
        }

        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i) == input.charAt(i - 1)) {

                count++;
            } else {

                subStr = "" + count + input.charAt(i - 1);

                output.append(subStr);

                count = 1;
            }
        }

        output.append("" + count + input.charAt(input.length() - 1));

        return output.toString();
    }

    /**
     * This was asked in Amazon Phone Screen.(Year 2013). Kaboodle on-site (Year
     * 2007)
     *
     * @param str
     * @return
     */
    public boolean isPalindrome(String str) {

        if (str == null || str.isEmpty()) {

            return false;
        }

        char[] array = str.toCharArray();

        int lastIndex = str.length() - 1;

        for (int i = 0; i <= lastIndex / 2; i++) {

            if (array[i] != array[lastIndex - i]) {

                return false;
            }
        }

        return true;
    }

    /**
     * I asked this question to a candidate interviewing with EA.
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isRotation(String s1, String s2) {

        if (s1 == null || s2 == null) {

            return false;
        }
        if (s1.length() != s2.length()) {

            return false;
        }
        String s1s1 = s1 + s1;
        return s1s1.contains(s2.subSequence(0, s2.length()));
    }

    /**
     * Asked in ProofPoint interview - by Shalaka Sindkar
     * Postfix expressions using stack.
     * <p>
     * Also known as Reverse Polish Notation.
     *
     * @param str
     * @return
     */
    public Integer compute(List<String> str) {
        Stack<Integer> stack = new Stack<Integer>();
        if (str == null || str.isEmpty()) {
            return null;
        }
        for (String temp : str) {
            try {
                Integer number = Integer.parseInt(temp);
                if (number != null) {
                    stack.push(number);
                }
            } catch (NumberFormatException e) {
                if (stack.size() >= 2) {
                    int second = stack.pop();
                    int first = stack.pop();
                    Integer result = calculate(first, second, temp.charAt(0));
                    stack.push(result);
                }
            }
        }
        if (stack.size() == 1) {
            return stack.pop();
        }
        return null;
    }

    public Integer calculate(int first, int second, char ch) {
        Integer result = Integer.MIN_VALUE;
        switch (ch) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            case '/':
                result = first / second;
                break;
            default:
                result = null;
        }
        return result;
    }

    /**
     * Find the longest substring having unique characters in a string Amazon
     * on-site.
     *
     * @param str
     * @return
     */
    public String longestSubOfUniqueCharacters(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        Set<Character> characters = new HashSet<Character>();
        StringBuilder builder = new StringBuilder();
        String longestSoFar = "", potentialLongest = "";
        for (char c : str.toCharArray()) {
            if (!characters.contains(c)) {
                builder.append(c);
                characters.add(c);
                if (builder.toString().length() > longestSoFar.length()) {
                    longestSoFar = builder.toString();
                }
            } else {
                potentialLongest = builder.toString();
                if (potentialLongest.length() > longestSoFar.length()) {
                    longestSoFar = potentialLongest;
                }
                builder = new StringBuilder(potentialLongest.substring(potentialLongest.indexOf(c) + 1));
                builder.append(c);
            }
        }
        return longestSoFar;
    }

    /**
     * Read it from Career cups from Yahoo interview section.
     *
     * @param str
     * @return
     */
    public String replaceUsWithThem(String str) {

        String abc = str;

        abc = abc.replaceAll("(^| )us($| )", " them ").trim();

        return abc;
    }

    public static boolean isBalancedParantheses(String paranthesis) {

        Stack<Character> stack = new Stack<Character>();

        char[] paranArray = paranthesis.toCharArray();

        for (char in : paranArray) {

            switch (in) {
                case l_paren:
                    stack.push(in);
                    break;
                case l_brace:
                    stack.push(in);
                    break;
                case l_bracket:
                    stack.push(in);
                    break;
                case r_paren:
                    if (stack.size() > 0) {

                        if (stack.pop() != l_paren) return false;
                    } else {
                        return false;
                    }
                    break;
                case r_brace:
                    if (stack.size() > 0) {

                        if (stack.pop() != l_brace) return false;
                    } else {
                        return false;
                    }
                    break;
                case r_bracket:
                    if (stack.size() > 0) {

                        if (stack.pop() != l_bracket) return false;
                    } else {
                        return false;
                    }
                    break;
                default:
            }
        }
        return stack.isEmpty();
    }

    public static void removeInvalidParentheses(String input, HashSet<String> output, int minRemovalAllowed) {
        if (minRemovalAllowed == 0) {
            int minNow = minRemovals(input);
            if (minNow == 0) {
                if (!output.contains(input)) {
                    System.out.println(input);
                    output.add(input);
                }
            }
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            String left = input.substring(0, i);
            String right = input.substring(i + 1);
            removeInvalidParentheses(left + right, output, minRemovalAllowed - 1);
        }
    }

    public static int minRemovals(String paranthesis) {
        Stack<Character> stack = new Stack<Character>();
        char[] paranArray = paranthesis.toCharArray();
        for (int i = 0; i < paranArray.length; i++) {
            char in = paranArray[i];
            switch (in) {
                case l_paren:
                    stack.push(in);
                    break;
                case l_brace:
                    stack.push(in);
                    break;
                case l_bracket:
                    stack.push(in);
                    break;
                case r_paren:
                    if (stack.size() == 0 || stack.peek() == r_paren) {
                        stack.push(in);
                    } else if (stack.peek() == l_paren) {
                        stack.pop();
                    }
                    break;
                case r_brace:
                    if (stack.size() == 0 || stack.peek() == r_brace) {
                        stack.push(in);
                    } else if (stack.peek() == l_brace) {
                        stack.pop();
                    }
                    break;
                case r_bracket:
                    if (stack.size() == 0 || stack.peek() == r_bracket) {
                        stack.push(in);
                    } else if (stack.peek() == l_bracket) {
                        stack.pop();
                    }
                    break;
                default:
            }
        }
        return stack.size();
    }

    public static int minRemovalsNoSwitch(String paranthesis) {
        Stack<Character> stack = new Stack<Character>();
        char[] paranArray = paranthesis.toCharArray();
        for (int i = 0; i < paranArray.length; i++) {
            char in = paranArray[i];
            if (in == l_paren) {
                stack.push(in);
            } else if (in == r_paren) {
                if (stack.size() == 0) {
                    stack.push(in);
                } else if (stack.peek() == r_paren) {
                    stack.push(in);
                } else if (stack.peek() == l_paren) {
                    stack.pop();
                }
            }
        }
        return stack.size();
    }

    public static List<String> removeInvalidParanthesisBFS(String input) {
        if(input.isBlank()) {
            return new ArrayList<>();
        }

        Set<String> balancedParanString = new HashSet<>();
        Queue<String> subStrings = new LinkedList<>();
        String removedParan = "";
        boolean level = false;

        subStrings.add(input);
        balancedParanString.add(input);

        while (!subStrings.isEmpty()) {
            String curr = subStrings.peek();
            subStrings.remove();

            if (isBalancedParan(curr)) {
                System.out.println(curr);
                level = true;
            }
            if (level) {
                continue;
            }
            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) == '(' || curr.charAt(i) == ')') {
                    removedParan = curr.substring(0, i) + curr.substring(i + 1);
                    if (!balancedParanString.contains(removedParan)) {
                        subStrings.add(removedParan);
                        balancedParanString.add(removedParan);
                    }
                }
            }
        }

        return balancedParanString.stream().toList();
    }

    static boolean isBalancedParan(String input) {
        int balancedCount = 0;

        for(int i = 0;i<input.length();i++) {
            if(input.charAt(i) == '(') {
                balancedCount++;
            }
            else if(input.charAt(i) == ')') {
                balancedCount--;
            }
            if(balancedCount < 0) {
                return false;
            }
        }

        return balancedCount == 0;
    }

    /**
     * No of words in a string with camelcase letters.
     * @param s
     * @return
     */
    public static int camelcase(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int count = 1;
        for(int i=0; i < len; i++) {
            if(!Character.isLowerCase(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }

}