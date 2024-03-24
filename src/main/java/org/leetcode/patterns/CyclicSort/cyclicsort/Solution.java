package org.leetcode.patterns.CyclicSort.cyclicsort;

public class Solution {
    public static int[] sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if ( num - 1 == i) {
                i++;
                continue;
            }
            // swap
            nums[i] = nums[num - 1];
            nums[num - 1] = num;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
