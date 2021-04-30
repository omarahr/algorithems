package com.company.leetcode.datastructure.binarytree.symmetrictree;

public class Solution {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
//        TreeNode b = new TreeNode(4);

        TreeNode aa = new TreeNode(3);
//        TreeNode bb = new TreeNode(4);

        TreeNode c = new TreeNode(2, null, a);
        TreeNode cc = new TreeNode(2, null, aa);

        TreeNode d = new TreeNode(1, c, cc);

        Solution solution = new Solution();

        System.out.println(solution.isSymmetric(d));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        TreeNode mirrored = mirrorTree(root.left);
        return isSame(mirrored, root.right);
    }

    private boolean isSame(TreeNode nodeA, TreeNode nodeB) {
        if (nodeA == null && nodeB == null)
            return true;

        if (nodeA == null || nodeB == null)
            return false;

        if (nodeA.val != nodeB.val)
            return false;

        return isSame(nodeA.left, nodeB.left) && isSame(nodeA.right, nodeB.right);
    }

    private TreeNode mirrorTree(TreeNode node) {
        if (node == null)
            return null;

        return new TreeNode(node.val, mirrorTree(node.right), mirrorTree(node.left));
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
            this.left = left;
            this.right = right;
        }
    }
}
