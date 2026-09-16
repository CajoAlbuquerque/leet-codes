package com.cajoalbuquerque;

import java.util.ArrayList;
import java.util.List;

class MySolution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // Worker.0 = quality, Worker.1 = wage
        List<List<int[]>> paidGroups = new ArrayList<>();

        // Create group permutations
        for (int i = 0; i < quality.length; i++)
            getAllGroups(i, k, quality, wage, new ArrayList<int[]>(), paidGroups);

        // Determine minimum
        double minCost = Double.MAX_VALUE;

        for (List<int[]> paidGroup : paidGroups) {
            minCost = Math.min(calculateGroupCost(paidGroup), minCost);
        }

        return minCost;
    }

    public void getAllGroups(int i, int workersLeft, int[] quality, int[] wage, ArrayList<int[]> acc,
            List<List<int[]>> result) {
        int[] worker = new int[] { quality[i], wage[i] };
        acc.add(worker);

        if (workersLeft == 1) {
            result.add(new ArrayList<>(acc));
            return;
        }

        for (int j = i + 1; j < quality.length; j++) {
            getAllGroups(j, workersLeft - 1, quality, wage, acc, result);
            if (!acc.isEmpty())
                acc.removeLast(); // To avoid the reference accumulation
        }
    }

    public double calculateGroupCost(List<int[]> paidGroup) {
        // First pass determines max ratio
        double maxRatio = 0;
        for (int[] worker : paidGroup) {
            maxRatio = Math.max((double) worker[1] / worker[0], maxRatio);
        }

        // Second pass determines cost
        double cost = 0;
        for (int[] worker : paidGroup) {
            cost += worker[0] * maxRatio;
        }

        return cost;
    }
}