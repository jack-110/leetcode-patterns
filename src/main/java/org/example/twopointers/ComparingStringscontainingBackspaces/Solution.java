package org.example.twopointers.ComparingStringscontainingBackspaces;

/**
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 *
 */
public class Solution {
    public static boolean compare(String str1, String str2) {
        int str1Index = str1.length() - 1, str2Index = str2.length() - 1;
        while (str1Index >= 0 && str2Index >= 0) {
            str1Index = searchValidIndex(str1, str1Index);
            str2Index = searchValidIndex(str2, str2Index);
            //todo: check if str1Index/str2Index is less than 0
            if (str1.charAt(str1Index) != str2.charAt(str2Index)) {
                return false;
            }
            str1Index--;
            str2Index--;
        }
        return true;
    }

    private static int searchValidIndex(String str, int start) {
        int index = start;
        int backSteps = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                index--;
                backSteps++;
            } else {
                if (backSteps == 0) {
                    return index;
                }
                index = index - backSteps;
                backSteps = 0;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String str1 = "xy#z", str2 = "xzz#";
        boolean equal = compare(str1, str2);
        System.out.println(str1 + " equal with " + str2 + " is " + equal);

        str1 = "xy#z";
        str2 = "xyz#";
        equal = compare(str1, str2);
        System.out.println(str1 + " equal with " + str2 + " is " + equal);

        str1 = "xp#";
        str2 = "xyz##";
        equal = compare(str1, str2);
        System.out.println(str1 + " equal with " + str2 + " is " + equal);

        str1 = "xywrrmp";
        str2 = "xywrrmu#p";
        equal = compare(str1, str2);
        System.out.println(str1 + " equal with " + str2 + " is " + equal);

        str1 = "xywrp";
        str2 = "xywrr#u#p";
        equal = compare(str1, str2);
        System.out.println(str1 + " equal with " + str2 + " is " + equal);

        str1 = "xywrp";
        str2 = "xywrr#u##p";
        equal = compare(str1, str2);
        System.out.println(str1 + " equal with " + str2 + " is " + equal);
    }
}