package com.company.leetcode.facebook.arrays;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.addBinary("1010", "1011"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] letters = s.toCharArray();
        int[] index = new int[256];
        Arrays.fill(index, -1);

        int maxLength = 0;
        int pointer = 0;
        for(int i = 0; i < letters.length; i++) {
            int lastIndex = index[letters[i]];
            index[letters[i]] = i;
            if (lastIndex != -1 && lastIndex >= pointer) {
                pointer = lastIndex + 1;
            }

            maxLength = Math.max(maxLength, i - pointer + 1);
        }

        return maxLength;
    }

    public static void moveZeroes(int[] nums) {
        int zeroPointer = 0;
        int nonZeroPointer = 1;

        while (zeroPointer < nums.length && nonZeroPointer < nums.length) {
            if (nums[zeroPointer] != 0) {
                zeroPointer++;
                if (nonZeroPointer <= zeroPointer) nonZeroPointer++;
            } else {
                while (nonZeroPointer < nums.length && nums[nonZeroPointer] == 0) {
                    nonZeroPointer++;
                }

                if (nonZeroPointer < nums.length) {
                    int temp = nums[zeroPointer];
                    nums[zeroPointer] = nums[nonZeroPointer];
                    nums[nonZeroPointer]= temp;
                    zeroPointer++;
                }
            }
        }
    }


    public boolean isPalindrome(String s) {
        int rightPointer = 0;
        int leftPointer = s.length() - 1;
        char[] letters = s.toLowerCase().toCharArray();

        while(rightPointer < leftPointer) {
            if (!isAlphaNumeric(letters[rightPointer])) {
                rightPointer++;
            } else if(!isAlphaNumeric(letters[leftPointer])) {
                leftPointer--;
            } else if (letters[rightPointer] != letters[leftPointer]) {
                return false;
            } else {
                rightPointer++;
                leftPointer--;
            }
        }

        return true;
    }

    public static boolean isAlphaNumeric(char x) {
        return (x >= 'a' && x <= 'z') || (x >= '0' && x <= '9');
    }


    public static boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length()) {
            return isOneEditDistanceByReplace(s, t);
        } else if (s.length() + 1 == t.length()) {
            return isOneEditDistanceByAddition(s, t);
        } else if (s.length() - 1 == t.length()) {
            return isOneEditDistanceByAddition(t, s);
        }

        return false;
    }

    public static boolean isOneEditDistanceByReplace(String s, String t) {
        if (s.length() == 0) return false;

        char[] sourceArray = s.toCharArray();
        char[] targetArray = t.toCharArray();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (sourceArray[i] != targetArray[i]) count++;
            if (count > 1) return false;
        }

        return count == 1;
    }

    public static boolean isOneEditDistanceByAddition(String s, String t) {
        char[] sourceArray = s.toCharArray();
        char[] targetArray = t.toCharArray();
        int counter = 0;

        int sourcePtr = 0;
        int targetPtr = 0;

        while(sourcePtr < sourceArray.length) {
            if (sourceArray[sourcePtr] != targetArray[targetPtr]) {
                if (counter != 0) return false;
                counter ++;
            } else {
                sourcePtr++;
            }

            targetPtr++;
        }


        return true;
    }

    public boolean validPalindrome(String s) {
        char[] letters = s.toCharArray();

        int leftIndex = 0;
        int rightIndex = letters.length - 1;

        while(leftIndex < rightIndex) {
            if (letters[leftIndex] != letters[rightIndex]) {
                return checkPalindrome(leftIndex, rightIndex - 1, letters) || checkPalindrome(leftIndex + 1, rightIndex, letters);
            } else {
                rightIndex--;
                leftIndex++;
            }
        }

        return true;
    }

    public static boolean checkPalindrome(int leftIndex, int rightIndex, char[] letters) {

        while (leftIndex < rightIndex) {
            if (letters[leftIndex] != letters[rightIndex]) return false;
            leftIndex++;
            rightIndex--;
        }

        return true;
    }

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                nextPermutationReorder(i-1, nums);
                return;
            }
        }

        nextPermutationReverseArray(0, nums);
    }

    private void nextPermutationReverseArray(int startIndex, int[] nums) {
        for(int i = startIndex, j = nums.length -1; i < j; i++, j--) {
            swap(i, j, nums);
        }
    }

    private void nextPermutationReorder(int index, int[] nums) {
        int swapIndex = index + 1;
        int minDifference = Integer.MAX_VALUE;

        for(int i = nums.length - 1; i > index; i--) {
            int difference = nums[i] - nums[index];
            if (difference > 0 && difference < minDifference) {
                minDifference = difference;
                swapIndex = i;
            }
        }

        swap(index, swapIndex, nums);

        nextPermutationReverseArray(index + 1, nums);
    }

    private void swap(int indexA, int indexB, int[] nums) {
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }

    public int removeDuplicates(int[] nums) {
        int noDuplicatesPointer = 0;
        int lookupPointer = 1;

        while (noDuplicatesPointer < nums.length - 1) {
            if (nums[noDuplicatesPointer] < nums[noDuplicatesPointer + 1]) {
                noDuplicatesPointer++;
            } else {
                lookupPointer = Math.max(lookupPointer, noDuplicatesPointer + 1);
                while (lookupPointer < nums.length) {
                    if (nums[lookupPointer] > nums[noDuplicatesPointer]) {
                        break;
                    }
                    lookupPointer++;
                }

                if (lookupPointer == nums.length) {
                    return noDuplicatesPointer + 1;
                } else {
                    swap(noDuplicatesPointer + 1, lookupPointer, nums);
                }
            }
        }

        return noDuplicatesPointer + 1;
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() * k == 0)
            return 0;

        char[] letters = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxSubstringLength = 0;
        int[] freq = new int[256];
        int distinct = 0;

        for (; right < letters.length; right++) {
            int newLetterFreq = freq[letters[right]];
            if (newLetterFreq == 0) {
                distinct++;
            }

            freq[letters[right]]++;

            while (distinct > k) {
                freq[letters[left]]--;
                if (freq[letters[left]] == 0) {
                    distinct--;
                }
                left++;
            }

            maxSubstringLength = Math.max(maxSubstringLength, right - left + 1);
        }

        return maxSubstringLength;
    }

    Queue<Character> buffer = new LinkedList<>();
    public int read(char[] buf, int n) {
        int index = 0, read = 4;
        while(index < n && read == 4) {
            char[] tempBuf = new char[4];
            read = read4(tempBuf);
            for (int i = 0; i < read && index < n; i++, index++) {
                buf[index] = tempBuf[i];
            }
        }
        return index;
    }

    public void readFromBuffer(char[] buf, int n) {
        int index = 0;
        int read = 4;
        for (;index < n; index++) {
            if (buffer.isEmpty()) {
                read = fillTheBuffer();
                if (read == 0)
                    break;
            }

            buf[index] = buffer.poll();
        }
    }

    private int fillTheBuffer() {
        char[] tempBuf = new char[4];
        int read = read4(tempBuf);
        for (int i = 0; i < read; i++) {
            buffer.add(tempBuf[i]);
        }
        return read;
    }

    private int read4(char[] tempBuf) {
        return 0;
    }


    public String multiply(String num1, String num2) {
        String[] firstStep = new String[num2.length()];
        String zeros = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int rem = 0;
            if (i != num2.length() -1) zeros = "0" + zeros;

            StringBuilder stepResult = new StringBuilder(zeros);
            for (int j = num1.length() - 1; j >= 0; j--) {
                int a = getInt(num2.charAt(i));
                int b = getInt(num1.charAt(j));
                int result = (a*b)+rem;

                int digit = result%10;
                rem = result/10;
                stepResult.insert(0, digit);
            }
            if (rem != 0)
                stepResult.insert(0, rem);
            firstStep[i] = stepResult.toString();
        }

        String m = "0";
        for (String s : firstStep) {
            m = sum(m, s);
        }

        return checkForZeros(m);
    }

    private String checkForZeros(String m) {
        while (m.length() > 1 && m.charAt(0) == '0') {
            m = m.substring(1);
        }
        return m;
    }

    private String sum(String num1, String num2) {

        int num1Index = num1.length() - 1;
        int num2Index = num2.length() - 1;

        int carry = 0;
        StringBuilder sum = new StringBuilder();
        while (num1Index > -1 || num2Index > -1) {
            int a = 0;
            if (num1Index > -1) {
                a = getInt(num1.charAt(num1Index));
                num1Index--;
            }

            int b = 0;
            if (num2Index > -1) {
                b = getInt(num2.charAt(num2Index));
                num2Index--;
            }


            int result = a + b + carry;
            int digit = result % 10;
            sum.insert(0, digit);
            carry = result / 10;
        }

        if (carry != 0)
            sum.insert(0, carry);

        return sum.toString();
    }


    private int getInt(char x) {
        return x - '0';
    }


    public int[] productExceptSelf(int[] nums) {
        int[] fromLeft = new int[nums.length];
        int[] fromRight = new int[nums.length];
        int[] result = new int[nums.length];

        fromLeft[0] = 1;
        fromRight[nums.length - 1] = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            fromLeft[i+1] = nums[i] * fromLeft[i];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            fromRight[i-1] = nums[i] * fromRight[i];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = fromLeft[i] * fromRight[i];
        }

        return result;
    }

    public String minWindow(String s, String t) {
        int[] tFreq = new int[256];
        int[] sFreq = new int[256];

        for (int i = 0; i < t.length(); i++) tFreq[t.charAt(i)]++;

        char[] sArr = s.toCharArray();
        int rightPtr = 0;
        int leftPtr = 0;

        String result = "";
        if (sArr.length > 0) {
            sFreq[sArr[0]]++;
        }

        while (true) {
            boolean contract = checkStringContains(sFreq, tFreq);

            if (contract) {
                int length = rightPtr - leftPtr + 1;
                if (length < result.length() || result.equals("")) {
                    result = s.substring(leftPtr, rightPtr + 1);
                }

                sFreq[sArr[leftPtr]]--;
                leftPtr++;
            } else {
                if (rightPtr == s.length() - 1)
                    break;
                rightPtr++;
                sFreq[sArr[rightPtr]]++;
            }
        }

        return result;
    }

    private boolean checkStringContains(int[] sFreq, int[] tFreq) {
        for (int i = 0; i < 256 ;i++) {
            if (sFreq[i] < tFreq[i])
                return false;
        }
        return true;
    }

    public int myAtoi(String str) {

        // find first none white space char
        boolean isWhiteSpace = true;
        while (isWhiteSpace && str.length() > 0) {
            isWhiteSpace = str.charAt(0) == ' ';
            if (isWhiteSpace) str = str.substring(1);
        }

        if (str.length() == 0)
            return 0;

        char firstNonWhiteSpaceChar = str.charAt(0);

        if (!isNumberOrSign(firstNonWhiteSpaceChar)) {
            return 0;
        }

        boolean isPositive = isNumberPositive(firstNonWhiteSpaceChar);

        str = removeSign(str);

        if (str.length() == 0)
            return 0;

        str = removeZeros(str);
        str = getNumber(str);

        String maxInt = "2147483647";
        String minInt = "2147483648";

        if (isPositive) {
            if (maxInt.length() > str.length())
                return Integer.parseInt(str);

            if (maxInt.length() == str.length()) {
                if (maxInt.compareTo(str) <= 0)
                    return Integer.MAX_VALUE;
                return Integer.parseInt(str);
            }
            return Integer.MAX_VALUE;
        } else {
            if (minInt.length() > str.length())
                return -1 * Integer.parseInt(str);

            if (minInt.length() == str.length()) {
                if (minInt.compareTo(str) <= 0)
                    return Integer.MIN_VALUE;
                return -1 * Integer.parseInt(str);
            }
            return Integer.MIN_VALUE;
        }
    }

    private String removeZeros(String s) {
        while (s.length() > 0) {
            char current = s.charAt(0);
            if (current == '0')
                s = s.substring(1);
            else if(isNumber(current))
                return s;
            else
                return "0";
        }
        return "0";
    }

    private String getNumber(String s) {
        int end = 0;
        while (end < s.length()) {
            char current = s.charAt(end);
            if (!isNumber(current)) break;
            end++;
        }
        return s.substring(0, end);
    }

    private boolean isNumber(char x) {
        return x >= '0' && x <= '9';
    }

    private String removeSign(String s) {
        char firstNonWhiteSpaceChar = s.charAt(0);
        if(isSign(firstNonWhiteSpaceChar))
            return s.substring(1);
        return s;
    }

    private boolean isSign(char x) {
        return  x == '-' || x == '+';
    }

    private boolean isNumberPositive(char x) {
        return (x >= '0' && x <= '9') || x == '+';
    }

    private boolean isNumberOrSign(char x) {
        return (x >= '0' && x <= '9') || x == '-' || x == '+';
    }

    public String validIPAddress(String IP) {
        String ipv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        String pattern = "^("+ipv4+"\\.){3}"+ipv4+"$";
        Pattern patternX = Pattern.compile(pattern);
        Matcher matcher = patternX.matcher(IP);

        if (matcher.matches())
            return "IPv4";

        String ipv6 = "([0-9a-fA-F]{1,4})";
        pattern = "^("+ipv6+"\\:){7}"+ipv6+"$";
        Pattern patternY = Pattern.compile(pattern);
        matcher = patternY.matcher(IP);

        if (matcher.matches())
            return "IPv6";

        return "Neither";
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> group = anagrams.containsKey(key) ? anagrams.get(key) : new ArrayList<>();
            group.add(str);
            anagrams.put(key, group);
        }
        List<List<String>> groups = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : anagrams.entrySet()) {
            groups.add(entry.getValue());
        }
        return groups;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // remove numbers from 0-m to m-(m+n)
        for (int i = m-1, j = m + n - 1; i >= 0; i--, j--) {
            nums1[j] = nums1[i];
        }

        int index1 = n, index2 = 0, index = 0;

        while (index < m + n) {
            if (index1 >= m + n) {
                while (index2 < n) {
                    nums1[index] = nums2[index2];
                    index2++;
                    index++;
                }
            } else if (index2 >= n) {
                while (index1 < m + n) {
                    nums1[index] = nums1[index];
                    index1++;
                    index++;
                }
            } else {
                int a = nums1[index1];
                int b = nums2[index2];

                if (a <= b) {
                    nums1[index] = a;
                    index1++;
                } else {
                    nums1[index] = b;
                    index2++;
                }

                index++;
            }

        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> groups = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = -1 * (nums[i] + nums[j]);
                int low = j + 1;
                int high = nums.length - 1;

                if (target < nums[low]) {
                    continue;
                }

                ArrayList<Integer> result = new ArrayList<>();
                result.add(nums[i]);
                result.add(nums[j]);
                result.add(target);
                Collections.sort(result);
                String key = result.toString();
                if (set.contains(key)) {
                    continue;
                }

                while(low <= high) {
                    int mid = (low + high) / 2;

                    int item = nums[mid];

                    if (item < target) {
                        low = mid + 1;
                    } else if (item > target){
                        high = mid - 1;
                    } else {
                        groups.add(result);
                        set.add(key);
                        break;
                    }
                }
            }
        }

        return groups;
    }

    public int subarraySum(int[] nums, int k) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) counter++;
            }
        }
        return counter;
    }

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int indexA = a.length() - 1;
        int indexB = b.length() - 1;

        if (a.length() == 0)
            return b.length() == 0 ? "0" : b;

        if (b.length() == 0)
            return a;

        String carry = "";

        while (indexA > -1 || indexB > -1) {
            if (indexA < 0) {
                return addBinary(carry, b.substring(0, indexB + 1)) + result;
            } else if (indexB < 0) {
                return addBinary(carry, a.substring(0, indexA + 1)) + result;
            } else {
                String firstStep = addBinarySum(a.charAt(indexA), b.charAt(indexB));
                if (!carry.equals("")) {
                    firstStep = addBinary(firstStep, carry);
                }
                carry = firstStep.substring(0, firstStep.length() - 1);

                result.insert(0, firstStep.charAt(firstStep.length() - 1));
                indexA--;
                indexB--;
            }
        }

        if (!carry.equals(""))
            result.insert(0, carry);

        String answer = result.toString();
        return answer.length() == 0 ? "0" : answer;
    }

    private String addBinarySum(char a, char b) {
        if (a == '0' && b == '0')
            return "0";
        if (a == '1' && b == '0')
            return "1";
        if (a == '0' && b == '1')
            return "1";
        return "10";
    }
}
