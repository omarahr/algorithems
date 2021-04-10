package com.company.leetcode.challenges.y2021.april.week1.largestuniquenumber;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

    }

    public int largestUniqueNumber(int[] A) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int j : A) {
            if (map.containsKey(j)) {
                map.put(j, false);
            } else {
                map.put(j, true);
            }
        }
        int largestNumber = -1;
        for (int i : A) {
            largestNumber = map.get(i) && i > largestNumber ? i : largestNumber;
        }
        return largestNumber;
    }
}
