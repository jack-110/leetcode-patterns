package org.leetcode.patterns.CyclicSort.FindtheSmallestMissingPositiveNumber;

public class Solution {

    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num >= 1 && num <= nums.length && num != nums[num - 1]) {
                nums[i] = nums[num - 1];
                nums[num - 1] = num;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3, 1, 5, 4, 2};
        System.out.println(findNumber(nums));

        nums = new int[]{3, -2, 0, 1, 2};
        System.out.println(findNumber(nums));

        nums = new int[]{37, 33, 5};
        System.out.println(findNumber(nums));

        nums = new int[]{3, 2, 0, 1, 2};
        System.out.println(findNumber(nums));
    }
}
