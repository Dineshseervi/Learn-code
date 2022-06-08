package com.learn.online.question;

public class TwoStringInterleavingToFormThird {

    /*public boolean isInterleaved(char str1[], char str2[], char str3[]){
        boolean T[][] = new boolean[str1.length +1][str2.length +1];

        if(str1.length + str2.length != str3.length){
            return false;
        }

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length; j++){
                int l = i + j -1;
                if(i == 0 && j == 0){
                    T[i][j] = true;
                }
                else if(i == 0){
                    if(str3[l] == str2[j-1]){
                        T[i][j] = T[i][j-1];
                    }
                }
                else if(j == 0){
                    if(str1[i-1] == str3[l]){
                        T[i][j] = T[i-1][j];
                    }
                }
                else{
                  //  T[i][j] = (str1[i-1] == str3[l] ? T[i-1][j] : false) || (str2[j-1] == str3[l] ? T[i][j-1] : false);
                   boolean first  = (str1[i-1] == str3[l] ? T[i-1][j] : false) ;
                   boolean second  = (str2[j-1] == str3[l] ? T[i][j-1] : false);
                   boolean result=first || second;
                    T[i][j] = result;
                }
            }
        }
        return T[str1.length][str2.length];
    }*/

    public boolean isInterleaved(char str1[], char str2[], char str3[])
    {
      return   isInterleave(new String(str1),new String(str2),new String(str3));
    }


    /**
     *         String str1 = "aabcc";
     *         String str2 = "dbbca";
     *                        012345
     *                        TFFFFF
     *                        TFFFFF
     *                        T
     *         String str3 = "aadbbcbcac";
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length(), n = s2.length();
        if (s3.length() != m + n) return false;
        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int l=(i+j) -1;
                if (i == 0 && j == 0) {
                    dp[j] = true;
                    System.out.print(dp[j]+" ");
                }
                else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(l);
                    System.out.print(dp[j]+" ");
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(l);
                    System.out.print(dp[j]+" ");
                } else {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(l) ||
                            dp[j] && s1.charAt(i - 1) == s3.charAt(l);
                    System.out.print(dp[j]+" ");
                }
            }
            System.out.println(" ");
        }

        return dp[n];
    }


}
