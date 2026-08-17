package com.cajoalbuquerque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void Test1() {
        Solution sut = new Solution();

        var nums = new int[] { 2, 7, 11, 15 };
        var target = 9;
        var expected = new int[] { 0, 1 };

        int[] result = sut.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }

    @Test
    public void Test2() {
        Solution sut = new Solution();

        var nums = new int[] { 3, 2, 4 };
        var target = 6;
        var expected = new int[] { 1, 2 };

        int[] result = sut.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }

    @Test
    public void Test3() {
        Solution sut = new Solution();

        var nums = new int[] { 3, 3 };
        var target = 6;
        var expected = new int[] { 0, 1 };

        int[] result = sut.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }
}
