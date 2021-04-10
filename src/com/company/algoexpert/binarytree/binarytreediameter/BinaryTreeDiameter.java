package com.company.algoexpert.binarytree.binarytreediameter;

public class BinaryTreeDiameter {

    private static int max;

    public int binaryTreeDiameter(BinaryTree tree) {
        if (tree == null)
            return 0;

        max = 0;

        dfs(tree);

        return max;
    }

    private int dfs(BinaryTree tree) {
        if (tree == null)
            return 0;

        if (tree.left == null && tree.right == null)
            return 0;

        int leftLen = dfs(tree.left);
        int rightLen = dfs(tree.right);

        int result = 1 + Math.max(leftLen, rightLen);

        int withRight = tree.right == null ? 0 : 1 + rightLen;
        int withLeft = tree.left == null ? 0 : 1 + leftLen;


        max = Math.max(max, Math.max(result, withLeft + withRight));

        return result;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
