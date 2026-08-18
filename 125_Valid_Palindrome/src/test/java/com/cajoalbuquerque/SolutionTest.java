package com.cajoalbuquerque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void Test1() {
        Solution sut = new Solution();

        String input = "A man, a plan, a canal: Panama";
        boolean expected = true;

        boolean result = sut.isPalindrome(input);

        assertEquals(expected, result);
    }

    @Test
    public void Test2() {
        Solution sut = new Solution();

        String input = "race a car";
        boolean expected = false;

        boolean result = sut.isPalindrome(input);

        assertEquals(expected, result);
    }

    @Test
    public void Test3() {
        Solution sut = new Solution();

        String input = " ";
        boolean expected = true;

        boolean result = sut.isPalindrome(input);

        assertEquals(expected, result);
    }
    
    @Test
    public void Test4() {
        Solution sut = new Solution();

        String input = ".,";
        boolean expected = true;

        boolean result = sut.isPalindrome(input);

        assertEquals(expected, result);
    }
    
    @Test
    public void Test5() {
        Solution sut = new Solution();

        String input = "I";
        boolean expected = true;

        boolean result = sut.isPalindrome(input);

        assertEquals(expected, result);
    }
}
