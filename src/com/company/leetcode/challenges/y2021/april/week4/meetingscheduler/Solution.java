package com.company.leetcode.challenges.y2021.april.week4.meetingscheduler;

import java.util.*;

public class Solution {

    public static class Pair implements Comparable<Pair> {
        int start, end;
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            return this.start - o.start;
        }

        public boolean startsAfterIEnd(Pair o) {
            return o.start > this.end;
        }
    }

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Pair> p1 = new ArrayList<>();
        List<Pair> p2 = new ArrayList<>();

        for (int[] slot : slots1) {
            p1.add(new Pair(slot[0], slot[1]));
        }

        for (int[] slot : slots2) {
            p2.add(new Pair(slot[0], slot[1]));
        }

        Collections.sort(p1);
        Collections.sort(p2);

        List<Integer> firstAvailableSlot = new ArrayList<>();

        //            [s1,e1]      [s1,e1]         [s1,e1]
        //   [s2,e2]           [s2,e2]
        for (int i = 0; i < p1.size(); i++) {
            for (int j = 0; j < p2.size(); j++) {
                Pair a = p1.get(i);
                Pair b = p2.get(j);
                if (isSlotsOverLap(a, b)) {
                    int[] intervalAvailable = getMaxAvailableInterval(a, b);
                    if (intervalAvailable[1] - intervalAvailable[0] >= duration) {
                        // that's our solution
                        firstAvailableSlot.add(intervalAvailable[0]);
                        firstAvailableSlot.add(intervalAvailable[0] + duration);
                        return firstAvailableSlot;
                    }
                } else if (a.startsAfterIEnd(b)) {
                    break;
                }
            }
        }
        return firstAvailableSlot;
    }

    // s1...s2....e1...e2
    // s1...s2....e2...e1
    // s2...s1....e1...e2
    // s2...s1....e2...e1
    private static int[] getMaxAvailableInterval(Pair a, Pair b) {
        return new int[]{Math.max(a.start, b.start), Math.min(a.end, b.end)};
    }

    private static boolean isSlotsOverLap(Pair a, Pair b) {
        return a.start < b.end && b.start < a.end;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = new int[][]{
                new int[]{10,50},
                new int[]{60,120},
                new int[]{140, 210},
        };
        int[][] b = new int[][]{
                new int[]{0, 15},
                new int[]{60, 70},
        };
        System.out.println(solution.minAvailableDuration(a, b, 8));
        System.out.println(solution.minAvailableDuration(a, b, 12));
    }
}
