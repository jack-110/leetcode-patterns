package org.leetcode.patterns.MergeIntervals.MinimumMeetingRooms;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        if (meetings == null || meetings.isEmpty())
            return 0;

        meetings.sort(Comparator.comparingInt(a -> a.start));

        int minRooms = 0;
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), Comparator.comparingInt(a -> a.end));

        return minRooms;
    }
}

class Meeting {
  int start;
  int end;

  public Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
