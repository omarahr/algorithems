package com.company.leetcode.challenges.y2021.jan.week2.sortedarrayinstructions;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /* Merge Sort LeetCode Solution Not Mine */
    int[] smaller, larger;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{1, 5, 6, 2};
        System.out.println(solution.createSortedArray(a));
        System.out.println(solution.createSortedArray(new int[]{1, 2, 3, 6, 5, 4}));
        System.out.println(solution.createSortedArray(new int[]{1, 3, 3, 3, 2, 4, 2, 1, 2}));
        System.out.println(solution.createSortedArray(new int[]{29, 55, 62, 176, 218, 127, 336, 175, 189, 101, 279, 316, 313, 152, 56, 97, 3, 300, 121, 78, 195, 48, 229, 263, 178, 299, 131, 19, 253, 298, 210, 281, 197, 105, 254, 153, 353, 172, 321, 136, 162, 109, 92, 201, 41, 324, 214, 347, 351, 333, 139, 359, 350, 301, 103, 100, 342, 270, 180, 242, 339, 337, 14, 312, 278, 33, 193, 304, 79, 168, 309, 43, 269, 30, 297, 198, 368, 277, 245, 17, 64, 9, 227, 129, 132, 204, 345, 118, 60, 325, 293, 323, 265, 365, 280, 311, 320, 238, 216, 340, 370, 145, 258, 160, 61, 356, 246, 341, 215, 169, 154, 23, 122, 116, 146, 349, 308, 188, 185, 8, 326, 51, 289, 16, 12, 307, 203, 42, 305, 329, 177, 10, 296, 156, 124, 24, 138, 4, 157, 234, 222, 66, 36, 181, 120, 113, 358, 171, 95, 81, 255, 174, 272, 179, 74, 275, 249, 86, 39, 167, 237, 334, 53, 76, 32, 104, 80, 46, 111, 140, 65, 196, 182, 70, 15, 47, 125, 85, 71, 364, 67, 184, 137, 276, 87, 187, 69, 244, 285, 170, 303, 286, 236, 119, 190, 68, 207, 134, 63, 352, 202, 371, 96, 148, 57, 75, 290, 166, 45, 212, 59, 144, 107, 133, 108, 273, 89, 165, 206, 261, 243, 251, 256, 295, 52, 158, 239, 20, 123, 322, 331, 93, 91, 338, 288, 274, 224, 310, 151, 34, 31, 90, 142, 37, 149, 344, 328, 283, 343, 40, 98, 264, 266, 226, 348, 6, 102, 7, 360, 49, 73, 327, 112, 5, 38, 115, 219, 217, 155, 223, 194, 128, 317, 58, 143, 77, 291, 267, 159, 335, 84, 183, 173, 208, 248, 2, 361, 13, 186, 241, 199, 50, 332, 354, 369, 205, 235, 330, 220, 161, 362, 268, 367, 233, 26, 150, 315, 1, 147, 18, 163, 284, 240, 191, 164, 22, 221, 319, 72, 262, 260, 130, 44, 25, 287, 346, 357, 314, 366, 294, 82, 141, 88, 231, 211, 29, 117, 257, 252, 282, 355, 110, 213, 94, 230, 35, 247, 114, 83, 292, 306, 363, 228, 126, 232, 209, 302, 259, 54, 27, 318, 135, 106, 200, 11, 28, 192, 99, 21, 225, 250, 271}));
    }

    public int createSortedArray(int[] instructions) {

        int n = instructions.length;
        smaller = new int[n];
        larger = new int[n];

        long cost = 0;
        long mod = 1000000007;

        int[][] arrSmaller = new int[n][];
        int[][] arrLarger = new int[n][];
        for (int i = 0; i < n; i++) {
            arrSmaller[i] = new int[]{instructions[i], i};
            arrLarger[i] = new int[]{instructions[i], i};
        }

        sortSmaller(arrSmaller, 0, n - 1);
        sortLarger(arrLarger, 0, n - 1);

        for (int i = 0; i < n; i++) {
            cost += Math.min(smaller[i], larger[i]);
        }

        return (int) (cost % mod);
    }

    private void sortSmaller(int[][] arr, int left, int right) {
        if (left == right)
            return;

        int mid = (left + right) / 2;
        sortSmaller(arr, left, mid);
        sortSmaller(arr, mid + 1, right);
        mergeSmaller(arr, left, mid, right);
    }

    private void mergeSmaller(int[][] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        List<int[]> temp = new ArrayList<>();
        while (i <= mid && j <= right) {
            if (arr[i][0] < arr[j][0]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                smaller[arr[j][1]] += i - left;
                j++;
            }
        }

        while (i <= mid) {
            temp.add(arr[i]);
            i++;
        }

        while (j <= right) {
            temp.add(arr[j]);
            smaller[arr[j][1]] += i - left;
            j++;
        }


        for (int d = 0, f = left; f <= right; d++, f++)
            arr[f] = temp.get(d);
    }


    private void sortLarger(int[][] arr, int left, int right) {
        if (left == right)
            return;

        int mid = (left + right) / 2;
        sortLarger(arr, left, mid);
        sortLarger(arr, mid + 1, right);
        mergeLarger(arr, left, mid, right);
    }

    private void mergeLarger(int[][] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;

        List<int[]> temp = new ArrayList<>();

        while (i <= mid && j <= right) {
            if (arr[i][0] <= arr[j][0]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                larger[arr[j][1]] += mid - i + 1;
                j++;
            }
        }

        while (i <= mid) {
            temp.add(arr[i]);
            i++;
        }

        while (j <= right) {
            temp.add(arr[j]);
            larger[arr[j][1]] += mid - i + 1;
            j++;
        }

        for (int x = left, d = 0; x <= right; d++, x++)
            arr[x] = temp.get(d);
    }

    /*My Own Solution Slow but it's okay the normal alternative is segment tree or bit*/
    public int createSortedArraySlow(int[] instructions) {
        if (instructions.length == 0)
            return 0;

        int max = 1000000007;
        Node root = new Node(instructions[0]);
        int cost = 0;
        for (int i = 1; i < instructions.length; i++) {
            int result = insertNode(root, instructions[i]);
            cost = (cost % max + result % max) % max;
        }

        return cost;
    }

    private int insertNode(Node root, int node_val) {
        Node current = root;
        int less = 0, more = 0;
        while (current != null) {
            if (current.val < node_val) {
                less += current.lSize + current.size;
                current.rSize++;
                if (current.right == null) {
                    current.right = new Node(node_val);
                    return Math.min(less, more);
                }
                current = current.right;
            } else if (current.val > node_val) {
                more += current.rSize + current.size;
                current.lSize++;
                if (current.left == null) {
                    current.left = new Node(node_val);
                    return Math.min(less, more);
                }
                current = current.left;
            } else {
                more += current.rSize;
                less += current.lSize;
                current.size++;
                return Math.min(less, more);
            }
        }
        return 0;
    }

    public static class Node {
        int val, lSize, rSize;
        int size = 1;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

    }
}
