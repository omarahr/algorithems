package com.company.facebook.nodesinasubtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static class Query {
        int u;
        char c;

        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }

    static class Node {
        int val;
        List<Node> children;

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        int[] results = new int[queries.size()];
        int[][] freq = new int[s.length() + 1][];

        getFreq(root, s, freq);

        for (int i = 0; i < queries.size(); i++) {
            Query query = queries.get(i);
            results[i] = freq[query.u][query.c - 'a'];
        }

        return results;
    }


    int[] getFreq(Node node, String input, int[][] cFreq) {
        if (node == null)
            return new int[26];

        int[] freq = new int[26];
        freq[input.charAt(node.val - 1) - 'a']++;
        for (Node child : node.children) {
            freq = mergeFreq(freq, getFreq(child, input, cFreq));
        }

        cFreq[node.val] = freq;

        return freq;
    }

    int[] mergeFreq(int[] freqA, int[] freqB) {
        for (int i = 0; i < 26; i++) {
            freqA[i] += freqB[i];
        }
        return freqA;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node_2 = new Node(2, new ArrayList<>());
        Node node_3 = new Node(3, new ArrayList<>());
        Node n_1 = new Node(1, Arrays.asList(node_2, node_3));
        ArrayList<Query> queries = new ArrayList<>();
        queries.add(new Query(1, 'a'));
        System.out.println(Arrays.toString(solution.countOfNodes(n_1, queries, "aba")));
    }
}
