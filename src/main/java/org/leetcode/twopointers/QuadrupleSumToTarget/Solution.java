package org.leetcode.twopointers.QuadrupleSumToTarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.
 *
 */
class Solution {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i + 1]) {
                continue;
            }
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j + 1]) {
                    continue;
                }
                searchPair(arr, i, j, target, quadruplets);
            }
        }
        return quadruplets;
    }

    private static void searchPair(int[] arr, int first, int second, int target, List<List<Integer>> quadruplets) {
        int front = second + 1, end = arr.length - 1;
        while (front < end) {
            if (arr[front] + arr[end] == target - arr[first] - arr[second]) {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[front], arr[end]));
                front++;
                end--;
                while (front < end && arr[front] == arr[front - 1]) {
                    front++;
                }
                while (front < end && arr[end] == arr[end + 1]) {
                    end--;
                }
            } else if (arr[front] + arr[end] < target - arr[first] - arr[second]) {
                front++;
            } else {
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 2, -1, 1, -3};
        List<List<Integer>> quadruplets = searchQuadruplets(arr, 1);
        System.out.println(quadruplets);

        arr = new int[]{2, 0, -1, 1, -2, 2};
        quadruplets = searchQuadruplets(arr, 2);
        System.out.println(quadruplets);

        arr = new int[]{2, 0, -1, 1, 1, 1, -2, 2, 2};
        quadruplets = searchQuadruplets(arr, 2);
        System.out.println(quadruplets);
    }
}
