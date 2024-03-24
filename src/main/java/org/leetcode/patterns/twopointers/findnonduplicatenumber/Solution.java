package org.leetcode.patterns.twopointers.findnonduplicatenumber;

/**
 * Move all the unique number instances at the beginning of the array and after moving return the length of the subarray that has no duplicate in it.
 * r1:Given an array of sorted numbers, move all non-duplicate number instances at the beginning of the array in-place.
 * r2:The relative order of the elements should be kept the same, you should not use any extra space so that the solution has constant space complexity i.e, O(1).
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 */
public class Solution {
    public static int remove(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int noDuplicateIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[noDuplicateIndex] = arr[i];
                noDuplicateIndex++;
            }
        }
        return  noDuplicateIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println(Solution.remove(arr));

        arr = new int[]{2, 2, 3, 3, 6, 9, 9};
        System.out.println(Solution.remove(arr));

        arr = new int[]{2, 2, 2, 2, 2, 9, 9};
        System.out.println(Solution.remove(arr));

        arr = new int[]{2, 2, 2, 2, 2, 2, 0};
        System.out.println(Solution.remove(arr));

        arr = new int[]{10, 2, 2, 2, 2, 2, 0};
        System.out.println(Solution.remove(arr));
    }
}
