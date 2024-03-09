package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SolutionTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @Test
    void itShouldIsAnagram() {
        //given
        String s = "cat";
        String t = "tac";
        //when
        boolean isAnagram = underTest.isAnagram(s, t);
        //then
        Assertions.assertTrue(isAnagram);
    }

    @Test
    void itShouldNotIsAnagram() {
        //given
        String s = "cac";
        String t = "tac";
        //when
        boolean isAnagram = underTest.isAnagram(s, t);
        //then
        Assertions.assertFalse(isAnagram);
    }

    @Test
    void itShouldTwoSum() {
        //given
        int[] inputArray = {3, 2, 4};
        int[] expected = {1, 2};
        //when
        int[] twoSum = underTest.twoSum(inputArray, 6);
        //then
        Assertions.assertArrayEquals(expected, twoSum);
    }

    @Test
    void itShouldNotIsPalindrome() {
        //given
        String s = "0P";
        //when
        boolean palindrome = underTest.isPalindrome(s);
        //then
        Assertions.assertFalse(palindrome);
    }

    @Test
    void itShouldNotIsPalindromeWithTwoPointer() {
        //given
        String s = "0P";
        //when
        boolean palindrome = underTest.isPalindromeWithTwoPointer(s);
        //then
        Assertions.assertFalse(palindrome);
    }

    @Test
    void itShouldIsPalindromeWithTwoPointer() {
        //given
        String s = "A man, a plan, a canal: Panama";
        //when
        boolean palindrome = underTest.isPalindromeWithTwoPointer(s);
        //then
        Assertions.assertTrue(palindrome);
    }

    @Test
    void itShouldIsValidParentheses() {
        //given
        String s = "([)]";
        //when
        boolean validParentheses = underTest.isValidParentheses(s);
        //then
        Assertions.assertTrue(validParentheses);
    }

    @Test
    void itShouldIsValid() {
        //given
        String s = "[()]";
        //when
        boolean validParentheses = underTest.isValidParentheses(s);
        //then
        Assertions.assertTrue(validParentheses);
    }

    @Test
    void itShouldSearch() {
        //given
        int[] inputArray = {1, 3, 5, 7, 9};

        //when
        //then
        Assertions.assertEquals(2, underTest.search(inputArray, 5));
        Assertions.assertEquals(4, underTest.search(inputArray, 9));
        Assertions.assertEquals(0, underTest.search(inputArray, 1));
        Assertions.assertEquals(-1, underTest.search(inputArray, 2));
    }

    @Test
    void itShouldHasBrackets() {
        //given
        String s = "[()]";
        //when and then
        boolean hasBrackets = underTest.hasBrackets(s);
        Assertions.assertTrue(hasBrackets);
    }

    @Test
    void itShouldMaxProfit() {
        //given
        int[] inputArray = {7, 1, 5, 3, 6, 4};
        int[] prices = {7, 6, 4, 3, 1};
        //when
        int maxProfit = underTest.maxProfit(inputArray);
        //then
        Assertions.assertEquals(5, maxProfit);
        Assertions.assertEquals(0, underTest.maxProfit(prices));
    }

    @Test
    void itShouldLongestConsecutive() {
        //given
        int[] inputArray = {7, 1, 5, 3, 6, 4};
        int[] prices = {100,4,200,1,3,2};
        int[] prices2 = {0,3,7,2,5,8,4,6,0,1};
        int[] prices3 = {};
        int[] prices4 = {1,2,0,1};
        int[] prices5 = {1};
        //when
        int longestConsecutive = underTest.longestConsecutive(inputArray);
        //then
        Assertions.assertEquals(5, longestConsecutive);
        Assertions.assertEquals(4, underTest.longestConsecutive(prices));
        Assertions.assertEquals(9, underTest.longestConsecutive(prices2));
        Assertions.assertEquals(0, underTest.longestConsecutive(prices3));
        Assertions.assertEquals(3, underTest.longestConsecutive(prices4));
        Assertions.assertEquals(1, underTest.longestConsecutive(prices5));
    }
}