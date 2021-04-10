package com.company.leetcode.facebook.graphs;

import java.util.*;

public class BinarySearchTree {
    /*
    [["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],["David","David4@m.co","David5@m.co"],["David","David2@m.co","David3@m.co"],["David","David1@m.co","David2@m.co"]]

    [["David","David0@m.co","David1@m.co","David2@m.co"],["David","David2@m.co","David3@m.co","David4@m.co","David5@m.co"]]

    [["David","David0@m.co","David1@m.co","David2@m.co","David3@m.co","David4@m.co","David5@m.co"]]
     */
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("David", "David0@m.co", "David1@m.co"));
        accounts.add(Arrays.asList("David", "David3@m.co", "David4@m.co"));
        accounts.add(Arrays.asList("David", "David4@m.co", "David5@m.co"));
        accounts.add(Arrays.asList("David", "David2@m.co", "David3@m.co"));
        accounts.add(Arrays.asList("David", "David1@m.co", "David2@m.co"));

        BinarySearchTree main = new BinarySearchTree();

        System.out.println(Arrays.toString(main.accountsMerge(accounts).toArray()));
    }

    public Node treeToDoublyList(Node root) {
        ArrayList<Node> orderedNodes = new ArrayList<>();
        inOrderTraversal(root, orderedNodes);

        if (orderedNodes.isEmpty())
            return root;

        for (int i = 0; i < orderedNodes.size() - 1; i++) {
            Node from = orderedNodes.get(i);
            Node to = orderedNodes.get(i + 1);
            from.right = to;
            to.left = from;
        }

        Node lastNode = orderedNodes.get(orderedNodes.size() - 1);
        Node firstNode = orderedNodes.get(0);

        lastNode.right = firstNode;
        firstNode.left = lastNode;

        return firstNode;
    }

    private void inOrderTraversal(Node root, ArrayList<Node> orderedNodes) {
        if (root == null)
            return;

        inOrderTraversal(root.left, orderedNodes);
        orderedNodes.add(root);
        inOrderTraversal(root.right, orderedNodes);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accountsSize = accounts.size();

        DisjointSet set = new DisjointSet(accountsSize);

        for (int i = 0; i < accountsSize; i++) {
            List<String> current = accounts.get(i);
            for (int j = i + 1; j < accountsSize; j++) {
                List<String> next = accounts.get(j);
                if (canBeMerged(current, next)) {
                    set.union(i, j);
                }
            }
        }

        List<List<List<String>>> groups = new ArrayList<>();
        for (int i = 0; i < accountsSize; i++) groups.add(new ArrayList<>());
        for (int i = 0; i < accountsSize; i++) groups.get(set.find(i)).add(accounts.get(i));


        List<List<String>> mergedAccounts = new ArrayList<>();

        for (List<List<String>> group : groups) {
            if (!group.isEmpty()) {
                mergedAccounts.add(merge(group));
            }
        }


        return mergedAccounts;
    }

    private boolean canBeMerged(List<String> current, List<String> next) {
        if (!current.get(0).equals(next.get(0)))
            return false;

        HashSet<String> emails = new HashSet<>();
        for (int i = 1; i < current.size(); i++) emails.add(current.get(i));

        for (int i = 1; i < next.size(); i++)
            if (emails.contains(next.get(i)))
                return true;
        return false;
    }

    private List<String> merge(List<List<String>> group) {
        HashSet<String> emails = new HashSet<>();
        for (List<String> item : group)
            for (int i = 1; i < item.size(); i++)
                emails.add(item.get(i));


        String name = group.get(0).get(0);
        List<String> mergedGroup = new ArrayList<>(emails);
        Collections.sort(mergedGroup);
        mergedGroup.add(0, name);
        return mergedGroup;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static class DisjointSet {
        int[] parent;

        DisjointSet(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] == x)
                return x;

            return parent[x] = find(parent[x]);
        }

        void union(int a, int b) {
            parent[find(a)] = parent[find(b)];
        }


    }
}
