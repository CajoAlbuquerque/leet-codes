package com.cajoalbuquerque;

import java.util.Arrays;

class Solution {
    public String leftshift(String str, int shift) {
        int safeShift = shift % str.length();
        return str.substring(safeShift) + str.substring(0, safeShift);
    }

    public String rightshift(String str, int shift) {
        int safeShift = shift % str.length();
        int splitIndex = str.length() - safeShift;
        return str.substring(splitIndex) + str.substring(0, splitIndex);
    }

    public int minRoof(int[] cars, int k) {
        // For holding the best result
        int minLength = Integer.MAX_VALUE;

        // Needs to be sorted so we can do this in O(n)
        Arrays.sort(cars);

        // Sliding window for traversing the array
        int start = 0;
        int end = 0;
        while (end < cars.length) {
            int carsInInterval = end - start + 1;

            // If there are enough cars in the window, calculate min length of roof
            if (carsInInterval == k) {
                minLength = Math.min(cars[end] - cars[start] + 1, minLength);
                // And shorten the window -> always better to have less cars
                start++;
                continue;
            }

            end++;
        }

        return minLength;
    }
}