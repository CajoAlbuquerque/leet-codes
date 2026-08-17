package com.cajoalbuquerque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void Test1() {
        Solution sut = new Solution();

        int num = 3749;
        String expected = "MMMDCCXLIX";

        String result = sut.intToRoman(num);

        assertEquals(expected, result);
    }
    
    @Test
    public void Test2() {
        Solution sut = new Solution();

        int num = 58;
        String expected = "LVIII";

        String result = sut.intToRoman(num);

        assertEquals(expected, result);
    }
    
    @Test
    public void Test3() {
        Solution sut = new Solution();

        int num = 1994;
        String expected = "MCMXCIV";

        String result = sut.intToRoman(num);

        assertEquals(expected, result);
    }
    
    @Test
    public void Test4() {
        Solution sut = new Solution();

        int num = 3888;
        String expected = "MMMDCCCLXXXVIII";

        String result = sut.intToRoman(num);

        assertEquals(expected, result);
    }
}
