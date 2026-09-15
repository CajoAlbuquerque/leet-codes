package com.cajoalbuquerque;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        boolean[] mergedIntervals = new boolean[intervals.length];
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] maxInterval = new int[2];
            if (mergedIntervals[i])
                continue;

            maxInterval[0] = intervals[i][0];
            maxInterval[1] = intervals[i][1];

            for (int j = i + 1; j < intervals.length; j++) {
                int[] secondInterval = intervals[j];
                if (mergedIntervals[j])
                    continue;

                if (mergeIntervals(maxInterval, secondInterval))
                    mergedIntervals[j] = true;
            }

            for (int[] interval : result) {
                if (mergeIntervals(interval, maxInterval))
                    mergedIntervals[i] = true;
            }

            if (!mergedIntervals[i]) {
                result.add(maxInterval);
                mergedIntervals[i] = true;
            }
        }

        result.sort((a, b) -> a[0] - b[0]);
        for (int i = 0; i < result.size() - 1; i++) {
            if (mergeIntervals(result.get(i), result.get(i + 1))) {
                result.remove(i + 1);
                i--;
            }
        }

        return result.toArray(new int[0][0]);
    }

    private boolean mergeIntervals(int[] first, int[] second) {
        boolean result = false;
        if (first[0] <= second[0] && first[1] >= second[1])
            return true;

        if (first[1] >= second[0] && first[1] <= second[1]) {
            first[1] = second[1];
            result = true;
        }

        if (second[1] >= first[0] && second[0] <= first[0]) {
            first[0] = second[0];
            result = true;
        }

        return result;
    }
}