package com.company.leetcode.challenges.y2021.jan.week2.mergetwosortedarrays;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] a = new int[]{1,2,3,0,0,0};
        int[] a = new int[]{1};
//        int[] b = new int[]{2,5,6};
        int[] b = new int[]{};

        solution.merge(a, 1, b, 0);
        System.out.println(Arrays.toString(a));
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m - 1, j = nums1.length - 1; i >= 0; i--, j--) {
            nums1[j] = nums1[i];
        }

        int index1 = nums1.length - m, index2 = 0, index = 0;
        while (index1 < nums1.length && index2 < n) {
            if (nums1[index1] <= nums2[index2]) {
                nums1[index] = nums1[index1];
                index1++;
            } else {
                nums1[index] = nums2[index2];
                index2++;
            }
            index++;
        }

        while (index1 < nums1.length) {
            nums1[index++] = nums1[index1++];
        }

        while (index2 < nums2.length) {
            nums1[index++] = nums2[index2++];
        }
    }
}
