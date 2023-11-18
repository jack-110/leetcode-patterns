package org.leetcode.SlidingWindow.PermutationinaString;

import java.util.HashMap;

public class Solution {
    public static boolean findPermutation(String str, String pattern) {
        //todo: use sliding window
        int matched = 0;
        HashMap<Character, Integer> patternMap = convertMap(pattern);
        HashMap<Character, Integer> strMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!patternMap.containsKey(c) || strMap.getOrDefault(c, 0) >= patternMap.get(c)) {
                strMap.clear();
                matched = 0;
            } else {
                strMap.put(c, strMap.getOrDefault(c, 0) + 1);
                if (++matched == pattern.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static HashMap<Character, Integer> convertMap(String str) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: "
                + Solution.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: "
                + Solution.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: "
                + Solution.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: "
                + Solution.findPermutation("aaacb", "abc"));
    }
}
