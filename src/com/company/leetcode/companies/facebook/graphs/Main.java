package com.company.leetcode.companies.facebook.graphs;

import java.util.*;

public class Main {

    private static List<String> paths = new ArrayList<>();
    private static TreeNode answer = null;
    private static int maxSum = Integer.MIN_VALUE;
    private static int max = 0;

    public static void main(String[] args) {
        Main main = new Main();

        String[] words = new String[]{"abc", "ab"};
        int[][] map = new int[][]{{1, 1}, {0, 1}};

        System.out.println(main.alienOrder(words));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        paths = new ArrayList<>();
        dfs(root, "");
        return paths;
    }

    private void dfs(TreeNode root, String path) {
        if (root == null) return;

        path = path.equals("") ? root.val + "" : path + "->" + root.val;

        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }

        dfs(root.left, path);
        dfs(root.right, path);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean goRight = containsTreeNode(root.right, p) && containsTreeNode(root.right, q);
        boolean goLeft = containsTreeNode(root.left, p) && containsTreeNode(root.left, q);

        if (goRight)
            return lowestCommonAncestor(root.right, p, q);

        if (goLeft)
            return lowestCommonAncestor(root.left, p, q);

        return root;
    }

    private boolean containsTreeNode(TreeNode root, TreeNode p) {
        if (root == null)
            return false;

        if (root == p)
            return true;

        return containsTreeNode(root.right, p) | containsTreeNode(root.left, p);
    }

    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        int right = recurseTree(root.right, p, q) ? 1 : 0;
        int left = recurseTree(root.left, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;

        if (mid + left + right >= 2)
            answer = root;

        return (mid + left + right > 0);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> levelGroups = new ArrayList<>();

        if (root == null)
            return levelGroups;

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        nodes.add(root);
        levels.add(0);
        while (!nodes.isEmpty()) {
            TreeNode currentNode = nodes.poll();
            int currentLevel = levels.poll();

            if (currentLevel == levelGroups.size())
                levelGroups.add(currentNode.val);
            else levelGroups.set(currentLevel, currentNode.val);

            if (currentNode.left != null) {
                nodes.add(currentNode.left);
                levels.add(currentLevel + 1);
            }

            if (currentNode.right != null) {
                nodes.add(currentNode.right);
                levels.add(currentLevel + 1);
            }
        }

        return levelGroups;
    }

    public int maxPathSum(TreeNode root) {
        traversBinaryTree(root);
        return maxSum;
    }

    private int traversBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxLeft = Math.max(traversBinaryTree(root.left), 0);
        int maxRight = Math.max(traversBinaryTree(root.right), 0);

        int fullPathGain = root.val + maxLeft + maxRight;
        maxSum = Math.max(maxSum, fullPathGain);

        return root.val + Math.max(maxLeft, maxRight);
    }


    public boolean isValidBST(TreeNode root) {
        return isValidBst(root, null, null);
    }

    public boolean isValidBst(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        boolean isLeftSubTreeValid = true;
        boolean isRightSubTreeValid = true;

        if (root.left != null) {
            if (root.left.val >= root.val)
                return false;

            if (min != null && root.left.val <= min)
                return false;

            isLeftSubTreeValid = isValidBst(root.left, min, root.val);
        }

        if (root.right != null) {
            if (root.right.val <= root.val)
                return false;

            if (max != null && root.right.val >= max)
                return false;

            isRightSubTreeValid = isValidBst(root.right, root.val, max);
        }


        return isLeftSubTreeValid && isRightSubTreeValid;
    }

    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    public TreeNode flattenTree(TreeNode root) {
        if (root == null)
            return null;


        TreeNode right = root.right;
        TreeNode left = root.left;
        TreeNode leftTail = flattenTree(root.left);
        TreeNode rightTail = flattenTree(root.right);

        root.left = null;

        if (left == null) {
            root.right = right;
            return rightTail != null ? rightTail : root;
        }

        root.right = left;
        leftTail.right = right;
        return rightTail != null ? rightTail : leftTail;
    }


    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int height = grid.length;
        int width = grid[0].length;
        boolean[][] visited = new boolean[height][width];

        int counter = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    counter++;
                    dfs(i, j, visited, grid);
                }
            }
        }

        return counter;
    }

    private void dfs(int i, int j, boolean[][] visited, char[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        if (i < 0 || i >= height || j < 0 || j >= width)
            return;

        if (grid[i][j] != '1' || visited[i][j])
            return;

        visited[i][j] = true;

        dfs(i + 1, j, visited, grid);
        dfs(i - 1, j, visited, grid);
        dfs(i, j + 1, visited, grid);
        dfs(i, j - 1, visited, grid);
    }

    public String alienOrder(String[] words) {
        if (words.length == 1)
            return words[0];

        List<List<String>> dictionary = new ArrayList<>();
        dictionary.add(Arrays.asList(words));

        HashMap<Character, Node> map = new HashMap<>();


        while (!dictionary.isEmpty()) {
            List<List<String>> temp = new ArrayList<>();
            for (List<String> group : dictionary) {
                if (group.size() == 1) {
                    char from = group.get(0).charAt(0);
                    if (!map.containsKey(from)) {
                        map.put(from, new Node(from));
                    }
                }

                for (int i = 0; i < group.size() - 1; i++) {
                    char from = group.get(i).charAt(0);
                    char to = group.get(i + 1).charAt(0);
                    boolean isCharacterDifferent = from != to;

                    if (!map.containsKey(from)) {
                        map.put(from, new Node(from));
                    }

                    if (!map.containsKey(to)) {
                        map.put(to, new Node(to));
                    }

                    if (isCharacterDifferent) {
                        Node fromNode = map.get(from);
                        Node toNode = map.get(to);

                        fromNode.addItem(toNode);
                    }
                }

                List<List<String>> filteredGroups = new ArrayList<>();
                for (int i = 0; i < 26; i++) filteredGroups.add(new ArrayList<>());
                for (String word : group) {
                    char from = word.charAt(0);
                    if (word.length() > 1) {
                        filteredGroups.get(from - 'a').add(word.substring(1));
                    } else if (filteredGroups.get(from - 'a').size() != 0) {
                        return "";
                    }
                }

                for (List<String> filterGroup : filteredGroups) {
                    if (filterGroup.size() > 0)
                        temp.add(filterGroup);
                }

            }

            dictionary = temp;
        }


        Queue<Node> queue = new LinkedList<>();
        StringBuilder answer = new StringBuilder();


        for (Map.Entry<Character, Node> entry : map.entrySet()) {
            Node current = entry.getValue();
            for (Node node : current.children) {
                node.increaseInbound();
            }
        }

        while (!map.isEmpty()) {
            for (Map.Entry<Character, Node> entry : map.entrySet()) {
                Node current = entry.getValue();
                if (current.inBound == 0) {
                    queue.add(current);
                }
            }

            if (queue.isEmpty())
                return "";

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                map.remove(node.val);
                for (Node current : node.children) {
                    current.decreaseInbound();
                }
                answer.append(node.val);
            }
        }

        return answer.toString();
    }

    public int shortestDistance(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        List<Pair> buildings = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    buildings.add(new Pair(i, j, 0));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 0) {
                    int[][] result = shortestDistance(i, j, grid);
                    int sum = 0;
                    boolean invalid = false;
                    for (Pair building : buildings) {
                        int distanceToBuilding = result[building.x][building.y];
                        if (distanceToBuilding == 0)
                            invalid = true;
                        sum += distanceToBuilding;
                    }

                    if (!invalid)
                        min = Math.min(min, sum);
                }

            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int[][] shortestDistance(int x, int y, int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] distance = new int[height][width];
        boolean[][] visited = new boolean[height][width];

        Queue<Pair> points = new LinkedList<>();

        points.add(new Pair(x, y, 0));

        while (!points.isEmpty()) {
            Pair current = points.poll();
            if (current.x < 0 || current.y < 0 || current.x >= height || current.y >= width)
                continue;

            if (visited[current.x][current.y] || grid[current.x][current.y] == 2)
                continue;

            visited[current.x][current.y] = true;
            distance[current.x][current.y] = current.distance;

            if (grid[current.x][current.y] == 1)
                continue;

            points.add(new Pair(current.x + 1, current.y, current.distance + 1));
            points.add(new Pair(current.x - 1, current.y, current.distance + 1));
            points.add(new Pair(current.x, current.y + 1, current.distance + 1));
            points.add(new Pair(current.x, current.y - 1, current.distance + 1));
        }

        return distance;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        diameterOfBinaryTreeTraversal(root);
        return max;
    }

    public int diameterOfBinaryTreeTraversal(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 0;


        int leftLength = diameterOfBinaryTreeTraversal(root.left);
        int rightLength = diameterOfBinaryTreeTraversal(root.right);

        int result = 1 + Math.max(leftLength, rightLength);

        int withRight = root.right == null ? 0 : 1 + rightLength;
        int withLeft = root.left == null ? 0 : 1 + leftLength;

        max = Math.max(max, Math.max(result, withLeft + withRight));
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Node {
        char val;
        Set<Node> children;
        int inBound;

        Node(char val) {
            this.val = val;
            inBound = 0;
            children = new HashSet<>();
        }

        void addItem(Node child) {
            children.add(child);
        }

        void increaseInbound() {
            this.inBound++;
        }

        void decreaseInbound() {
            this.inBound--;
        }

    }

    public static class Pair {
        int x, y, distance;

        Pair(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }


}
