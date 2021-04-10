package com.company.leetcode.challenges.y2021.jan.week2.treeroot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

    }


    public Node findRoot(List<Node> tree) {
        Map<Node, Node> childToParentMap = new HashMap<>();
        for (Node parent : tree) {
            if (parent != null) {
                for (Node child : parent.children) {
                    childToParentMap.put(child, parent);
                }
            }
        }

        for (Node node : tree) {
            if (node != null) {
                if (!childToParentMap.containsKey(node))
                    return node;
            }
        }

        return null;
    }

    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
