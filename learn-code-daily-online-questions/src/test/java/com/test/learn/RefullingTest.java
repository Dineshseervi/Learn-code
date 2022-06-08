package com.test.learn;

import com.learn.online.question.RefullingStop;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class RefullingTest {

    @Test
    void testRefuel()
    {

        RefullingStop refullingStop=new RefullingStop();
        int count =refullingStop.minRefuelStops(100,10,new int[][]{{10,60},{20,30},{30,30},{60,40}});
        Assert.assertEquals(2,count);
    }
}
