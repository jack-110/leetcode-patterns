package org.leetcode.CyclicSort.FindtheFirstKMissingPositiveNumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static List<Integer> findNumbers(int[] nums, int k) {
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num > 0 && num < nums.length && num != nums[num - 1]) {
                nums[i] = nums[num - 1];
                nums[num - 1] = num;
            } else {
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> extraNumbers = new HashSet<>();

        int j = 0;
        while (k > 0) {
            // search in the nums array
            if (j < nums.length) {
                if (nums[j] != j + 1) {
                    k--;
                    extraNumbers.add(nums[j]);
                    missingNumbers.add(j + 1);
                }
            } else {
                // search in extraNumbers
                if (!extraNumbers.contains(j + 1)) {
                    k--;
                    missingNumbers.add(j + 1);
                }
            }
            j++;
        }
        return missingNumbers;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, -1, 4, 5, 5};
        System.out.println(findNumbers(nums, 3));

        nums = new int[]{2, 3, 4};
        System.out.println(findNumbers(nums, 3));

        nums = new int[]{-1, -2, -3};
        System.out.println(findNumbers(nums, 3));
    }
}
