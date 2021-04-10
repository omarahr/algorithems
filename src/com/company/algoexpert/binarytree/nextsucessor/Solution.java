package com.company.algoexpert.binarytree.nextsucessor;

public class Solution {


    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if (node.right != null)
            return getLeftMostChild(node.right);

        return getRightMostParent(node);
    }

    private BinaryTree getRightMostParent(BinaryTree node) {
        BinaryTree current = node;
        while (current.parent != null && current.parent.right == current)
            current = current.parent;
        return current;
    }

    private BinaryTree getLeftMostChild(BinaryTree node) {
        BinaryTree current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
