package com.cajoalbuquerque;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> adjacents = new HashMap<>();
        for (int[] flight : flights) {
            if (!adjacents.containsKey(flight[0]))
                adjacents.put(flight[0], new HashMap<>());

            adjacents.get(flight[0]).put(flight[1], flight[2]);
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] minPrice = new int[n];
        Arrays.fill(minPrice, Integer.MAX_VALUE);

        int stops = 0;
        queue.add(new int[] { src, 0 });
        while (!queue.isEmpty() && stops <= k) {
            int numberOfNodes = queue.size();
            while (numberOfNodes > 0) {
                int[] currentNode = queue.remove();
                HashMap<Integer, Integer> adjs = adjacents.getOrDefault(currentNode[0], new HashMap<>());
                for (int destCity : adjs.keySet()) {
                    int price = adjs.get(destCity);
                    if (price + currentNode[1] >= minPrice[destCity])
                        continue;

                    minPrice[destCity] = price + currentNode[1];
                    queue.add(new int[] { destCity, minPrice[destCity] });
                }

                numberOfNodes--;
            }

            stops++;
        }

        return minPrice[dst] == Integer.MAX_VALUE ? -1 : minPrice[dst];
    }
}