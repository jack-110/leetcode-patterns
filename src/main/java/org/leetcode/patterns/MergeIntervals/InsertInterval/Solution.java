package org.leetcode.patterns.MergeIntervals.InsertInterval;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //todo: [1, 3], [6, 8]; [4, 5]. there is no overlap, just insert at the right index
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();
        int start = newInterval.start;
        int end = newInterval.end;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (start <= interval.end && end >= interval.start) {
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
                while (i < intervals.size() - 1) {
                    interval = intervals.get(++i);
                    if (start <= interval.end && end >= interval.start) {
                        start = Math.min(start, interval.start);
                        end = Math.max(end, interval.end);
                    } else {
                        i--;
                        break;
                    }
                }
                mergedIntervals.add(new Interval(start, end));
            } else {
                mergedIntervals.add(interval);
            }
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = List.of(new Interval(1, 3), new Interval(5, 7), new Interval(8, 12));
        Interval newInterval = new Interval(4, 6);
        List<Interval> merged = insert(intervals, newInterval);
        System.out.println(merged.toString());

        intervals = List.of(new Interval(1, 3), new Interval(5, 7), new Interval(8, 12));
        newInterval = new Interval(4, 10);
        merged = insert(intervals, newInterval);
        System.out.println(merged.toString());

        intervals = List.of(new Interval(2, 3), new Interval(5, 7));
        newInterval = new Interval(1, 4);
        merged = insert(intervals, newInterval);
        System.out.println(merged.toString());
    }
}

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}