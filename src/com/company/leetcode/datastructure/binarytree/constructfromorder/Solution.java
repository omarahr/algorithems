package com.company.leetcode.datastructure.binarytree.constructfromorder;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int postorder_idx;
    int preorder_idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorder_idx = postorder.length - 1;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            indexMap.put(inorder[i], i);
        return buildTreePostOrder(postorder, 0, inorder.length - 1, indexMap);
    }

    public TreeNode buildTree2(int[] inorder, int[] preorder) {
        preorder_idx = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            indexMap.put(inorder[i], i);
        return buildTreePreOrder(preorder, 0, inorder.length - 1, indexMap);
    }

    private TreeNode buildTreePostOrder(int[] postorder,
                                        int left_idx,
                                        int right_idx,
                                        Map<Integer, Integer> indexMap) {
        if (left_idx > right_idx)
            return null;

        int root_val = postorder[postorder_idx];

        TreeNode root = new TreeNode(root_val);

        int split_index = indexMap.get(root_val);

        postorder_idx--;

        root.right = buildTreePostOrder(postorder, split_index + 1, right_idx, indexMap);
        root.left = buildTreePostOrder(postorder, left_idx, split_index - 1, indexMap);

        return root;
    }

    private TreeNode buildTreePreOrder(int[] preorder,
                                       int left_idx,
                                       int right_idx,
                                       Map<Integer, Integer> indexMap) {
        if (left_idx > right_idx)
            return null;

        int root_val = preorder[preorder_idx];

        TreeNode root = new TreeNode(root_val);

        int split_index = indexMap.get(root_val);

        preorder_idx++;

        root.left = buildTreePreOrder(preorder, left_idx, split_index - 1, indexMap);
        root.right = buildTreePreOrder(preorder, split_index + 1, right_idx, indexMap);

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
