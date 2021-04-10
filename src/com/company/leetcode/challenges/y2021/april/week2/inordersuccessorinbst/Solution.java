package com.company.leetcode.challenges.y2021.april.week2.inordersuccessorinbst;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // if p has right child it is going to be the left most child of it is right child
    // if p has no right child it is going to be the closest parent that has p in it is left tree

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null)
            return getLeftMost(p.right);


        List<Boolean> direction = new ArrayList<>();
        List<TreeNode> parents = new ArrayList<>();


        TreeNode current = root;
        while (current != p) {
            parents.add(current);
            if (contains(current.left, p)) {
                direction.add(false);
                current = current.left;
            } else {
                direction.add(true);
                current = current.right;
            }
        }

        int index = parents.size() - 1;
        while (index >= 0) {
            if (!direction.get(index)) {
                return parents.get(index);
            }
            index--;
        }

        return null;
    }

    private boolean contains(TreeNode root, TreeNode p) {
        if (root == null)
            return false;
        return root == p || contains(root.left, p) || contains(root.right, p);
    }

    private TreeNode getLeftMost(TreeNode root) {
        TreeNode result = root;
        while (result.left != null)
            result = result.left;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);

        a.left = b;
        a.right = c;

        System.out.println(solution.inorderSuccessor(a, b).val);
    }
}
