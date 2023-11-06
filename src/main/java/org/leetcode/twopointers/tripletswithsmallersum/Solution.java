package org.leetcode.twopointers.tripletswithsmallersum;

import java.util.Arrays;

/**
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 *
 */
public class Solution {
    public static int searchTriplets(int[] arr, int targetSum) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int pairsCount = searchPair(i + 1, arr, targetSum - arr[i]);
            count = count + pairsCount;
        }
        return count;
    }

    private static int searchPair(int start, int[] arr, int targetSum) {
        int count = 0;
        int i = start, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] < targetSum) {
                count = count + j - i;
                i++;
            } else if (arr[i] + arr[j] >= targetSum) {
                j--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 2, 3};
        int triplets = searchTriplets(arr, 3);
        System.out.println(triplets);

        arr = new int[]{-1, 4, 2, 1, 3};
        triplets = searchTriplets(arr, 5);
        System.out.println(triplets);
    }
}
