package com.company.zalando.task.c;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String input = "The quick brown fox jumps over the lazy dog";
        int K = 39;
        String result = solution.solution(input, K);
        System.out.println("*"+result+"*");
    }

    public String solution(String message, int K) {
        char[] msgArr = message.toCharArray();

        if(K >= message.length()){
            return message;
        }

        int lastIndex = K - 1;

        if (msgArr[K] != ' ') {
            while(lastIndex >= 0 && msgArr[lastIndex] != ' ') {
                lastIndex--;
            }
        } else {
            lastIndex = K;
        }

        boolean noWordsRemained = lastIndex == -1;
        if(noWordsRemained) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < lastIndex; i++) {
            stringBuilder.append(msgArr[i]);
        }

        return stringBuilder.toString();
    }
}
