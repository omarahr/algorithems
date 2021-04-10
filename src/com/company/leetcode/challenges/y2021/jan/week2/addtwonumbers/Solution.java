package com.company.leetcode.challenges.y2021.jan.week2.addtwonumbers;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode a = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode b = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        ListNode result = solution.addTwoNumbers(a, b);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();

        ListNode prev = head;
        int rem = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + rem;
            int val = sum % 10;
            rem = sum / 10;

            prev.next = new ListNode(val);

            l1 = l1.next;
            l2 = l2.next;
            prev = prev.next;
        }

        while (l1 != null) {
            int sum = l1.val + rem;
            int val = sum % 10;
            rem = sum / 10;

            prev.next = new ListNode(val);
            l1 = l1.next;
            prev = prev.next;
        }

        while (l2 != null) {
            int sum = l2.val + rem;
            int val = sum % 10;
            rem = sum / 10;

            prev.next = new ListNode(val);
            l2 = l2.next;
            prev = prev.next;
        }

        while (rem != 0) {
            int val = rem % 10;
            rem /= 10;
            prev.next = new ListNode(val);
            prev = prev.next;
        }


        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }
    }
}
