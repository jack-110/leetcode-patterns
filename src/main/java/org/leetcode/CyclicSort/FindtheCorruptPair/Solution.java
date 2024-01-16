package org.leetcode.CyclicSort.FindtheCorruptPair;

public class Solution {

    public static int[] findNumbers(int[] nums) {
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
                return new int[]{nums[j], j + 1};
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 3, 6, 4};
        int[] pair = findNumbers(nums);
        System.out.println("dup: " + pair[0] + " missing: " + pair[1]);
    }
}
