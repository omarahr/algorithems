package com.company.leetcode.challenges.jan2021.week2.wordladder;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        List<List<Integer>> graph = new ArrayList<>();
        Map<String, Integer> wordToIndex = new HashMap<>();
        boolean endWordExists = false;

        for (int i = 0; i < wordList.size(); i++) {
            wordToIndex.put(wordList.get(i), i);
            if (wordList.get(i).equals(endWord))
                endWordExists = true;
        }

        if (!endWordExists)
            return 0;

        for (int i = 0; i < wordList.size(); i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < wordList.size(); i++) {
            char[] wordA = wordList.get(i).toCharArray();
            for (int j = i + 1; j < wordList.size(); j++) {
                char[] wordB = wordList.get(j).toCharArray();
                if (canConnect(wordA, wordB)) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        char[] start = beginWord.toCharArray();
        for (String s : wordList) {
            if (canConnect(start, s.toCharArray())) {
                queue.add(wordToIndex.get(s));
            }
        }

        int steps = 1;
        boolean[] visited = new boolean[wordList.size()];
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int currentIndex = queue.poll();

                if (visited[currentIndex])
                    continue;

                if (wordList.get(currentIndex).equals(endWord))
                    return steps;

                visited[currentIndex] = true;
                for (int connectedNode : graph.get(currentIndex)) {
                    if (!visited[connectedNode]) {
                        queue.add(connectedNode);
                    }
                }
            }
        }

        return 0;
    }

    private boolean canConnect(char[] a, char[] b) {
        if (a.length != b.length)
            return false;
        int diff = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                diff++;
        return diff == 1;
    }
}
