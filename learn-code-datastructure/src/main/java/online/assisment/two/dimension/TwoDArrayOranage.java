package main.java.online.assisment.two.dimension;

import java.util.HashSet;

public class TwoDArrayOranage {
    public static void main(String[] args) {
        int[][] orangeStore = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1},
                {1, 0, 0, 2, 1},
                {1, 0, 0, 2, 1},
                {1, 0, 0, 2, 1}
        };

        int val=iterate(orangeStore);
        System.out.println("rounds to make all rotten : "+val);

    }

    /**
     * tc -O(n*m)
     * sc- O(n+m)
     * @param arr
     * @return
     */
    public static int iterate(int[][] arr) {
        int x=0;
        //boolean allRotten=true;
        while(x<arr.length) {
           boolean allRotten=true;
            HashSet<String> coveredSet=new HashSet();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    //System.out.print(" " + orangeStore[i][j]);
                    if(arr[i][j]==1)
                    {
                        int pointer=i-1;
                        if((pointer)>=0)
                        {
                            if(arr[pointer][j]==2 && !coveredSet.contains(pointer+""+j))
                            {
                                arr[i][j]=2;
                                coveredSet.add(i+""+j);
                                continue;
                            }
                        }
                        pointer=i+1;
                        if(pointer< arr.length)
                        {
                            if(arr[pointer][j]==2 && !coveredSet.contains(pointer+""+j))
                            {
                                arr[i][j]=2;
                                coveredSet.add(i+""+j);
                                continue;
                            }
                        }

                        pointer=j-1;
                        if(pointer>=0)
                        {
                            if(arr[i][pointer]==2 && !coveredSet.contains(i+""+pointer))
                            {
                                arr[i][j]=2;
                                coveredSet.add(i+""+j);
                                continue;
                            }
                        }

                        pointer=j+1;
                        if(pointer< arr[0].length)
                        {
                            if(arr[i][pointer]==2 && !coveredSet.contains(i+""+pointer))
                            {
                                arr[i][j]=2;
                                coveredSet.add(i+""+j);
                                continue;
                            }
                        }


                        allRotten=false;

                    }
                }
                //System.out.print(",\n");
            }
            x++;
            if(allRotten)
            {
                return x;
            }
        }
        return -1;
    }


}
