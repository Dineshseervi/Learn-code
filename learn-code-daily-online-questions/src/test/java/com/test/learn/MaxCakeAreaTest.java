package com.test.learn;

import com.learn.online.question.MaxCakeArea;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MaxCakeAreaTest {

    @Test
    void testArea()
    {
        MaxCakeArea  maxCakeArea=new MaxCakeArea();
        int area=maxCakeArea.maxArea(1000000000,1000000000,new int[]{2},new int[]{2});

    }
}
