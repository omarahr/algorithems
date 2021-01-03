package com.company.leetcode.december2020.balancedbinarytree;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int difference = Math.abs(getHeight(root.left) - getHeight(root.right));
        return difference < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode();
        TreeNode b = new TreeNode();
        TreeNode c = new TreeNode();
        TreeNode d = new TreeNode();
        TreeNode e = new TreeNode();

        a.left = b;
        b.right = c;
        c.left = d;
        d.right = e;

        Solution solution = new Solution();
        System.out.println(solution.isBalanced(a));
    }





    public static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
