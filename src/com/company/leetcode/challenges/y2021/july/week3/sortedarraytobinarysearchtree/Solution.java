package com.company.leetcode.challenges.y2021.july.week3.sortedarraytobinarysearchtree;

public class Solution {
    public static class TreeNode {
        int value;
        TreeNode left, right;
        TreeNode() {

        }

        TreeNode(int value) {
            this.value = value;
        }

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode binaryTree = solution.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        solution.dfs(binaryTree);
    }

    private void dfs (TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        System.out.println(root.value);
        dfs(root.right);
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return getRoot(nums, 0, nums.length  - 1);
    }

    private TreeNode getRoot(int[] nums, int indexFrom, int indexTo) {
        if (indexFrom > indexTo) {
            return null;
        }

        if (indexFrom == indexTo) {
            return new TreeNode(nums[indexFrom]);
        }

        int mid = (indexFrom + indexTo) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = getRoot(nums, indexFrom, mid - 1);
        root.right = getRoot(nums, mid + 1,indexTo);

        return root;
    }
}
