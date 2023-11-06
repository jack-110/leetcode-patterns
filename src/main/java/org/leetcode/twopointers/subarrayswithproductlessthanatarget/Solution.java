package org.leetcode.twopointers.subarrayswithproductlessthanatarget;

import java.util.*;

/**
 * Given an array with positive numbers and a positive target number, find all of its contiguous subarrays whose product is less than the target number.
 *
 */
public class Solution {

    public static List<List<Integer>> findSubArrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            List<Integer> subArray = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                product = product * arr[j];
                if (product >= target) {
                    break;
                }
                subArray.add(arr[j]);
                result.add(new ArrayList<>(subArray));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 10};
        List<List<Integer>> arrays = findSubArrays(arr, 30);
        System.out.println(arrays);
    }
}