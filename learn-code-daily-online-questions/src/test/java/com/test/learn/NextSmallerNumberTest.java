package com.test.learn;

import com.learn.online.question.NextSmallerNumber;
import org.junit.Assert;
import org.junit.Test;

public class NextSmallerNumberTest {

    @Test
    public void testNst()
    {
        int[] result =NextSmallerNumber.printNextSmallerNumber(new int[]{11, 13, 21, 3});
        Assert.assertArrayEquals(new int[]{3, 3, 3, -1},result);


        int[] result2 =NextSmallerNumber.printNextSmallerNumber(new int[]{11, 13, 1, 3});
        Assert.assertArrayEquals(new int[]{1, 1, -1, -1},result2);
    }

    @Test
    public void testNstStack()
    {
        int[] result =NextSmallerNumber.printNextSmallerNumberLessComplexTime(new int[]{11, 13, 21, 3});
        Assert.assertArrayEquals(new int[]{3, 3, 3, -1},result);


        int[] result2 =NextSmallerNumber.printNextSmallerNumberLessComplexTime(new int[]{11, 13, 1, 3,4});
        Assert.assertArrayEquals(new int[]{1, 1, -1, -1,-1},result2);
    }
}
