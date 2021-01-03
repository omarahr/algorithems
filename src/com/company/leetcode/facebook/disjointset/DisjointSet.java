package com.company.leetcode.facebook.disjointset;

public class DisjointSet {
    private int[] parent;

    DisjointSet(int n) {
        this.parent = new int[n];
        for(int i = 0; i < n; i++) this.parent[i] = i;
    }

    public int find(int i) {
        if (parent[i]==i)
            return i;

        return parent[i]=find(parent[i]);
    }

    public void union(int i, int j) {
        parent[find(i)] = parent[find(j)];
    }
}
