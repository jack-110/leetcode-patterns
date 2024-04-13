package org.leetcode.patterns.Stack.BalancedParentheses;

import java.util.List;
import java.util.Stack;

public class Solution {

    public static boolean isValid(String s) {
        List<Character> leftParentheses = List.of('(', '[', '{');
        List<Character> rightParentheses = List.of(')', ']', '}');
        Stack<Character> parentheses = new Stack<>();
        for (char c : s.toCharArray()) {
            if (leftParentheses.contains(c)) {
                parentheses.push(c);
            } else if (rightParentheses.contains(c)) {
                if (parentheses.isEmpty()) {
                    return false;
                }
                Character parenthese = parentheses.pop();
                if (parenthese == ')' && c != '(') {
                    return false;
                }
                if (parenthese == ']' && c != '[') {
                    return false;
                }
                if (parenthese == '}' && c != '{') {
                    return false;
                }
            }
        }
        return parentheses.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{12(22)}"));
        System.out.println(isValid("{12(22)"));
        System.out.println(isValid("{12(22)[]}[23f]"));
        System.out.println(isValid("abc"));
    }
}
