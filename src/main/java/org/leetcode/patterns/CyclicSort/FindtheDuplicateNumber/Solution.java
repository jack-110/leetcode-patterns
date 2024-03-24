package org.leetcode.patterns.CyclicSort.FindtheDuplicateNumber;

public class Solution {

    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num != i + 1) {
                if (num != nums[num - 1]) {
                    nums[i] = nums[num - 1];
                    nums[num - 1] = num;
                } else {
                    return num;
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 4, 3, 2};
        System.out.println(findNumber(nums));
    }
}
