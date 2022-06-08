package com.test.learn;

import com.learn.online.question.array.MaxMultiOfString;
import org.junit.Assert;
import org.junit.Test;

public class MaxMultiOfStringTest {

    MaxMultiOfString maxMultiOfString=new MaxMultiOfString();

    @Test
    public void testmaxProduct()
    {
        //MaxMultiOfString maxMultiOfString=new MaxMultiOfString();

        Assert.assertEquals(16,maxMultiOfString.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }

    @Test
    public void testWords()
    {
        int num=maxMultiOfString.getAndOperation("abcd","efgh");
        System.out.println(num);
    }

}
