package com.cajoalbuquerque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void Test1() {
        Solution sut = new Solution();

        int[] nums = new int[] { 2, 3, 1, 1, 4 };
        boolean expected = true;

        boolean result = sut.canJump(nums);

        assertEquals(expected, result);
    }

    @Test
    public void Test2() {
        Solution sut = new Solution();

        int[] nums = new int[] { 3, 2, 1, 0, 4 };
        boolean expected = false;

        boolean result = sut.canJump(nums);

        assertEquals(expected, result);
    }

    @Test
    public void Test3() {
        Solution sut = new Solution();

        int[] nums = new int[] { 0 };
        boolean expected = true;

        boolean result = sut.canJump(nums);

        assertEquals(expected, result);
    }

    @Test
    public void Test4() {
        Solution sut = new Solution();

        int[] nums = new int[] { 2, 3, 1, 0, 1, 4 };
        boolean expected = true;

        boolean result = sut.canJump(nums);

        assertEquals(expected, result);
    }
    
    @Test
    public void Test5() {
        Solution sut = new Solution();

        int[] nums = new int[] { 2, 3, 0, 2, 0, 4 };
        boolean expected = true;

        boolean result = sut.canJump(nums);

        assertEquals(expected, result);
    }
    
    @Test
    public void Test6() {
        Solution sut = new Solution();

        int[] nums = new int[] { 2, 3, 2, 2, 0, 4 };
        boolean expected = true;

        boolean result = sut.canJump(nums);

        assertEquals(expected, result);
    }
}
