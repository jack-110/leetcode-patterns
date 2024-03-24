package org.leetcode.patterns.MergeIntervals.MaximumCPULoad;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static int findMaxCPULoad(List<Job> jobs) {
        // sort the jobs by start time
        jobs.sort(Comparator.comparingInt(a -> a.start));

        int maxCPULoad = 0;
        int currentCPULoad = 0;
        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), Comparator.comparingInt(a -> a.end));
        for (Job job : jobs) {
            while (!minHeap.isEmpty() && job.start >= minHeap.peek().end) {
                currentCPULoad -= minHeap.peek().cpuLoad;
            }

            minHeap.offer(job);
            currentCPULoad += job.cpuLoad;
            maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
        }

        return maxCPULoad;
    }
}
