package com.company.leetcode.challenges.y2021.may.week1.prefixandsuffixsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    static class WordFilter {
        ArrayList<String[]> prefix;
        ArrayList<String[]> suffix;


        HashMap<String, Integer> wordsToOriginalIndex = new HashMap<>();
        HashMap<Integer, String> internalIndexToWords = new HashMap<>();

        public WordFilter(String[] words) {
            int internalSize = 0;

            this.prefix = new ArrayList<>();
            this.suffix = new ArrayList<>();

            HashSet<String> wordsSet = new HashSet<>();

            for (int i = 0; i < words.length; i++) {
                String currentWord = words[i];

                if (wordsSet.contains(currentWord)) {
                    this.wordsToOriginalIndex.put(currentWord, i);
                    continue;
                }

                wordsSet.add(currentWord);
                this.wordsToOriginalIndex.put(currentWord, i);
                this.internalIndexToWords.put(internalSize, currentWord);

                char[] word = currentWord.toCharArray();
                this.prefix.add(new String[word.length]);
                this.suffix.add(new String[word.length]);

                StringBuilder sbPrefix = new StringBuilder();
                StringBuilder sbSuffix = new StringBuilder();

                for (int j = 0, k = word.length - 1; j < word.length; j++, k--) {
                    sbPrefix.append(word[j]);
                    sbSuffix.insert(0, word[k]);


                    this.prefix.get(internalSize)[j] = sbPrefix.toString();
                    this.suffix.get(internalSize)[j] = sbSuffix.toString();
                }

                internalSize++;
            }
        }

        public int f(String prefix, String suffix) {
            int result = -1;
            for (int index = 0; index < this.prefix.size(); index++) {
                if (hasPrefix(index, prefix) && hasSuffix(index, suffix)) {
                    result = getLargestLength(result, index);
                }
            }
            return result;
        }

        private int getLargestLength(int currentIndex, int possibleIndex) {
            if (currentIndex == -1) {
                String word = this.internalIndexToWords.get(possibleIndex);
                return this.wordsToOriginalIndex.get(word);
            }

            String firstWord =  this.internalIndexToWords.get(currentIndex);
            int firstWordOriginalIndex =  this.wordsToOriginalIndex.get(firstWord);

            String secondWord =  this.internalIndexToWords.get(possibleIndex);
            int secondWordOriginalIndex =  this.wordsToOriginalIndex.get(secondWord);

            if (firstWord.length() > secondWord.length())
                return firstWordOriginalIndex;

            if (firstWord.length() < secondWord.length())
                return secondWordOriginalIndex;

            return Math.max(firstWordOriginalIndex, secondWordOriginalIndex);
        }

        private boolean hasPrefix(int index, String prefix) {
            if (prefix.length() > this.prefix.get(index).length)
                return false;

            return this.prefix.get(index)[prefix.length() - 1].equals(prefix);
        }

        private boolean hasSuffix(int index, String suffix) {
            if (suffix.length() > this.suffix.get(index).length)
                return false;

            return this.suffix.get(index)[suffix.length() - 1].equals(suffix);
        }
    }


    public static void main(String[] args) {
        WordFilter wf = new WordFilter(new String[]{
                "cabaabaaaa",
                "ccbcababac",
                "bacaabccba",
                "bcbbcbacaa",
                "abcaccbcaa",
                "accabaccaa",
                "cabcbbbcca",
                "ababccabcb",
                "caccbbcbab",
                "bccbacbcba"
        });

        System.out.println(wf.f("bccbacbcba","a")); // 9
        System.out.println(wf.f("ab","abcaccbcaa"));  // 4
        System.out.println(wf.f("a","aa"));  // 5
        System.out.println(wf.f("cabaaba","abaaaa")); // 0
        System.out.println(wf.f("cacc","accbbcbab"));  // 8
        System.out.println(wf.f("ccbcab","bac")); // 1
        System.out.println(wf.f("bac","cba")); // 2
        System.out.println(wf.f("ac","accabaccaa")); // 5
        System.out.println(wf.f("bcbb","aa"));  // 3
        System.out.println(wf.f("ccbca","cbcababac")); // 1
    }
}
