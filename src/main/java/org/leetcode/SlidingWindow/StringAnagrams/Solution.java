package org.leetcode.SlidingWindow.StringAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<Character, Integer> charFrequencyMap = convertCharMap(pattern);
        int windowStart = 0, windowSize = pattern.length(), matchedCount = 0;
        for (int windowEnd = 0; windowEnd < pattern.length(); windowEnd++) {
            char c = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(c)) {
                charFrequencyMap.replace(c, charFrequencyMap.get(c) - 1);
                if (charFrequencyMap.get(c) == 0) {
                    matchedCount++;
                }
            }

            if (matchedCount == charFrequencyMap.size()) {
                resultIndices.add(windowStart);
            }

            if (windowEnd - windowStart + 1 >= windowSize)  {
                if (charFrequencyMap.containsKey(str.charAt(windowStart))) {
                    if (charFrequencyMap.get(str.charAt(windowStart)) == 0) {
                        matchedCount--;
                    }
                    charFrequencyMap.replace(str.charAt(windowStart), charFrequencyMap.get(str.charAt(windowStart)) + 1);
                }
                windowStart++;
            }
        }
        return resultIndices;
    }

    private static Map<Character, Integer> convertCharMap(String str) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character chr : str.toCharArray()) {
            charMap.put(chr, charMap.getOrDefault(chr, 0) + 1);
        }
        return charMap;
    }
}
