package com.cajoalbuquerque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public class RankedItem implements Comparable<RankedItem> {
        int distance;
        int price;
        int row;
        int col;

        public RankedItem(int distance, int price, int row, int col) {
            this.distance = distance;
            this.price = price;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(RankedItem other) {
            if (this.distance != other.distance)
                return this.distance - other.distance;

            if (this.price != other.price)
                return this.price - other.price;

            if (this.row != other.row)
                return this.row - other.row;

            return this.col - other.col;
        }
    }

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // PriorityQueue to always visit the highest-ranked item (greedy)
        PriorityQueue<RankedItem> toVisit = new PriorityQueue<>();
        toVisit.add(new RankedItem(0, grid[start[0]][start[1]], start[0], start[1]));
        visited[start[0]][start[1]] = true;

        // Traverse grid
        while (!toVisit.isEmpty() && result.size() < k) {
            RankedItem node = toVisit.poll();
            if (isPriceWithin(node.price, pricing)) {
                result.add(Arrays.asList(node.row, node.col));
            }
            calculateNeighbours(node.row, node.col, node.distance, grid, toVisit, visited);
        }

        return result;
    }

    private void calculateNeighbours(int row, int col, int distance, int[][] grid, PriorityQueue<RankedItem> toVisit,
            boolean[][] visited) {
        int dRow[] = { -1, 0, 1, 0 };
        int dCol[] = { 0, 1, 0, -1 };
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int adjRow = row + dRow[i];
            int adjCol = col + dCol[i];

            if (isValidPosition(adjRow, adjCol, rows, cols, grid, visited)) {
                toVisit.add(new RankedItem(distance + 1, grid[adjRow][adjCol], adjRow, adjCol));
                visited[adjRow][adjCol] = true;
            }
        }
    }

    private boolean isPriceWithin(int price, int[] priceRange) {
        return price >= priceRange[0] && price <= priceRange[1];
    }

    private boolean isValidPosition(int row, int col, int rowsLength, int colsLength, int[][] grid,
            boolean[][] visited) {
        if (row < 0 || row >= rowsLength || col < 0 || col >= colsLength)
            return false;

        if (visited[row][col])
            return false;

        if (grid[row][col] == 0)
            return false;

        return true;
    }
}