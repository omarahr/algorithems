package com.company.leetcode.challenges.y2021.march.week1.intersectionoftwolinkedlists;

import java.util.*;

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

    public static int connectedSum(int n, List<String> edges) {
        boolean[] visited = new boolean[n+1];

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (String edge : edges) {
            StringTokenizer st = new StringTokenizer(edge);
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            graph.get(nodeA).add(nodeB);
            graph.get(nodeB).add(nodeA);
        }

        int sum = 0;
        for(int i = 0; i <= n; i++) {
            if(!visited[i]) {
                // travers
                List<Integer> connectedNodes = graph.get(i);
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                queue.addAll(connectedNodes);
                double nodeCount = 0;
                while(!queue.isEmpty()) {
                    int currentNode = queue.poll();
                    if(!visited[currentNode]) {
                        nodeCount++;
                        visited[currentNode] = true;
                        List<Integer> currentNodeConnectedNodes = graph.get(currentNode);
                        for(int neighbour : currentNodeConnectedNodes) {
                            if(!visited[neighbour]) {
                                queue.add(neighbour);
                            }
                        }
                    }
                }

                sum += Math.ceil(Math.sqrt(nodeCount));
            }
        }


        return sum;
    }

    public static void main(String[] args) {

    }
}
