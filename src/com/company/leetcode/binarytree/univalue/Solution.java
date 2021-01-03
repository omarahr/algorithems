package com.company.leetcode.binarytree.univalue;

public class Solution {


    public int countUnivalSubtrees(TreeNode root) {
        int[] result = uniValSubTree(root);
        return result[0];
    }

    private int[] uniValSubTree(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};

        if (root.left == null && root.right == null)
            return new int[]{1, 1};


        int[] right = uniValSubTree(root.right);
        int[] left = uniValSubTree(root.left);

        if (root.left == null) {
            // uni sub tree
            if (right[1] == 1 && root.val == root.right.val)
                return new int[]{right[0] + 1, 1};
            // not a uni sub tree
            return new int[]{right[0], 0};
        } else if (root.right == null) {
            // uni sub tree
            if (left[1] == 1 && root.val == root.left.val)
                return new int[]{left[0] + 1, 1};
            // not a uni sub tree
            return new int[]{left[0], 0};
        } else {
            boolean bothSubTreesUniSubTrees = right[1] == 1 && left[1] == 1;
            boolean valuesMatch = root.val == root.left.val && root.val == root.right.val;
            if (bothSubTreesUniSubTrees && valuesMatch)
                return new int[]{right[0]+left[0]+1, 1};
            return new int[]{right[0]+left[0], 0};
        }
    }




    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }
}
