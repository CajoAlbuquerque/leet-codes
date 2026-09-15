package com.cajoalbuquerque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public class StudentScore implements Comparable<StudentScore> {
        int student_id;
        int score = 0;

        public StudentScore(int student_id) {
            this.student_id = student_id;
        }

        @Override
        public int compareTo(StudentScore other) {
            if(this.score == other.score)
                return this.student_id - other.student_id;

            return other.score - this.score;
        }
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report,
            int[] student_id, int k) {
        HashMap<String, Integer> sentimentMap = new HashMap<>();

        for (String pos : positive_feedback) {
            sentimentMap.put(pos, 3);
        }

        for (String neg : negative_feedback) {
            sentimentMap.put(neg, -1);
        }

        PriorityQueue<StudentScore> orderedStudentScores = new PriorityQueue<>(k);
        for (int i = 0; i < report.length; i++) {
            String[] rep_words = report[i].split(" ");
            StudentScore student_score = new StudentScore(student_id[i]);

            for (String word : rep_words) {
                Integer score = sentimentMap.get(word);
                student_score.score += (score != null ? score : 0);
            }

            orderedStudentScores.add(student_score);
        }

        List<Integer> result = new ArrayList<>();
        while (k != 0) {
            result.add(orderedStudentScores.poll().student_id);
            k--;
        }

        return result;
    }
}