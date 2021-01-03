package com.company.leetcode.facebook.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);


        a.next = b;
        b.next = c;
//        c.next = d;


        main.reorderList(a);

        System.out.println(a.next);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}

    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNumber = l1;
        ListNode secondNumber = l2;
        ListNode result = new ListNode();
        ListNode pointer = result;

        int carry = 0;

        while (!isAdditionFinished(firstNumber, secondNumber, carry)) {
            int firstVal = firstNumber != null ? firstNumber.val : 0;
            int secondVal = secondNumber != null ? secondNumber.val : 0;
            int sum = firstVal + secondVal + carry;
            int stepDigit = sum % 10;
            carry = sum / 10;

            pointer.next = new ListNode(stepDigit);
            pointer = pointer.next;

            firstNumber = getNext(firstNumber);
            secondNumber= getNext(secondNumber);
        }

        return result == pointer ? new ListNode(0) : result.next;
    }

    private boolean isAdditionFinished(ListNode a, ListNode b, int carry) {
        return a == null && b == null && carry == 0;
    }

    private ListNode getNext(ListNode node) {
        return node == null || node.next == null ? null : node.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode firstListNode = l1;
        ListNode secondListNode = l2;
        ListNode mergedList = new ListNode();
        ListNode pointer = mergedList;

        while (!isListsFinished(firstListNode, secondListNode)) {
            if (isListEmpty(firstListNode)) {
                while (!isListEmpty(secondListNode)) {
                    pointer.next = secondListNode;
                    pointer = pointer.next;
                    secondListNode = secondListNode.next;
                }
            } else if (isListEmpty(secondListNode)) {
                while (!isListEmpty(firstListNode)) {
                    pointer.next = firstListNode;
                    pointer = pointer.next;
                    firstListNode = firstListNode.next;
                }
            } else {
                if (firstListNode.val <= secondListNode.val) {
                    pointer.next = firstListNode;
                    pointer = pointer.next;
                    firstListNode = firstListNode.next;
                } else {
                    pointer.next = secondListNode;
                    pointer = pointer.next;
                    secondListNode = secondListNode.next;
                }
            }
        }

        return mergedList == pointer ? l1 : mergedList.next;
    }

    private boolean isListsFinished(ListNode firstList, ListNode secondList) {
        return isListEmpty(firstList) && isListEmpty(secondList);
    }

    private boolean isListEmpty(ListNode node) {
        return node == null;
    }


    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node result = new Node(-1);
        Node copyPointer = result;

        Node currentNode = head;

        while (currentNode != null) {
            Node copyNode = new Node(currentNode.val);
            copyNode.next = currentNode.next;
            currentNode.next = copyNode;
            currentNode = copyNode.next;
        }

        currentNode = head;
        while (currentNode != null) {
            Node random = currentNode.random;
            if (random != null) {
                Node copyNode = currentNode.next;
                copyNode.random = random.next;
            }
            currentNode = currentNode.next.next;
        }

        currentNode = head;
        while (currentNode != null) {
            copyPointer.next = currentNode.next;
            currentNode.next = copyPointer.next.next;

            copyPointer = copyPointer.next;
            currentNode = currentNode.next;
        }

        return result.next;
    }

    private static HashMap<Node, Node> visitedNodes = new HashMap<>();
    public Node copyRandomListV2(Node head) {
        if(head == null)
            return null;

        if (visitedNodes.containsKey(head))
            return visitedNodes.get(head);


        Node copyNode = new Node(head.val);

        visitedNodes.put(head, copyNode);

        copyNode.next = copyRandomListV2(head.next);
        copyNode.random = copyRandomListV2(head.random);

        return copyNode;
    }

    public void reorderList(ListNode head) {
        ArrayList<ListNode> indexedList = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            indexedList.add(currentNode);
            currentNode = currentNode.next;
        }

        for (int i = 0, j = indexedList.size() - 1; i <= j; i++, j--) {
            ListNode rear = indexedList.get(j);
            ListNode front = indexedList.get(i);

            if (i + 1== j) {
                rear.next = null;
                continue;
            } else if (i == j) {
                rear.next = null;
            } else {
                rear.next = front.next;
                front.next = rear;
            }
        }
    }

}
