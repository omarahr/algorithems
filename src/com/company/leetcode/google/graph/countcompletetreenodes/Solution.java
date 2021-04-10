package com.company.leetcode.google.graph.countcompletetreenodes;

public class Solution {


    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int depth = computeDepth(root);

        if (depth == 0)
            return 1;

        int left = 1, right = (int) Math.pow(2, depth) - 1;

        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (exists(pivot, depth, root))
                left = pivot + 1;
            else right = pivot - 1;
        }

        return (int) Math.pow(2, depth) - 1 + left;
    }

    private boolean exists(int index, int depth, TreeNode node) {
        int left = 0, right = (int) Math.pow(2, depth) - 1;
        for (int i = 0; i < depth; i++) {
            int pivot = left + (right - left) / 2;
            if (index <= pivot) {
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot;
            }
        }
        return node != null;
    }

    private int computeDepth(TreeNode node) {
        int depth = 0;
        while (node.left != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
