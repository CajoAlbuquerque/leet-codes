package com.cajoalbuquerque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class OptimalSolution {
    public class Worker implements Comparable<Worker> {
        int quality;
        int wage;
        double wageQualityRatio;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.wageQualityRatio = (double) wage / quality;
        }

        @Override
        public int compareTo(Worker other) {
            if (this.wageQualityRatio < other.wageQualityRatio)
                return -1;

            if (other.wageQualityRatio < this.wageQualityRatio)
                return 1;

            return 0;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double minCost = Double.MAX_VALUE;
        int currentTotalQuality = 0;

        // List of workers ordered by ratio
        List<Worker> orderedWorkers = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            orderedWorkers.add(new Worker(quality[i], wage[i]));
        }
        Collections.sort(orderedWorkers);

        // Prio queue to keep track of the highest quality workers
        PriorityQueue<Integer> workers = new PriorityQueue<>(Collections.reverseOrder());
        for(Worker worker : orderedWorkers)
        {
            workers.add(worker.quality);
            currentTotalQuality += worker.quality;

            // If we have more workers than we need, get rid of the highest quality one (highest cost)
            // This means we keep the cheapest for next iterations (greedy)
            if(workers.size() > k)
                currentTotalQuality -= workers.poll();

            // Total = highest ratio * total quality
            // This works because, at any given point, the highest ratio is at i because they are sorted
            if(workers.size() == k)
                minCost = Math.min(currentTotalQuality * worker.wageQualityRatio, minCost);
        }

        return minCost;
    }
}