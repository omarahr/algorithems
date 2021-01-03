package com.company.leetcode.binarytree.nextrightpointer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static class Node {
        int val;
        Node left, right, next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    '}';
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return null;

        // populate index
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();


        queue.add(root);
        level.add(1);

        List<Node> bfsNode = new ArrayList<>();
        List<Integer> bfsLevel = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentLevel = level.poll();

            bfsNode.add(current);
            bfsLevel.add(currentLevel);

            if (current.left != null) {
                queue.add(current.left);
                level.add(currentLevel + 1);
            }

            if (current.right != null) {
                queue.add(current.right);
                level.add(currentLevel + 1);
            }
        }


        for(int i = 0; i < bfsNode.size() - 1; i++) {
            Node current = bfsNode.get(i);
            Node next = bfsNode.get(i + 1);

            int currentLevel = bfsLevel.get(i);
            int nextLevel = bfsLevel.get(i + 1);

            if (currentLevel == nextLevel) {
                current.next = next;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
//        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
//        c.left = f;
        c.right = g;

        Solution solution = new Solution();
        solution.connect(a);

        Queue<Node> u = new LinkedList<>();
        u.add(a);
        while (!u.isEmpty()) {
            Node current = u.poll();
            System.out.println(current.val +" next -> "+current.next);
            if (current.left != null)
                u.add(current.left);
            if (current.right != null)
                u.add(current.right);
        }
    }
}
