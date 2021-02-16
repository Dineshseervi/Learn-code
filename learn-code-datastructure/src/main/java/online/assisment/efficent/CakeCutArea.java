package main.java.online.assisment.efficent;

public class CakeCutArea {

    public static void main(String[] args) {
        int [] hor={2,4,1};
        int [] ver={1,3};
        int area=maxArea(5,4,hor,ver);
        System.out.println("area : "+area);
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        boolean [] harr=new boolean[h];
        boolean [] varr=new boolean[w];

        for(int i=0;i<horizontalCuts.length;i++)
        {
            harr[horizontalCuts[i]]=true;
        }

        for(int i=0;i<verticalCuts.length;i++)
        {
            varr[verticalCuts[i]]=true;
        }

        int rh=0;
        int rv=0;
        for(int i=0,j=0;i<h;i++)
        {
            if(harr[i])
            {
                j=1;
            }
            else{
                j++;

            }
            rh=Math.max(rh,j);
        }

        for(int i=0,j=0;i<w;i++)
        {
            if(varr[i])
            {
                j=1;
            }
            else{
                j++;

            }
            rv=Math.max(rv,j);
        }
        return (int)((rv)*(rh));

    }
}
