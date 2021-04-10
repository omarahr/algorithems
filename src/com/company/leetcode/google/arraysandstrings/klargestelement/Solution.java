package com.company.leetcode.google.arraysandstrings.klargestelement;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k)
                pq.poll();
        }

        return pq.poll();
    }
}
