package com.test.learn;

import com.learn.online.question.StringIsPalindrome;
import org.junit.Assert;
import org.junit.Test;

public class CheckPalindromeStringTest {

    @Test
    public void isPalindrome()
    {
        Assert.assertTrue(StringIsPalindrome.isStringPalindrome("radar"));
        Assert.assertTrue(StringIsPalindrome.isStringPalindrome("aabbaa"));
        Assert.assertTrue(StringIsPalindrome.isStringPalindrome("a"));
    }

    @Test
    public void isNotPalindrome()
    {
        Assert.assertFalse(StringIsPalindrome.isStringPalindrome("abc"));
        Assert.assertFalse(StringIsPalindrome.isStringPalindrome(""));
        Assert.assertFalse(StringIsPalindrome.isStringPalindrome(null));
    }
}
