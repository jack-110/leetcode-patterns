package org.leetcode.patterns.Stack.DecimaltoBinaryConversion;

import java.util.Stack;

public class Solution {

    public static String decimalToBinary(int num) {
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            stack.push(num % 2);
            num = num / 2;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(7));
    }
}
