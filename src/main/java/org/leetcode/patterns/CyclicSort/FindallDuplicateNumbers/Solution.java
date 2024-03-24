package org.leetcode.patterns.CyclicSort.FindallDuplicateNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[nums[i] - 1];
                    nums[temp - 1] = temp;
                } else {
                    duplicateNumbers.add(nums[i]);
                    i++;
                }
            } else {
                i++;
            }
        }
        return duplicateNumbers;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 7, 2, 3, 5, 3};
        System.out.println(findNumbers(nums));
    }
}
