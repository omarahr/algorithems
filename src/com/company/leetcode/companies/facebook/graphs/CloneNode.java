package com.company.leetcode.companies.facebook.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneNode {

    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (visited.containsKey(node))
            return visited.get(node);

        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        for (Node neighbour : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbour));
        }

        return cloneNode;
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


}
