package com.company.leetcode.challenges.jan2021.mergetwosortedlists;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode b = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList = solution.mergeTwoLists(a, b);
        ListNode current = mergedList;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;

        ListNode head = new ListNode();
        ListNode prev = head;
        while (a != null || b != null) {
            if (a == null) {
                while (b != null) {
                    prev.next = b;
                    b = b.next;
                    prev = prev.next;
                }
            } else if (b == null) {
                while (a != null) {
                    prev.next = a;
                    a = a.next;
                    prev = prev.next;
                }
            } else {
                if (a.val > b.val) {
                    prev.next = b;
                    b = b.next;
                } else {
                    prev.next = a;
                    a = a.next;
                }
                prev = prev.next;
            }
        }

        return head.next;
    }
}
