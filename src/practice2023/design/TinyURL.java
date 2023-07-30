package practice2023.design;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 *
 *
 */
public class TinyURL {
    public static final String SRC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final String TINY_URL_BASE = "http://tinyurl.com/";
    public static final int TINY_URL_LEN = 6;
    Map<String, String> longToTiny;
    Map<String, String> tinyToLong;

    public TinyURL() {
        longToTiny = new HashMap<>();
        tinyToLong = new HashMap<>();
    }

    public static String getCode() {
        char[] encoded = new char[TINY_URL_LEN];
        int multiplier = SRC.length();
        for (int i = 0; i < TINY_URL_LEN; i++) {
            encoded[i] = SRC.charAt((int) Math.random() * multiplier);
        }
        String mapped = TINY_URL_BASE + String.valueOf(encoded);
        return mapped;
    }

    public String encode(String longUrl) {
        if (longUrl == null || longUrl.isBlank()) {
            return null;
        }
        if (longToTiny.containsKey(longUrl)) {
            return longToTiny.get(longUrl);
        }
        String mapped = getCode();
        longToTiny.put(longUrl, mapped);
        tinyToLong.put(mapped, longUrl);
        return mapped;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyToLong.get(shortUrl);
    }
}
