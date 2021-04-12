package com.company.leetcode.challenges.y2021.march.week1.intersectionoftwolinkedlists;

import java.util.HashSet;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode itr = headA;
        while (itr != null) {
            set.add(itr);
            itr = itr.next;
        }

        itr = headB;
        while (itr != null) {
            if (set.contains(itr))
                return itr;
            itr = itr.next;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
