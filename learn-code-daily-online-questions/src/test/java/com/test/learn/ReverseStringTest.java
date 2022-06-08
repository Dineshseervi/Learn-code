package com.test.learn;

import com.learn.online.question.ReverseString;
import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void reverseString()
    {
        Assert.assertEquals("dcba", ReverseString.reverseTheString("abcd"));
    }
}
