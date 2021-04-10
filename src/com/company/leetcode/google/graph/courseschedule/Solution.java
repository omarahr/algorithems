package com.company.leetcode.google.graph.courseschedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] result = findOrder(1, new int[][]{});
        System.out.print(Arrays.toString(result));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        List<Integer> orderedCourse = new ArrayList<>();
        int counter = 0;
        while (counter < numCourses + 1) {
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    inDegree[i]--;
                    orderedCourse.add(i);
                    List<Integer> neighbours = graph.get(i);
                    for (int j = 0; j < neighbours.size(); j++) {
                        inDegree[neighbours.get(j)]--;
                    }
                }
            }
            if (orderedCourse.size() == numCourses) {
                return orderedCourse.stream().mapToInt(i -> i).toArray();
            }

            counter++;
        }

        return new int[]{};
    }


}
