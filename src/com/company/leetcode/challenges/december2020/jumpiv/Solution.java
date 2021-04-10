package com.company.leetcode.challenges.december2020.jumpiv;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 1, 1, 1, 1, 1, 404};
        System.out.println(solution.minJumps(arr));
    }

    private int bfs(HashMap<Integer, List<Integer>> graph, int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        boolean[] visited = new boolean[arr.length];
        visited[0] = true;

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentIndex = queue.poll();
                if (currentIndex == arr.length - 1)
                    return step;

                List<Integer> next = graph.get(arr[currentIndex]);
                next.add(currentIndex + 1);
                next.add(currentIndex - 1);

                for (int connectedNodeIndex : graph.get(arr[currentIndex])) {
                    if (connectedNodeIndex >= 0 && connectedNodeIndex < arr.length && !visited[connectedNodeIndex]) {
                        queue.offer(connectedNodeIndex);
                        visited[connectedNodeIndex] = true;
                    }
                }
                graph.get(arr[currentIndex]).clear();
            }
            step++;
        }

        // should never happen
        return -1;
    }

    public int minJumps(int[] arr) {
        if (arr.length == 1)
            return 0;

        HashMap<Integer, List<Integer>> valueToIndexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            valueToIndexMap.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);

        return bfs(valueToIndexMap, arr);
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

}
