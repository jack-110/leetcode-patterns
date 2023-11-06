package org.leetcode.twopointers.squaringsortedarray;

import java.util.Arrays;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 * Example1
 *  Input: [-2, -1, 0, 2, 3]
 *  Output: [0, 1, 4, 4, 9]
 * Example2
 *  Input: [-3, -1, 0, 1, 2]
 *  Output: [0, 1, 1, 4, 9]
 */
public class Solution {

    public static int[] createSquares(int[] arr) {
        int index = arr.length - 1;
        int[] squares = new int[arr.length];
        int p1 = 0, p2 = arr.length - 1;
        while (p1 <= p2) {
            int squareFrond = arr[p1] * arr[p1];
            int squareBack = arr[p2] * arr[p2];
            if (squareFrond > squareBack) {
                squares[index--] = squareFrond;
                p1++;
            } else {
                squares[index--] = squareBack;
                p2--;
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, -1, 0, 2, 3};
        System.out.println(Arrays.toString(Solution.createSquares(arr)));

        arr = new int[]{-3, -1, 0, 1, 2};
        System.out.println(Arrays.toString(Solution.createSquares(arr)));

        arr = new int[]{-3, -2, -1};
        System.out.println(Arrays.toString(Solution.createSquares(arr)));

        arr = new int[]{2, 3, 5};
        System.out.println(Arrays.toString(Solution.createSquares(arr)));
    }
}
