package com.cajoalbuquerque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void Test1() {
        Solution sut = new Solution();

        int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] expected = new int[] { 3, 3, 5, 5, 6, 7 };

        int[] result = sut.maxSlidingWindow(nums, k);

        assertArrayEquals(expected, result);
    }

    @Test
    public void Test3() {
        Solution sut = new Solution();

        int[] nums = new int[] { 1, -1, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] expected = new int[] { 1, -1, 5, 5, 6, 7 };

        int[] result = sut.maxSlidingWindow(nums, k);

        assertArrayEquals(expected, result);
    }

    @Test
    public void Test2() {
        Solution sut = new Solution();

        int[] nums = new int[] { 1 };
        int k = 1;
        int[] expected = new int[] { 1 };

        int[] result = sut.maxSlidingWindow(nums, k);

        assertArrayEquals(expected, result);
    }

    @Test
    public void Test4() {
        Solution sut = new Solution();

        int[] nums = new int[] { 9, 10, 9, -7, -4, -8, 2, -6 };
        int k = 5;
        int[] expected = new int[] { 10, 10, 9, 2 };

        int[] result = sut.maxSlidingWindow(nums, k);

        assertArrayEquals(expected, result);
    }
}
