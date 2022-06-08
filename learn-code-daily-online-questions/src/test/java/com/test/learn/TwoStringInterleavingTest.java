package com.test.learn;

import com.learn.online.question.TwoStringInterleavingToFormThird;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TwoStringInterleavingTest {

    @Test
    @DisplayName("two string test")
    void twoStringTest()
    {
        String str1 = "aabcc";
        String str2 = "dbbca";
        String str3 = "aadbbcbcac";

        TwoStringInterleavingToFormThird twoStringInterleavingToFormThird=new TwoStringInterleavingToFormThird();
        boolean result=twoStringInterleavingToFormThird.isInterleaved(str1.toCharArray(),str2.toCharArray(),str3.toCharArray());
        Assert.assertTrue(result);

    }

    @Test
    @DisplayName("two string Interleaving false")
    void twoStringInterleavingFalseTest()
    {
        String str1 = "aabcc";
        String str2 = "dbbca";
        String str3 = "aadbbbaccc";

        TwoStringInterleavingToFormThird twoStringInterleavingToFormThird=new TwoStringInterleavingToFormThird();
        boolean result=twoStringInterleavingToFormThird.isInterleaved(str1.toCharArray(),str2.toCharArray(),str3.toCharArray());
        Assert.assertFalse(result);

    }

    @Test
    @DisplayName("two string Interleaving empty")
    void twoStringInterleavingEmptyTest()
    {
        String str1 = "";
        String str2 = "";
        String str3 = "";

        TwoStringInterleavingToFormThird twoStringInterleavingToFormThird=new TwoStringInterleavingToFormThird();
        boolean result=twoStringInterleavingToFormThird.isInterleaved(str1.toCharArray(),str2.toCharArray(),str3.toCharArray());
        Assert.assertTrue(result);

    }


}
