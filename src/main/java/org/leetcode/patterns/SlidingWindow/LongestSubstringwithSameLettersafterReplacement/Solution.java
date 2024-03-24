package org.leetcode.patterns.SlidingWindow.LongestSubstringwithSameLettersafterReplacement;

import java.util.HashMap;
import java.util.Set;

public class Solution {

    public static int findLength(String str, int k) {
        //todo: optimization
        int maxLength = 0;
        int windowStart = 0, windowSize = 0;
        char c = str.charAt(windowStart);
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            charMap.put(str.charAt(windowEnd), charMap.getOrDefault(str.charAt(windowEnd), 0) + 1);
            if (str.charAt(windowEnd) != c) {
                windowSize++;
            }
            while (windowSize > k) {
                charMap.replace(str.charAt(windowStart), charMap.get(str.charAt(windowStart)) - 1);
                windowStart++;
                c = str.charAt(windowStart);
                windowSize = numOfReplacement(charMap, c);
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    private static int numOfReplacement(HashMap<Character, Integer> map, char c) {
        int result = 0;
        Set<Character> characterSet = map.keySet();
        for (Character character : characterSet) {
            if (c != character) {
                result += map.get(character);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "abccde";
        System.out.println(findLength(str, 1) == 3);

        str = "abbcb";
        System.out.println(findLength(str, 1) == 4);

        str = "aabccbb";
        System.out.println(findLength(str, 2) == 5);
    }
}
