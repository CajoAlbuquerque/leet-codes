package com.cajoalbuquerque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void TestShift() {
        Solution sut = new Solution();

        String str = "ABCDE";

        String result1 = sut.leftshift(str, 2);
        assertEquals("CDEAB", result1);

        String result2 = sut.rightshift(str, 2);
        assertEquals("DEABC", result2);

        String result3 = sut.leftshift(str, 6);
        assertEquals("BCDEA", result3);

        String result4 = sut.rightshift(str, 8);
        assertEquals("CDEAB", result4);
    }

    @Test
    public void TestCars() {
        Solution sut = new Solution();

        int[] cars = new int[] { 6, 2, 12, 7 };
        int k = 3;
        int expected = 6;

        int result = sut.minRoof(cars, k);

        assertEquals(expected, result);
    }

    @Test
    public void TestCars2() {
        Solution sut = new Solution();

        int[] cars = new int[] { 2, 10, 8, 17, 3 };
        int k = 3;
        int expected = 7;

        int result = sut.minRoof(cars, k);

        assertEquals(expected, result);
    }
    
    @Test
    public void TestCars3() {
        Solution sut = new Solution();

        int[] cars = new int[] { 1, 2, 3, 4, 5 };
        int k = 4;
        int expected = 4;

        int result = sut.minRoof(cars, k);

        assertEquals(expected, result);
    }
}
