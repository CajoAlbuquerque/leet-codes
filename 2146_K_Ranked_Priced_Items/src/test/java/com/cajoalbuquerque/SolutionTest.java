package com.cajoalbuquerque;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void Test1() {
        Solution sut = new Solution();

        int[][] grid = new int[][] { { 1, 2, 0, 1 }, { 1, 3, 0, 1 }, { 0, 2, 5, 1 } };
        int[] pricing = new int[] { 2, 5 };
        int[] start = new int[] { 0, 0 };
        int k = 3;
        int[][] expected = { { 0, 1 }, { 1, 1 }, { 2, 1 } };

        List<List<Integer>> result = sut.highestRankedKItems(grid, pricing, start, k);

        assertTrue(checkResult(expected, result));
    }

    @Test
    public void Test2() {
        Solution sut = new Solution();

        int[][] grid = new int[][] { { 1, 2, 0, 1 }, { 1, 3, 3, 1 }, { 0, 2, 5, 1 } };
        int[] pricing = new int[] { 2, 3 };
        int[] start = new int[] { 2, 3 };
        int k = 2;
        int[][] expected = { { 2, 1 }, { 1, 2 } };

        List<List<Integer>> result = sut.highestRankedKItems(grid, pricing, start, k);

        assertTrue(checkResult(expected, result));
    }

    @Test
    public void Test3() {
        Solution sut = new Solution();

        int[][] grid = new int[][] { { 1, 1, 1 }, { 0, 0, 1 }, { 2, 3, 4 } };
        int[] pricing = new int[] { 2, 3 };
        int[] start = new int[] { 0, 0 };
        int k = 3;
        int[][] expected = { { 2, 1 }, { 2, 0 } };

        List<List<Integer>> result = sut.highestRankedKItems(grid, pricing, start, k);

        assertTrue(checkResult(expected, result));
    }

    private boolean checkResult(int[][] expected, List<List<Integer>> result) {
        int rows = expected.length;
        int cols = expected[0].length;

        if (rows != result.size() || cols != result.get(0).size())
            return false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (expected[i][j] != result.get(i).get(j)) {
                    System.out.print("Value at (" + i + "," + j + ") is different");
                    return false;
                }
            }
        }

        return true;
    }
}
