package com.test.learn;

import com.learn.online.question.FirstNonRepeatingChar;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;

public class AnagramTest {


    @Test
    public void testFirstNonRepeatingCharacter()
    {
        Assert.assertEquals('d', FirstNonRepeatingChar.getFirstNonRepeatingChar("dinesh seervi"));
        Assert.assertEquals('e', FirstNonRepeatingChar.getFirstNonRepeatingChar("aabbccddeffgghhiijkkl"));
        Assert.assertEquals('j', FirstNonRepeatingChar.getFirstNonRepeatingChar("aabbccddeeffgghhiijkkl"));
    }


    @Test
    public void testOnDev()
    {
        System.setProperty("ENV", "DEV");
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")), AnagramTest::message);
    }

    @Test
    public void testOnProd()
    {
        System.setProperty("ENV", "PROD");
        Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")));
    }

    private static String message () {
        return "TEST Execution Failed :: ";
    }
}
