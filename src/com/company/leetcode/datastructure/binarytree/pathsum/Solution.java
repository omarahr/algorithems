package com.company.leetcode.datastructure.binarytree.pathsum;

public class Solution {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        // leaf node
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }
}
