package com.company.facebook.visiablenodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static class Node {
        int data;
        Node left, right;
        Node() {}
        Node(int data) {
            this.data = data;
        }
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    int visibleNodes(Node root) {
        int numberOfVisibleNodes = 0;
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.add(root);
        levels.add(0);

        while (!queue.isEmpty() && !levels.isEmpty()) {
            Node current = queue.poll();
            int level = levels.poll();

            if (numberOfVisibleNodes == level) {
                numberOfVisibleNodes++;
            }

            if (current.left != null) {
                queue.add(current.left);
                levels.add(level + 1);
            }

            if (current.right != null) {
                queue.add(current.right);
                levels.add(level + 1);
            }
        }

        return numberOfVisibleNodes;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node root = new Node(0,
                new Node(3, new Node(1), new Node(6, new Node(4), new Node(7))),
                new Node(10, null, new Node(14, new Node(13), null))
        );

        System.out.println(solution.visibleNodes(root));
    }
}
