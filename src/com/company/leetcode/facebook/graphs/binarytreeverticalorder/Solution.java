package com.company.leetcode.facebook.graphs.binarytreeverticalorder;

import java.util.*;

public class Solution {
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


    public static class Column {
        int index;
        List<Integer> items;

        public Column(int index) {
            this.index = index;
            items = new ArrayList<>();
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Map<Integer, Column> indexToColumn = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        q.add(root);
        index.add(0);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            int currentIndex = index.poll();

            indexToColumn
                    .computeIfAbsent(currentIndex, k -> new Column(currentIndex))
                    .items.add(current.val);

            if (current.left != null) {
                q.add(current.left);
                index.add(currentIndex - 1);
            }

            if (current.right != null) {
                q.add(current.right);
                index.add(currentIndex + 1);
            }
        }


        List<Column> columns = new ArrayList<>(indexToColumn.values());
        columns.sort(Comparator.comparingInt(o -> o.index));

        List<List<Integer>> result = new ArrayList<>();
        for (Column column: columns) {
            result.add(column.items);
        }

        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Solution solution = new Solution();
        List<List<Integer>> result = solution.verticalOrder(root);
        for (List<Integer> col : result) {
            for(int item : col) {
                System.out.print(item +" ");
            }
            System.out.println();
        }
    }
}
