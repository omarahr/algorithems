package com.company.leetcode.challenges.y2021.may.week1.sortedlisttobinarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> values = new ArrayList<>();

        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        return createFromList(0, values.size() - 1, values);
    }

    private TreeNode createFromList(int start, int end, List<Integer> values) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(values.get(start));
        }

        int mid = start + ((end - start) / 2);
        TreeNode rightSubTree = createFromList(mid + 1, end, values);
        TreeNode leftSubTree = createFromList(start, mid - 1, values);
        return  new TreeNode(values.get(mid), leftSubTree, rightSubTree);
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(-1, new ListNode(0, new ListNode(1, null)));
        Solution solution = new Solution();
        TreeNode treeRoot = solution.sortedListToBST(root);
        System.out.println(treeRoot.val);
    }
}
