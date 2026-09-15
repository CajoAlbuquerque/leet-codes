package com.cajoalbuquerque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void Test1() {
        Solution sut = new Solution();

        var intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

        var expected = new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } };

        int[][] result = sut.merge(intervals);

        assertArrayEquals(expected, result);
    }

    @Test
    public void Test2() {
        Solution sut = new Solution();

        var intervals = new int[][] { { 1, 4 }, { 4, 5 } };

        var expected = new int[][] { { 1, 5 } };

        int[][] result = sut.merge(intervals);

        assertArrayEquals(expected, result);
    }

    @Test
    public void Test3() {
        Solution sut = new Solution();

        var intervals = new int[][] { { 4, 7 }, { 1, 4 } };

        var expected = new int[][] { { 1, 7 } };

        int[][] result = sut.merge(intervals);

        assertArrayEquals(expected, result);
    }

    @Test
    public void Test4() {
        Solution sut = new Solution();

        var intervals = new int[][] { { 7, 8 }, { 1, 2 }, { 8, 9 }, { 2, 4 } };

        var expected = new int[][] { { 1, 4 }, { 7, 9 } };

        int[][] result = sut.merge(intervals);

        assertArrayEquals(expected, result);
    }

    @Test
    public void Test5() {
        Solution sut = new Solution();

        var intervals = new int[][] { { 7, 8 }, { 1, 2 }, { 2, 7 } };

        var expected = new int[][] { { 1, 8 } };

        int[][] result = sut.merge(intervals);

        assertArrayEquals(expected, result);
    }

    @Test
    public void Test6() {
        Solution sut = new Solution();

        var intervals = new int[][] { { 2, 3 }, { 3, 6 }, { 1, 7 } };

        var expected = new int[][] { { 1, 7 } };

        int[][] result = sut.merge(intervals);

        assertArrayEquals(expected, result);
    }

    @Test
    public void Test7() {
        Solution sut = new Solution();

        var intervals = new int[][] { { 115, 121 }, { 95, 101 }, { 106, 110 }, { 99, 106 }, { 119, 123 }, { 113, 121 },
                { 110, 116 } };

        var expected = new int[][] { { 95, 123 } };

        int[][] result = sut.merge(intervals);

        assertArrayEquals(expected, result);
    }
}
