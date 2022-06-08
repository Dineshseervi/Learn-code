package com.learn.online.question.bit;

/**
 * Left shift bit operation <<
 * Here’s an example of a left shift:
 *
 * 6 = 000000006=00000000 0000000000000000 0000000000000000 0000011000000110
 *
 * Shifting this bit pattern to the left one position (6 << 1) results in the number 12:
 *
 * 6 << 1 = 000000006<<1=00000000 0000000000000000 0000000000000000 0000110000001100
 *
 * As you can see, the digits have shifted to the left by one position, and the last digit on the right is filled with a zero. Note that shifting left is equivalent to multiplication by powers of 2.

 *
 * Well-optimized compilers will use this rule to replace multiplication with shifts whenever possible, as shifts are faster.
 */
//https://www.educative.io/blog/bit-manipulation-in-java?aid=5082902844932096&utm_source=google&utm_medium=cpc&utm_campaign=blog-dynamic&gclid=CjwKCAjwzMeFBhBwEiwAzwS8zGpupPrte_PVE3zRrFtp170SE4t2e1pDOyRpFCf-U1QFhO57dD7mBBoC998QAvD_BwE
public class LeftShiftBitOperation {

    public static void main(String[] args) {
        System.out.println("test even number");
        System.out.println(9 & 1);
    }
}
