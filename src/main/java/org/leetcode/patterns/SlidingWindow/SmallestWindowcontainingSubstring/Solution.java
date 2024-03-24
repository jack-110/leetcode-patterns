package org.leetcode.patterns.SlidingWindow.SmallestWindowcontainingSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static String findSubstring(String str, String pattern) {
        int minSize = Integer.MAX_VALUE, start = 0, end = 0;
        int windowStart = 0, matchedCount = 0;
        Map<Character, Integer> charaFrequencyMap = convertCharMap(pattern);
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char c = str.charAt(windowEnd);
            if (charaFrequencyMap.containsKey(c)) {
                //it could be less than zero
                charaFrequencyMap.replace(c, charaFrequencyMap.get(c) - 1);
                if (charaFrequencyMap.get(c) == 0) {
                    matchedCount++;
                }
            }

            while (matchedCount == charaFrequencyMap.size()) {
                int windowSize = windowEnd - windowStart + 1;
                if (windowSize <= minSize) {
                    start = windowStart;
                    end = windowEnd;
                    minSize = windowSize;
                }

                char leftChar = str.charAt(windowStart++);
                if (charaFrequencyMap.containsKey(leftChar)) {
                    charaFrequencyMap.replace(leftChar, charaFrequencyMap.get(leftChar) + 1);
                    if (charaFrequencyMap.get(leftChar) > 0) {
                        matchedCount--;
                    }
                }
            }
        }
        return str.substring(start, end + 1);
    }

    private static Map<Character, Integer> convertCharMap(String str) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character chr : str.toCharArray()) {
            charMap.put(chr, charMap.getOrDefault(chr, 0) + 1);
        }
        return charMap;
    }

    public static void main(String[] args) {
        String str = "abdbca";
        String pattern = "abc";
        String substring = findSubstring(str, pattern);
        System.out.println("bca".equals(findSubstring(str, pattern)));
    }
}
