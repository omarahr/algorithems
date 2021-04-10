package com.company.leetcode.challenges.y2021.jan.week1.removedubs;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        printSolution(solution.deleteDuplicates(a));

        ListNode b = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        printSolution(solution.deleteDuplicates(b));

        ListNode c = new ListNode(1);
        printSolution(solution.deleteDuplicates(c));

        ListNode d = new ListNode(1, new ListNode(2, new ListNode(2)));
        printSolution(solution.deleteDuplicates(d));

        ListNode e = new ListNode(1, new ListNode(1));
        printSolution(solution.deleteDuplicates(e));

        printSolution(solution.deleteDuplicates(null));
    }

    private static void printSolution(ListNode result) {
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println("**********************");
    }

    // The list is guaranteed to be sorted in ascending order.
    // -100 <= Node.val <= 100
    public ListNode deleteDuplicates(ListNode head) {

        ListNode resultHead = new ListNode(-101);

        ListNode current = head;
        ListNode prev = resultHead;
        int prevNodeValue = resultHead.val;

        while (current != null) {
            if (prevNodeValue != current.val) {
                if (current.next != null) {
                    if (current.next.val != current.val) {
                        prev.next = current;
                        prev = prev.next;
                    }
                } else {
                    prev.next = current;
                    prev = prev.next;
                }
            }
            prevNodeValue = current.val;
            current = current.next;
            prev.next = null;
        }

        return resultHead.next;
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
}
