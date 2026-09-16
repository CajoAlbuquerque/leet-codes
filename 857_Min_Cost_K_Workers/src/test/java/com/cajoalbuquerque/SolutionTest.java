package com.cajoalbuquerque;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void Test1() {
        MySolution sut = new MySolution();

        int[] quality = new int[] { 10, 20, 5 };
        int[] wage = new int[] { 70, 50, 30 };
        int k = 2;
        double expected = 105;

        double result = sut.mincostToHireWorkers(quality, wage, k);

        assertEquals(expected, result);
    }

    @Test
    public void Test2() {
        OptimalSolution sut = new OptimalSolution();

        int[] quality = new int[] { 3, 1, 10, 10, 1 };
        int[] wage = new int[] { 4, 8, 2, 2, 7 };
        int k = 3;
        double expected = 30.66667;

        double result = sut.mincostToHireWorkers(quality, wage, k);

        assertEquals(expected, result, Math.pow(10, -5));
    }

    @Test
    public void Test3() {
        MySolution sut = new MySolution();

        List<int[]> paidGroup = Arrays.asList(new int[] { 3, 4 }, new int[] { 10, 2 }, new int[] { 10, 2 });
        double expected = 30.66667;

        double result = sut.calculateGroupCost(paidGroup);

        assertEquals(expected, result, Math.pow(10, -5));
    }

    @Test
    public void Test4() {
        MySolution sut = new MySolution();

        List<int[]> paidGroup = Arrays.asList(new int[] { 10, 70 }, new int[] { 5, 30 });
        double expected = 105;

        double result = sut.calculateGroupCost(paidGroup);

        assertEquals(expected, result, Math.pow(10, -5));
    }

    @Test
    public void Test5() {
        MySolution sut = new MySolution();

        int[] quality = new int[] { 0, 1, 2, 3 };
        int[] wage = new int[] { 0, 1, 2, 3 };
        int k = 2;
        List<List<int[]>> paidGroups = new ArrayList<>();
        int[][][] expected = new int[][][] {
                { { 0, 0 }, { 1, 1 } },
                { { 0, 0 }, { 2, 2 } },
                { { 0, 0 }, { 3, 3 } },
                { { 1, 1 }, { 2, 2 } },
                { { 1, 1 }, { 3, 3 } },
                { { 2, 2 }, { 3, 3 } },
        };

        // Create group permutations
        for (int i = 0; i < quality.length; i++)
            sut.getAllGroups(i, k, quality, wage, new ArrayList<int[]>(), paidGroups);

        assertTrue(checkResult(expected, paidGroups));
    }

    @Test
    public void Test6() {
        MySolution sut = new MySolution();

        int[] quality = new int[] { 0, 1, 2, 3 };
        int[] wage = new int[] { 0, 1, 2, 3 };
        int k = 3;
        List<List<int[]>> paidGroups = new ArrayList<>();
        int[][][] expected = new int[][][] {
                { { 0, 0 }, { 1, 1 }, { 2, 2 } },
                { { 0, 0 }, { 1, 1 }, { 3, 3 } },
                { { 0, 0 }, { 2, 2 }, { 3, 3 } },
                { { 1, 1 }, { 2, 2 }, { 3, 3 } },
        };

        // Create group permutations
        for (int i = 0; i < quality.length; i++)
            sut.getAllGroups(i, k, quality, wage, new ArrayList<int[]>(), paidGroups);

        assertTrue(checkResult(expected, paidGroups));
    }

    private boolean checkResult(int[][][] expected, List<List<int[]>> result) {
        int rows = expected.length;
        int cols = expected[0].length;

        if (rows != result.size() || cols != result.get(0).size())
            return false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (expected[i][j][0] != result.get(i).get(j)[0] || expected[i][j][1] != result.get(i).get(j)[1]) {
                    System.out.print("Value at (" + i + "," + j + ") is different");
                    return false;
                }
            }
        }

        return true;
    }
}
