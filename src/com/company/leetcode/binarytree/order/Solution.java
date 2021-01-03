package com.company.leetcode.binarytree.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        queue.add(root);
        levels.add(0);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            int currentLevel = levels.poll();

            while (result.size() <= currentLevel) {
                result.add(new ArrayList<>());
            }

            result.get(currentLevel).add(currentNode.val);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
                levels.add(currentLevel + 1);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
                levels.add(currentLevel + 1);
            }
        }

        return result;
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
