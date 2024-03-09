package org.example;

import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            if (hashSet.contains(i))
                return true;
            hashSet.add(i);
        }
        return false;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sCharArray = s.toCharArray();
        Arrays.sort(sCharArray);
        char[] tCharArray = t.toCharArray();
        Arrays.sort(tCharArray);
        return Arrays.equals(sCharArray, tCharArray);
    }

    public int[] twoSumSortedArray(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.sort(nums);
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            int sum = nums[leftIndex] + nums[rightIndex];
            if (sum == target) {
                return new int[]{leftIndex, rightIndex};
            } else if (sum > target) {
                rightIndex--;
            } else
                leftIndex++;
        }
        return result;
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i) {
                return new int[]{i, hashMap.get(complement)};
            }
        }

        return new int[]{};
    }

    public boolean isPalindromeWithTwoPointer(String s) {
        String replacedAll = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int pointer = 0;
        int length = replacedAll.length();

        while (pointer < length / 2) {
            if (replacedAll.charAt(pointer) != replacedAll.charAt(length - pointer - 1)) {
                return false;
            }
            pointer++;
        }

        return true;
    }

    public boolean isPalindrome(String s) {
        String replacedAll = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (replacedAll.length() <= 1)
            return true;

        String s1 = new StringBuilder(replacedAll).reverse().toString();
        return replacedAll.equals(s1);
    }

    public boolean isValidParentheses(String s) {
        if (!s.matches("^[\\[\\]{}()]*$"))
            return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        while (true) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            } else if (s.contains("{}")) {
                s = s.replace("{}", "");
            } else if (s.contains("[]")) {
                s = s.replace("[]", "");
            } else {
                // If the string becomes empty, it indicates all brackets are matched.
                return s.isEmpty();
            }
        }
    }

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target)
                return middle;
            else if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else
                return -1;
        }

        return -1;
    }

    public boolean hasBrackets(String s) {
        return s.indexOf('[') != -1 || s.indexOf(']') != -1 ||
                s.indexOf('{') != -1 || s.indexOf('}') != -1 ||
                s.indexOf('(') != -1 || s.indexOf(')') != -1;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    public int maxProfitComplex(int[] prices) {
        int maxProfit = 0;
        int size = prices.length;
        if (size < 2)
            return 0;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (prices[j] - prices[i] > maxProfit)
                    maxProfit = prices[j] - prices[i];
            }
        }
        return maxProfit;
    }

    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;

        Arrays.sort(nums);
        int maxLength = 1;
        int currentLength = 1;
        int currentPosition = 1;

        while (currentPosition < length) {
            if (nums[currentPosition] == nums[currentPosition - 1] + 1) {
                currentLength++;
                if (currentLength > maxLength)
                    maxLength = currentLength;
            } else if (nums[currentPosition] == nums[currentPosition - 1]) {
                currentPosition++;
                continue;
            } else {
                currentLength = 1;
            }
            currentPosition++;
        }
        return maxLength;
    }

    public int maxFrequencyElements(int[] nums) {
        int length = nums.length;
        return length;
    }
}