package com.cajoalbuquerque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void Test1() {
        Solution sut = new Solution();

        char[][] input = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '1', '1', '0' },
                { '1', '1', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '0', '0', '1', '1', '1' } };

        int result = sut.maximalSquare(input);

        assertEquals(16, result);
    }
}
