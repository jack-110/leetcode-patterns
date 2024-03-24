package org.leetcode.patterns.twopointers.tripletsumtoclosest;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet.
 * If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 *
 */
public class Solution {
    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int sum = 0;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int tempSum = searchPair(i + 1, arr, targetSum - arr[i]) + arr[i];
            if (Math.abs(tempSum - targetSum) < distance) {
                sum = tempSum;
                distance = Math.abs(tempSum - targetSum);
            } else if (Math.abs(tempSum - targetSum) == distance) {
                if (tempSum < sum) {
                    sum = tempSum;
                }
            }
        }
        return sum;
    }

    private static int searchPair(int start, int[] arr, int targetSum) {
        int sum = 0;
        int end = arr.length - 1;
        int distance = Integer.MAX_VALUE;
        while (start < end) {
            if (arr[start] + arr[end] < targetSum) {
                if (Math.abs(arr[start] + arr[end] - targetSum) < distance) {
                    sum = arr[start] + arr[end];
                    distance = Math.abs(arr[start] + arr[end] - targetSum);
                }
                start++;
            } else if (arr[start] + arr[end] > targetSum) {
                if (Math.abs(arr[start] + arr[end] - targetSum) < distance) {
                    sum = arr[start] + arr[end];
                    distance = Math.abs(arr[start] + arr[end] - targetSum);
                }
                end--;
            } else {
                //todo: return immediately when it equals.
                start++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 2, 6};
        int res = searchTriplet(arr, 5);
        System.out.println(res);

        arr = new int[]{-3, -1, 1, 2};
        res = searchTriplet(arr, 1);
        System.out.println(res);
    }
}
