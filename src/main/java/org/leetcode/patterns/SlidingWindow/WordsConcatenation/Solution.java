package org.leetcode.patterns.SlidingWindow.WordsConcatenation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<>();
        int wordLength = words[0].length(), matched = 0;;
        int windowStart = 0, windowSize = words.length * wordLength;
        HashMap<String, Integer> stringFrequencyMap = convert2Map(words);
        for (int windowEnd = wordLength - 1; windowEnd < str.length(); windowEnd += wordLength) {
            String substring = str.substring(windowEnd + 1 - wordLength, windowEnd + 1);
            if (stringFrequencyMap.containsKey(substring)) {
                stringFrequencyMap.put(substring, stringFrequencyMap.getOrDefault(substring, 0) - 1);
                if (stringFrequencyMap.get(substring) == 0) {
                    matched++;
                }
            }

            if (matched == words.length) {
                resultIndices.add(windowStart);
            }

            if (windowEnd - windowStart + 1 >= windowSize) {
                String leftString = str.substring(windowStart, windowStart + wordLength);
                if (stringFrequencyMap.containsKey(leftString)) {
                    stringFrequencyMap.replace(leftString, stringFrequencyMap.get(leftString) + 1);
                    if (stringFrequencyMap.get(leftString) > 0) {
                        matched--;
                    }
                }
                windowStart += wordLength;
            }
        }
        return resultIndices;
    }

    private static HashMap<String, Integer> convert2Map(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        String str ="catfoxcat";
        String[] words = new String[]{"cat", "fox"};
        List<Integer> indexList = findWordConcatenation(str, words);
        System.out.println(indexList.toString());

        str = "catcatfoxfox";
        words = new String[]{"cat", "fox"};
        indexList = findWordConcatenation(str, words);
        System.out.println(indexList.toString());
    }
}
