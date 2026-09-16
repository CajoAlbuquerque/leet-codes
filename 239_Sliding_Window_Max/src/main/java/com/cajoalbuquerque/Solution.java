package com.cajoalbuquerque;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        int[] result = new int[n];

        // Relevant indices ordered from highest value to lowest value
        Deque<Integer> relevantIndices = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!relevantIndices.isEmpty() && nums[relevantIndices.peekLast()] <= nums[i]) {
                relevantIndices.removeLast();
            }

            relevantIndices.addLast(i);
        }

        result[0] = nums[relevantIndices.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            while (!relevantIndices.isEmpty() && relevantIndices.peekFirst() <= i - k) {
                relevantIndices.removeFirst();
            }

            while (!relevantIndices.isEmpty() && nums[relevantIndices.peekLast()] <= nums[i]) {
                relevantIndices.removeLast();
            }

            relevantIndices.addLast(i);

            result[i - k + 1] = nums[relevantIndices.peekFirst()];
        }

        return result;
    }
}