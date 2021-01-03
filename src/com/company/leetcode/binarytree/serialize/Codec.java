package com.company.leetcode.binarytree.serialize;


import java.util.*;

public class Codec {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        Codec codec = new Codec();
        String serialized = codec.serialize(a);
        System.out.println(serialized);
        TreeNode result = codec.deserialize(serialized);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(result);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // val*index,
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        queue.add(root);
        index.add(1);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int currentIndex = index.poll();

            if (currentIndex != 1)
                sb.append(',');


            sb.append(current.val);
            sb.append('&');
            sb.append(currentIndex);

            if (current.left != null) {
                queue.add(current.left);
                index.add(2*currentIndex);
            }

            if (current.right != null) {
                queue.add(current.right);
                index.add(2*currentIndex + 1);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        StringTokenizer st = new StringTokenizer(data, ",");

        Map<Integer, Integer> idxMap = new HashMap<>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            String[] nums = token.split("&");
            int val = Integer.parseInt(nums[0]);
            int index = Integer.parseInt(nums[1]);
            idxMap.put(index, val);
        }

        TreeNode root = new TreeNode(idxMap.get(1));
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> idxQueue = new LinkedList<>();
        queue.add(root);
        idxQueue.add(1);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int currentIndex = idxQueue.poll();

            int leftIndex = 2*currentIndex;
            int rightIndex = 2*currentIndex + 1;
            if (idxMap.containsKey(leftIndex)) {
                TreeNode left = new TreeNode(idxMap.get(leftIndex));
                current.left = left;
                queue.add(left);
                idxQueue.add(leftIndex);
            }

            if (idxMap.containsKey(rightIndex)) {
                TreeNode right = new TreeNode(idxMap.get(rightIndex));
                current.right = right;
                queue.add(right);
                idxQueue.add(rightIndex);
            }

        }

        return root;
    }
}
