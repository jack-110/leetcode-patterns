package org.leetcode.patterns.fastslowpointers.CycleinaCircularArray;


/**
 * Suppose the array contains a number ‘M’ at a particular index. Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices.
 *
 */
public class Solution {

    public static boolean loopExists(int[] arr) {
        int slow = slowNext(arr, 0), fast = fastNext(arr, 0);
        while (slow != fast) {
            slow = slowNext(arr, slow);
            if (slow >= arr.length) {
                slow = slow % arr.length;
            }

            fast = fastNext(arr, fast);
            if (fast >= arr.length) {
                fast = fast % arr.length;
            }
        }

        //both meet in the cycle
        int next = slowNext(arr, slow);
        boolean forward = slowNext(arr, slow) >= slow;
        do {
            if (forward) {
                if (next < slow) {
                    return false;
                }
            } else {
                if (next >= slow) {
                    return false;
                }
            }
            if (next >= arr.length) {
                next = next % arr.length;
            }
            slow = next;
            next = slowNext(arr, slow);
            if (next >= arr.length) {
                next = next % arr.length;
            }
        } while (next != fast);
        return true;
    }

    private static int slowNext(int[] arr, int current) {
        return current + arr[current];
    }

    private static int fastNext(int[] arr, int current) {
        int next = current + arr[current];
        next = next % arr.length;
        next = next + arr[next];
        return next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, -1, 2, 2};
        System.out.println(loopExists(arr));

        arr = new int[]{2, 1, -1, -2};
        System.out.println(loopExists(arr));
    }
}

