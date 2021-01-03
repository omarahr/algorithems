package com.company.leetcode;

import java.util.*;
public class AutocompleteSystem {
    static class TrieNode {
        List<String> strings = new ArrayList<>();
        HashMap<Character, TrieNode> children = new HashMap<>();
    }

    static class SuffixTree {
        TrieNode root;
        TrieNode current;

        SuffixTree (String[] sentences) {
            root = new TrieNode();
            current = root;

            buildSuffixTree(sentences);
        }

        private void buildSuffixTree(String[] sentences) {
            for(String sentence : sentences) {
                addStringToTree(sentence);
            }
        }

        private void addStringToTree(String sentence) {
            TrieNode current = root;
            int index = 0;
            while(index < sentence.length()) {
                if(!current.children.containsKey(sentence.charAt(index)))
                    current.children.put(sentence.charAt(index), new TrieNode());
                TrieNode next = current.children.get(sentence.charAt(index));
                next.strings.add(sentence);
                current = next;
                index++;
            }
        }

        public List<String> getNext(char c) {
            if (current == null)
                return new ArrayList<>();

            if (!current.children.containsKey(c)) {
                current = null;
                return new ArrayList<>();
            }

            current = current.children.get(c);
            return current.strings;
        }

        private void kill() {
            current = null;
        }

    }

    SuffixTree tree;
    HashMap<String, Integer> times = new HashMap<>();
    String[] strings;

    public static void main(String[] args) {
        String[] sentences = new String[]{"i love you", "island", "ironman", "i love leetcode"};
        int[] times = new int[]{5, 3, 2, 2};
        AutocompleteSystem system = new AutocompleteSystem(sentences, times);

        List<String> answer = system.input('i');
        System.out.println(Arrays.toString(answer.toArray()));

        answer = system.input(' ');
        System.out.println(Arrays.toString(answer.toArray()));

        answer = system.input('a');
        System.out.println(Arrays.toString(answer.toArray()));

        answer = system.input('#');
        System.out.println(Arrays.toString(answer.toArray()));

        answer = system.input('i');
        System.out.println(Arrays.toString(answer.toArray()));

        answer = system.input(' ');
        System.out.println(Arrays.toString(answer.toArray()));

        answer = system.input('a');
        System.out.println(Arrays.toString(answer.toArray()));
    }

    /*
    ["com.company.leetcode.AutocompleteSystem","input","input","input","input","input","input","input","input","input","input","input","input"]
[[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"]]


[null,["i love you","island","i love leetcode"],["i love you","i love leetcode"],[],[],[],[],[],[],[],[],[],[]]
[null,["i love you","island","i love leetcode"],["i love you","i love leetcode"],[],[],["i love you","island","i love leetcode"],["i love you","i love leetcode","i a"],["i a"],[],["i love you","island","i a"],["i love you","i a","i love leetcode"],["i a"],[]]


     */

    public AutocompleteSystem(String[] sentences, int[] times) {
        strings = sentences;
        for(int i = 0; i < times.length; i++)
            this.times.put(sentences[i], times[i]);
        tree = new SuffixTree(sentences);
    }

    static class Pair {
        String value;
        int time;

        Pair (String value, int time) {
            this.value = value;
            this.time = time;
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            tree.kill();
            return new ArrayList<>();
        }


        List<String> possibleSentences = tree.getNext(c);
        List<Pair> pairs = new ArrayList<>();
        for(String possibleSentence : possibleSentences)
            pairs.add(new Pair(possibleSentence, this.times.get(possibleSentence)));
        pairs.sort((o1, o2) -> {
            if (o1.time == o2.time) {
                return o1.value.compareTo(o2.value);
            }

            return o2.time - o1.time;
        });

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < pairs.size() && i < 3; i++) {
            answer.add(pairs.get(i).value);
        }
        return answer;
    }

}
