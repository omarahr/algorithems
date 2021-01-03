package com.company.leetcode.challenges.jan2021.clonedtree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);

        a.right = b;
        b.left = c;
        c.right = d;

        TreeNode aCloned = new TreeNode(11);
        TreeNode bCloned = new TreeNode(22);
        TreeNode cCloned = new TreeNode(33);
        TreeNode dCloned = new TreeNode(44);
        aCloned.right = bCloned;
        bCloned.left = cCloned;
        cCloned.right = dCloned;

        Solution solution = new Solution();
        TreeNode answer = solution.getTargetCopy(a, aCloned, d);
        System.out.println(answer);

    }
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public enum Direction {
        LEFT (-1),
        RIGHT(1);

        private final int dirCode;
        Direction(int dirCode) {
            this.dirCode = dirCode;
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        List<Direction> directions = new ArrayList<>();
        dfs(original, target, directions);

        TreeNode currentNode = cloned;
        for (Direction direction : directions) {
            if (direction == Direction.LEFT)
                currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }

        return currentNode;
    }

    private boolean dfs(TreeNode node, TreeNode target, List<Direction> directions) {
        if (node == null)
            return false;

        if (node == target) {
            return true;
        }

        // go left
        directions.add(Direction.LEFT);
        boolean leftResult = dfs(node.left, target, directions);

        if (leftResult)
            return true;

        directions.remove(directions.size() - 1);
        directions.add(Direction.RIGHT);
        boolean rightResult = dfs(node.right, target, directions);

        if (rightResult)
            return true;

        directions.remove(directions.size() - 1);
        return false;
    }


}
