package org.leetcode.SlidingWindow.LongestSubstringwithKDistinctCharacters;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of positive numbers and a positive number 'k,' find the maximum sum of any contiguous subarray of size 'k'.
 *
 */
public class Solution {

    public static int findLength(String str, int k) {
        int maxLength = 0;
        int windowStart = 0, numUniqueChars;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            //todo: it's better to use hash map.
            numUniqueChars = calculateLength(str.substring(windowStart, windowEnd));
            while (numUniqueChars > k) {
                windowStart++;
                numUniqueChars = calculateLength(str.substring(windowStart, windowEnd));
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart);
        }

        return maxLength;
    }

    private static int calculateLength(String str) {
        List<Character> uniqueChars = new ArrayList<>();
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (!uniqueChars.contains(c)) {
                uniqueChars.add(c);
            }
        }
        return uniqueChars.size();
    }

    public static void main(String[] args) {
        String str = "araaci";
        int length = findLength(str, 2);
        System.out.println(length == 4);

        length = findLength(str, 1);
        System.out.println(length == 2);

        str = "cbbebi";
        length = findLength(str, 3);
        System.out.println(length == 5);
    }
}
