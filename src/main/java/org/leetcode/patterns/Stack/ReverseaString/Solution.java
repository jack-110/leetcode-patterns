package org.leetcode.patterns.Stack.ReverseaString;

import java.util.Stack;

public class Solution {

    public static String reverseString(String s) {
        // if string is blank,return s
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()) {
            characterStack.push(c);
        }
        StringBuilder result = new StringBuilder();
        while (!characterStack.isEmpty()) {
            result.append(characterStack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("openai"));
    }
}
