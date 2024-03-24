package org.leetcode.patterns.SlidingWindow.SmallestSubarrayWithaGreaterSum;

/**
 * Given an array of positive numbers and a positive number 'k,' find the maximum sum of any contiguous subarray of size 'k'.
 *
 */
public class Solution {
    public static int findMinSubArray(int S, int[] arr) {
        int windowLength = Integer.MAX_VALUE;
        int windowStart = 0, windowSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while (windowSum >= S) {
                windowLength = Math.min(windowLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return windowLength;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 2, 3, 2};
        int minSubArray = findMinSubArray(7, arr);
        System.out.println(minSubArray == 2);

        arr = new int[]{2, 1, 5, 2, 8};
        minSubArray = findMinSubArray(7, arr);
        System.out.println(minSubArray == 1);

        arr = new int[]{3, 4, 1, 1, 6};
        minSubArray = findMinSubArray(8, arr);
        System.out.println(minSubArray == 3);
    }
}
