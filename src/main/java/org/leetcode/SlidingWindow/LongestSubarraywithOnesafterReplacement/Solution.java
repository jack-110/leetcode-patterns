package org.leetcode.SlidingWindow.LongestSubarraywithOnesafterReplacement;

public class Solution {

    public static int findLength(int[] arr, int k) {
        int maxLength = 0;
        int windowStart = 0, maxZeroCount = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 0) {
                maxZeroCount++;
            }
            if (maxZeroCount > k) {
                if (arr[windowStart] == 0) {
                    maxZeroCount--;
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        System.out.println(findLength(arr, 2) == 6);

        arr = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        System.out.println(findLength(arr, 3) == 9);
    }
}
