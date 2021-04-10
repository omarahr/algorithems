package com.company.leetcode.challenges.y2021.april.week1.plaindromlinkedlist;

public class Solution {
    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(a));
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;

        ListNode current = head, next = head;

        while (next != null && next.next != null) {
            current = current.next;
            next = next.next.next;
        }

        // on even
        boolean isEvenLength = next == null;

        ListNode prev = head;
        ListNode plusOneStep = prev.next;
        prev.next = null;
        while (plusOneStep != current) {
            ListNode tmp = plusOneStep.next;
            plusOneStep.next = prev;
            prev = plusOneStep;
            plusOneStep = tmp;
        }
        return isEvenLength ? compare(prev, current) : compare(prev, current.next);
    }

    // (a <- b), c, (e, f)
    // (a <- b), (b -> a)

    private boolean compare(ListNode a, ListNode b) {
        while (a != null || b != null) {
            if (a == null || b == null)
                return false;
            if (a.val != b.val)
                return false;
            a = a.next;
            b = b.next;
        }

        return true;
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
