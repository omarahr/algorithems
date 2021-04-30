package com.company.leetcode.companies.facebook.recursion.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.permute(new int[]{1, 2, 3});
        for (List<Integer> permutation : result) {
            permutation.forEach(System.out::print);
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permuteRe(0, nums, results, new HashSet<>());
        return results;
    }


    private void permuteRe(int index, int[] nums, List<List<Integer>> results, HashSet<String> set) {
        if (index == nums.length - 1) {
            ArrayList<Integer> permutation = new ArrayList<>();
            Arrays.stream(nums).forEach(permutation::add);
            String arrStr = permutation.toString();
            if (!set.contains(arrStr)) {
                set.add(arrStr);
                results.add(permutation);
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(index, i, nums);
            permuteRe(index + 1, nums, results, set);
            swap(index, i, nums);
        }

    }

    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}
