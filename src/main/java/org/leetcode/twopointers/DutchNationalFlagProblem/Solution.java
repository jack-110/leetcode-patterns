package org.leetcode.twopointers.DutchNationalFlagProblem;

import java.util.Arrays;

/**
 * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 *
 */
public class Solution {
    public static void sort(int[] arr) {
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high;) {
            if (arr[i] == 0) {
                swap(arr, low, i);
                i++;   // case: arr[i] == arr[low] == 0
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, high, i);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

   public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));

       arr = new int[] { 2, 2, 0, 1, 2, 0 };
       sort(arr);
       System.out.println(Arrays.toString(arr));
   }
}