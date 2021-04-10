package com.company.palantir.filesearch;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        String[] filePaths = new String[]{
                "mockito-kotlin/src/main/kotlin/com/nhaarman/mockitokotlin2/ArgumentCaptor.kt",
                "mockito-kotlin/src/main/kotlin/com/nhaarman/mockitokotlin2/BDDMockito.kt",
                "mockito-kotlin/src/main/kotlin/com/nhaarman/mockitokotlin2/KStubbing.kt",
                "mockito-kotlin/src/main/kotlin/com/nhaarman/mockitokotlin2/Matchers.kt",
                "mockito-kotlin/src/main/kotlin/com/nhaarman/mockitokotlin2/Mocking.kt",
                "mockito-kotlin/src/main/kotlin/com/nhaarman/mockitokotlin2/Mockito.kt",
                "mockito-kotlin/src/main/kotlin/com/nhaarman/mockitokotlin2/MockitoKotlinException.kt",
                "mockito-kotlin/src/main/kotlin/com/nhaarman/mockitokotlin2/OngoingStubbing.kt",
                "mockito-kotlin/src/main/kotlin/com/nhaarman/mockitokotlin2/Spying.kt",
                "mockito-kotlin/src/main/kotlin/com/nhaarman/mockitokotlin2/Stubber.kt",
                "mockito-kotlin/src/main/kotlin/com/nhaarman/mockitokotlin2/Verification.kt",
                "mockito-kotlin/src/main/kotlin/com/nhaarman/mockitokotlin2/VerifyScope.kt",
                "mockito-kotlin/src/main/kotlin/com/nhaarman/mockitokotlin2/internal/CreateInstance.kt",
                "mockito-kotlin/src/test/kotlin/test/CoroutinesTest.kt",
                "ops/mockMakerInline.sh",
                "ops/org.mockito.plugins.MockMaker",
                "publishing.gradle",
                "settings.gradle",
                "tests/README.md",
                "tests/build.gradle",
                "tests/src/test/kotlin/test/ArgumentCaptorTest.kt",
                "tests/src/test/kotlin/test/BDDMockitoTest.kt",
                "tests/src/test/kotlin/test/Classes.kt",
                "tests/src/test/kotlin/test/EqTest.kt",
        };

        StringMatcher matcher = new StringMatcher(filePaths);

        String[] tests = new String[]{
                "mockKotVS",
                "mockKotlinVS",
                "test",
                "testEq",
                "coroutine",
        };

        for (String test : tests) {
            List<String> results = matcher.getMatchingResults(test);
            printResults(test, results);
        }
    }

    private static void printResults(String test, List<String> results) {
        System.out.println("*****************************");
        System.out.printf("Test Case : %s%n", test);
        System.out.println("Results:");
        for (String item : results) System.out.printf("%s%n", item);
        System.out.println("*****************************");
    }

    public static class StringMatcher {
        String[] strings;

        StringMatcher(String[] strings) {
            this.strings = strings;
            toLowerCase();
        }


        private void toLowerCase() {
            for (int i = 0; i < strings.length; i++)
                strings[i] = strings[i].toLowerCase();
        }

        public List<String> getMatchingResults(String text) {
            char[] searchText = text.toLowerCase().toCharArray();

            List<String> result = new ArrayList<>();
            for (String item : strings) {
                if (matchSearchNode(item.toCharArray(), searchText)) {
                    result.add(item);
                }
            }

            return result;
        }

        private boolean matchSearchNode(char[] item, char[] text) {
            int textIdx = 0, itemIdx = 0;
            while (textIdx < text.length && itemIdx < item.length) {
                if (text[textIdx] == item[itemIdx]) {
                    itemIdx++;
                    textIdx++;
                } else {
                    itemIdx++;
                }
            }

            return textIdx == text.length;
        }
    }

}
