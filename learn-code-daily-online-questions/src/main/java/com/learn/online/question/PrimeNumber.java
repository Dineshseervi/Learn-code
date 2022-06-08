package com.learn.online.question;

public class PrimeNumber {

    /*
     <------ prime number count start -------->
             time:3512
             count :539777

            Time complexity is O(n^1.5)
            space complexity is O(1)
     */
    public int countPrimes(int n) {
        int count=0;
        if(n <= 2)
        {
            return count;
        }
        if(n <= 3)
        {
            return 1;
        }
        for(int i=2;i<n;i++)
        {
            if(isPrime(i))
            {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int num)
    {
        for(int i=2;i*i<=num;i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }
        return true;
    }


    /**
     *  <------ prime number count start -------->
     * time:97
     * count :539777
     *
     * //Time complexity is O(N logN)
     * //space complexity is O(N)
     * @param n
     * @return
     */
    public int countPrimesApproch2(int n) {
        boolean[] isPrime = new boolean[n];
        //O(n)
        //space O(N)
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().

        //O(N logN)
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;

        //O(n)
        long tt=System.currentTimeMillis();
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        System.out.println("loop 3rd time:"+ (System.currentTimeMillis()-tt));
        return count;
    }
    public static void main(String[] args) {
        PrimeNumber primeNumber=new PrimeNumber();
        System.out.println(" <------ prime number count start --------> ");
        long time=System.currentTimeMillis();
        int count =primeNumber.countPrimesApproch2(8000000);
        System.out.println("time:"+ (System.currentTimeMillis()-time));
        System.out.println("count :" +count);
    }
}
