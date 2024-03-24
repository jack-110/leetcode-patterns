package org.leetcode.patterns.twopointers.pairwithtargetsum;

/**
 * Given an array of numbers sorted in ascending order and a target sum, find a pair in the array whose sum is equal to the given target.
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 *
 */
public class Solution {

    public static int[] search(int[] array, int targetSum) {
        if (array == null || array.length < 2) {
            return new int[]{-1, -1};
        }

        int p1 = 0, p2 = array.length - 1;
        while (p1 < p2) {
            if (array[p1] + array[p2] == targetSum) {
                return new int[]{p1, p2};
            }

            if (array[p1] + array[p2] > targetSum) {
                p2--;
            } else if (array[p1] + array[p2] < targetSum) {
                p1++;
            }
        }

        return new int[]{-1, -1};
    }



    public static void main(String[] args) {
        //array length < 2

        //array length = 2

        //array length > 2

        //scale test, array length = 100000
    }
}
