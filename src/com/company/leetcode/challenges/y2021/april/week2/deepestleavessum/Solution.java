package com.company.leetcode.challenges.y2021.april.week2.deepestleavessum;

import java.util.Stack;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    public static class Pair {
        int val, level;

        Pair(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }

    public int deepestLeavesSum(TreeNode root) {

        Stack<Pair> deepest = new Stack<>();

        dfs(root, 0, deepest);

        return  deepest.stream().mapToInt(p -> p.val).sum();
    }

    private void dfs(TreeNode root, int level, Stack<Pair> stack) {
        if (root == null)
            return;

        if (stack.isEmpty()) {
            stack.add(new Pair(root.val, level));
        } else {
            if (stack.peek().level < level) {
                stack.clear();
                stack.add(new Pair(root.val, level));
            } else if (stack.peek().level == level) {
                stack.add(new Pair(root.val, level));
            }
        }

        dfs(root.left, 1 + level, stack);
        dfs(root.right, 1 + level, stack);
    }


    public static void main(String[] args) {

    }
}
