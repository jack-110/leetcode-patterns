package org.leetcode.SlidingWindow.MaximumSumSubarrayofSizeK;

/**
 * Given an array of positive numbers and a positive number 'k,' find the maximum sum of any contiguous subarray of size 'k'.
 *
 */
public class Solution {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 1, 3, 2};
        int max = findMaxSumSubArray(3, arr);
        System.out.println(max);

        arr = new int[]{2, 3, 4, 1, 5};
        max = findMaxSumSubArray(2, arr);
        System.out.println(max);
    }
}
