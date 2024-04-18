package org.leetcode.patterns.Stack.SortingaStack;

import java.util.List;
import java.util.Stack;

public class Solution {

    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<>();
        Stack<Integer> sortedStack = new Stack<>();
        while (!input.isEmpty()) {
            Integer cur = input.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > cur) {
                tmpStack.push(sortedStack.pop());
            }
            sortedStack.push(cur);
            while (!tmpStack.isEmpty()) {
                sortedStack.push(tmpStack.pop());
            }

        }
        return sortedStack;
    }

    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);
        System.out.println(sortStack(input));
    }
}
