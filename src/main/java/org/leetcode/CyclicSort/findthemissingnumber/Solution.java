package org.leetcode.CyclicSort.findthemissingnumber;

public class Solution {
    public static int findMissingNumber(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            int num = nums[index];
            if (num < nums.length && num != index) {
                nums[index] = nums[num];
                nums[num] = num;
            } else {
                index++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 3, 5, 2, 4, 6, 0, 1};
        System.out.println(findMissingNumber(nums));

        nums = new int[]{4, 0, 3, 1};
        System.out.println(findMissingNumber(nums));
    }
}
