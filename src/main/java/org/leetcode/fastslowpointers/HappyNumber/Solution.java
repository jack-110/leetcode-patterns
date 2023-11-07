package org.leetcode.fastslowpointers.HappyNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to the number 1.
 *
 */
public class Solution {

    public static boolean find(int num) {
        List<Integer> sumList = new ArrayList<>();
        int sum = sumOfDigitsSquare(num);
        sumList.add(sum);
        while (sum != 1) {
            sum = sumOfDigitsSquare(sum);
            if (sumList.contains(sum)) {
                return false;
            }
            sumList.add(sum);
        }
        return true;
    }

    private static int sumOfDigitsSquare(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            num = num / 10;
            sum = sum + rem * rem;
        }
        return sum;
    }

    public static void main(String[] args) {
        assert find(23);
        assert !find(12);
        assert find(1);
    }
}

