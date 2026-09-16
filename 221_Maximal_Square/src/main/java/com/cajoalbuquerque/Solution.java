package com.cajoalbuquerque;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSquare = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        // go through each element in matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // calculate max possible square
                int localMax = calculateMaxSquare(i, j, matrix);
                maxSquare = Math.max(maxSquare, localMax);
            }
        }

        return maxSquare;
    }

    private int calculateMaxSquare(int startRow, int startCol, char[][] matrix) {
        int result = 0;

        // Next corner coordinates
        int cornerRow = startRow;
        int cornerCol = startCol;

        while(cornerRow < matrix.length && cornerCol < matrix[0].length && matrix[cornerRow][cornerCol] == '1')
        {
            for(int i = startRow; i <= cornerRow; i++)
            {
                if(matrix[i][cornerCol] == '0')
                    return result * result;
            }
            
            for(int j = startCol; j <= cornerCol; j++)
            {
                if(matrix[cornerRow][j] == '0')
                    return result * result;
            }

            result++;
            cornerRow++;
            cornerCol++;
        }

        return result * result;
    }
}