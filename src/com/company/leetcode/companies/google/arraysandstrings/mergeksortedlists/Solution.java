package com.company.leetcode.companies.google.arraysandstrings.mergeksortedlists;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode aa = new ListNode(1);
        ListNode ab = new ListNode(3);
        ListNode ac = new ListNode(5);
        aa.next = ab;
        ab.next = ac;

        ListNode ba = new ListNode(2);
        ListNode bb = new ListNode(4);
        ListNode bc = new ListNode(6);
        ba.next = bb;
        bb.next = bc;


        ListNode[] lists = new ListNode[]{aa, ba};
        ListNode current = solution.mergeKLists(lists);
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return lists[startIndex];
        }

        if (startIndex + 1 == endIndex) {
            return merge(lists[startIndex], lists[endIndex]);
        }


        int mid = (startIndex + endIndex) / 2;

        return merge(mergeKLists(lists, startIndex, mid), mergeKLists(lists, mid + 1, endIndex));
    }

    private ListNode merge(ListNode a, ListNode b) {
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
