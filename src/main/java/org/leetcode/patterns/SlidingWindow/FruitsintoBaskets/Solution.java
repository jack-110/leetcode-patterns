package org.leetcode.patterns.SlidingWindow.FruitsintoBaskets;

import java.util.HashMap;

public class Solution {

    public static int findLengthTest(char[] arr) {
        int maxLength = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            charMap.put(arr[windowEnd], charMap.getOrDefault(arr[windowEnd], 0) + 1);
            while (charMap.size() > 2) {
                charMap.replace(arr[windowStart], charMap.get(arr[windowStart]) - 1);
                if (charMap.get(arr[windowStart]) == 0) {
                    charMap.remove(arr[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        char[] arr = new char[]{'A', 'B', 'C', 'A', 'C'};
        System.out.println(findLengthTest(arr) == 3);

        arr = new char[]{'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(findLengthTest(arr) == 5);
    }
}
