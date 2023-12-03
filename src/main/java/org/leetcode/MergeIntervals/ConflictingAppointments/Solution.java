package org.leetcode.MergeIntervals.ConflictingAppointments;

import org.leetcode.MergeIntervals.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        for (int i = 0; i < intervals.length - 1; i++) {
            Interval interval = intervals[i];
            Interval intervalNext = intervals[i + 1];
            if (interval.end > intervalNext.start) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
        System.out.println(canAttendAllAppointments(intervals));

        intervals = new Interval[]{new Interval(1, 4), new Interval(5, 6), new Interval(7, 9)};
        System.out.println(canAttendAllAppointments(intervals));
    }
}
