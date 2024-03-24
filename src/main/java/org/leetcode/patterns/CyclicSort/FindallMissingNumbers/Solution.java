package org.leetcode.patterns.CyclicSort.FindallMissingNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num != nums[num - 1]) {
                nums[i] = nums[num - 1];
                nums[num - 1] = num;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                missingNumbers.add(j + 1);
            }
        }
        return missingNumbers;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 8, 2, 3, 5, 1};
        System.out.println(findNumbers(nums));

        nums = new int[]{4, 4, 4, 4};
        System.out.println(findNumbers(nums));
    }


}
