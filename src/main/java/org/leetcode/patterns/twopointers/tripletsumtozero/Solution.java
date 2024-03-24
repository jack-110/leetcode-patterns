package org.leetcode.patterns.twopointers.tripletsumtozero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 *
 */
public class Solution {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            searchPair(-arr[i], arr, i + 1, triplets);
        }
        return triplets;
    }

    private static void searchPair(int target, int[] arr, int start, List<List<Integer>> result) {
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] > target) {
                end--;
            } else if (arr[start] + arr[end] < target) {
                start++;
            } else {
                result.add(Arrays.asList(-target, arr[start], arr[end]));
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-5, 2};
        List<List<Integer>> triplets = searchTriplets(arr);
        System.out.println(triplets);

        arr = new int[]{-5, 2, 1};
        triplets = searchTriplets(arr);
        System.out.println(triplets);

        arr = new int[]{-5, 2, 3};
        triplets = searchTriplets(arr);
        System.out.println(triplets);

        arr = new int[]{-3, 0, 1, 2, -1, 1, -2};
        triplets = searchTriplets(arr);
        System.out.println(triplets);

        arr = new int[]{-3, 0, 1, 2, -1, 1, -2, -3};
        triplets = searchTriplets(arr);
        System.out.println(triplets);

        arr = new int[]{-5, 2, -1, -2, 3};
        triplets = searchTriplets(arr);
        System.out.println(triplets);

        //todo: need to skip duplicates
        arr = new int[]{-5, 2, 2, -1, -2, 3, 3};
        triplets = searchTriplets(arr);
        System.out.println(triplets);
    }
}
