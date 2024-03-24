package org.leetcode.patterns.MergeIntervals.IntervalsIntersection;

import org.leetcode.patterns.MergeIntervals.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //todo: linear time?
    public static List<Interval> merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> result = new ArrayList<>();
        for (Interval intervalArr1 : arr1) {
            for (Interval intervalArr2 : arr2) {
                if (intervalArr2.end >= intervalArr1.start && intervalArr2.start <= intervalArr1.end) {
                    result.add(new Interval(Math.max(intervalArr1.start, intervalArr2.start), Math.min(intervalArr1.end, intervalArr2.end)));
                } else if (intervalArr2.end > intervalArr1.start) {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Interval[] interval1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] interval2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
        List<Interval> merged = merge(interval1, interval2);
        System.out.println(merged.toString());

        interval1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        interval2 = new Interval[]{new Interval(5, 10)};
        merged = merge(interval1, interval2);
        System.out.println(merged.toString());
    }
}
