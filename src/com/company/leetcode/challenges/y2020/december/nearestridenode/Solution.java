package com.company.leetcode.challenges.y2020.december.nearestridenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {

    }

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {

        // get node level
        Integer targetLevel = getNodeLevel(root, 0, u);

        List<TreeNode> level = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.add(root);
        levels.add(0);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            int currentLevel = levels.poll();

            if (currentLevel == targetLevel) {
                level.add(currentNode);
            }

            if (currentLevel > targetLevel) {
                break;
            }

            if (currentNode.left != null) {
                queue.add(currentNode.left);
                levels.add(currentLevel + 1);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
                levels.add(currentLevel + 1);
            }
        }

        TreeNode rightNextNode = null;
        for (int i = 0; i < level.size() - 1; i++) {
            if (level.get(i) == u) {
                rightNextNode = level.get(i + 1);
                break;
            }
        }


        return rightNextNode;
    }

    private Integer getNodeLevel(TreeNode root, Integer level, TreeNode target) {
        if (root == null)
            return null;

        if (root == target)
            return level;

        Integer levelFromLeft = getNodeLevel(root.left, level + 1, target);
        Integer levelFromRight = getNodeLevel(root.right, level + 1, target);

        return levelFromLeft == null ? levelFromRight : levelFromLeft;
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode() {
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
