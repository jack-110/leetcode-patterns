package org.leetcode.patterns.Stack.NextGreaterElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static List<Integer> nextLargerElement(List<Integer> arr) {
        List<Integer> res = new ArrayList<>(arr.size());
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.size() - 1; i >= 0; i--) {
            int cur = arr.get(i);
            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }
            res.add(0, stack.empty() ? -1 : stack.peek());
            stack.push(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(nextLargerElement(List.of(4, 5, 2, 25)));
        System.out.println(nextLargerElement(List.of(4, 5, 6, 7)));
        System.out.println(nextLargerElement(List.of(7, 6, 5, 4)));
    }
}
