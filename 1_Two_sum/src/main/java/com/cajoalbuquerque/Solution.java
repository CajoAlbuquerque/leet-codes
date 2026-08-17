package com.cajoalbuquerque;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];

            Integer otherIdx = map.get(remainder);
            if (otherIdx != null)
                return new int[] { otherIdx, i };

            map.put(nums[i], i);
        }

        return new int[0];
    }
}