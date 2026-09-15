package com.cajoalbuquerque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void Test1() {
        Solution sut = new Solution();

        var n = 5;
        var flights = new int[][] { { 1, 0, 5 }, { 2, 1, 5 }, { 3, 0, 2 }, { 1, 3, 2 }, { 4, 1, 1 }, { 2, 4, 1 } };
        var src = 2;
        var dst = 0;
        var k = 2;
        var expected = 7;

        int result = sut.findCheapestPrice(n, flights, src, dst, k);

        assertEquals(expected, result);
    }
}
