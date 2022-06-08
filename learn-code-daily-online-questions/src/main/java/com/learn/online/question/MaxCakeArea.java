package com.learn.online.question;

import java.util.Arrays;

public class MaxCakeArea {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int area=0;
        int imin=0;

        for(int i=0;i<=horizontalCuts.length;i++)
        {
            int jmin=0;
            for(int j=0;j<=verticalCuts.length;j++)
            {
                if(i<horizontalCuts.length)
                {
                    if(j<verticalCuts.length)
                    {
                        int a= (verticalCuts[j]-jmin) * (horizontalCuts[i]-imin);
                        area=Math.max(a,area);
                        System.out.println("Area:"+(area% 1000000007));
                        jmin=verticalCuts[j];
                    }
                    else{
                        int a= (w-jmin) * (horizontalCuts[i]-imin);
                        area=Math.max(a,area);
                        System.out.println("Area:"+(area% 1000000007));
                    }
                }else{
                    if(j<verticalCuts.length)
                    {
                        int a= (verticalCuts[j]-jmin) * (h-imin);
                        area=Math.max(a,area);
                        System.out.println("Area:"+(area% 1000000007));
                        jmin=verticalCuts[j];
                    }
                    else{
                        int a= (w-jmin) * (h-imin);
                        area=Math.max(a,area);
                        System.out.println("Area:"+(area% 1000000007));
                    }
                }


            }
            if(i<horizontalCuts.length)
            {
                imin= horizontalCuts[i];
            }
        }
        return area;
    }





    public int maxAreaTwo(int h, int w, int[] horizontalCuts, int[] verticalCuts)
    {
        int n = horizontalCuts.length, m = verticalCuts.length;
        long hmx = 0, vmx = 0;
        Arrays.sort(verticalCuts);
        Arrays.sort(horizontalCuts);

        for(int i = 0; i < n; i++)
        {
            hmx = Math.max(hmx, horizontalCuts[i] - (i > 0 ? horizontalCuts[i - 1] : 0));
        }

        hmx = Math.max(hmx, h - horizontalCuts[n - 1]);

        for(int i = 0; i < m; i++)
        {
            vmx = Math.max(vmx, verticalCuts[i] - (i > 0 ? verticalCuts[i - 1] : 0));
        }

        vmx = Math.max(vmx, w - verticalCuts[m - 1]);

        return (int)((hmx * vmx) % 1000000007);
    }
}
