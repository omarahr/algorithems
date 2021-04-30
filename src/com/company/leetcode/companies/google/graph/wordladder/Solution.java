package com.company.leetcode.companies.google.graph.wordladder;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int result = ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(result);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) graph.add(new ArrayList<>());


        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (differenceIsOne(wordList.get(i), wordList.get(j))) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> steps = new LinkedList<>();
        for (int i = 0; i < wordList.size(); i++) {
            if (differenceIsOne(beginWord, wordList.get(i))) {
                queue.add(i);
                steps.add(2);
            }
        }

        HashSet<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int current_steps = steps.poll();

            if (visited.contains(current)) {
                continue;
            }

            if (wordList.get(current).equals(endWord))
                return current_steps;

            visited.add(current);

            for (int neighbour : graph.get(current)) {
                queue.add(neighbour);
                steps.add(current_steps + 1);
            }
        }


        return 0;
    }

    private static boolean differenceIsOne(String w1, String w2) {
        if (w1.length() != w2.length())
            return false;

        char[] str1 = w1.toCharArray();
        char[] str2 = w2.toCharArray();

        int counter = 0;
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] != str2[i])
                counter++;
            if (counter > 1)
                return false;
        }
        return counter == 1;
    }
}
