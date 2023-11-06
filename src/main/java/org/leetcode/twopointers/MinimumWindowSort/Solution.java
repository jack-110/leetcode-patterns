package org.leetcode.twopointers.MinimumWindowSort;

/**
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 *
 */
public class Solution {

    public static int sort(int[] arr) {
        int front = 0, end = arr.length - 1;
        while (front < arr.length - 1 && end > 0) {
            if (arr[front] > arr[front + 1] && arr[end] < arr[end - 1]) {
                break;
            }
            if (arr[front] <= arr[front + 1]) {
                front++;
            }
            if (arr[end] >= arr[end - 1]) {
                end--;
            }
        }

        if (front > end) { //the array has already been sorted
            return 0;
        }

        return calculateLength(arr, front , end);
    }

    private static int calculateLength(int[] arr, int start, int end) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        //todo: could be simplified based on the sort property
        for (int i = start - 1; i >= 0; i--) {
            if (arr[i] >= min) {
                start--;
            }
        }
        for (int j = end + 1; j < arr.length; j++) {
            if (arr[j] <= max) {
                end++;
            }
        }

        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 3, 7, 10, 9, 12};
        int sort = sort(arr);
        System.out.println(sort);

        arr = new int[]{1, 3, 2, 0, -1, 7, 10};
        sort = sort(arr);
        System.out.println(sort);

        arr = new int[]{1, 3, 5, 7};
        sort = sort(arr);
        System.out.println(sort);

        arr = new int[]{1, 3, 5, 7, 4, 9, 10};
        sort = sort(arr);
        System.out.println(sort);

        arr = new int[]{7, 5, 3, 1};
        sort = sort(arr);
        System.out.println(sort);
    }
}