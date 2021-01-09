package com.company.leetcode.challenges.jan2021.week2.arraystrings;

public class Solution {

    /*

    ["ecxarwyyy","ppf","tdyayjd"]
["ecxarwyyyppft","dyayj","q"]
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.arrayStringsAreEqual(new String[]{"ecxarwyyy","ppf","tdyayjd"}, new String[]{"ecxarwyyyppft","dyayj","q"}));
//        System.out.println(solution.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
//        System.out.println(solution.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }

    public static class StringArray {
        int index1, index2;
        String[] word;

        public StringArray(String[] word) {
            this.index1 = 0;
            this.index2 = 0;
            this.word = word;
        }

        public boolean hasNext() {
            if (index1 >= word.length)
                return false;

            if (index1 == word.length - 1) {
                return index2 < word[index1].length();
            }

            return true;
        }

        public char getNext() {
            char next = word[index1].charAt(index2);
            increment();
            return next;
        }

        private void increment() {
            int currentWordLen = word[index1].length();
            if (currentWordLen - 1 == index2) {
                index1++;
                index2 = 0;
            } else {
                index2++;
            }
        }
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringArray s1 = new StringArray(word1);
        StringArray s2 = new StringArray(word2);

        while(s1.hasNext() && s2.hasNext()) {
            if (s1.getNext() != s2.getNext()) {
                return false;
            }
        }

        return !s1.hasNext() && !s2.hasNext();
    }

}
