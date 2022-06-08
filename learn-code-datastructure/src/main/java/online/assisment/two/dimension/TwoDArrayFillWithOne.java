package main.java.online.assisment.two.dimension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoDArrayFillWithOne {
    public static void main(String[] args) {
        int[][] orangeStore =
                {
                 {1, 0, 0},
                 {0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0},
                 {0, 0, 0}
                };

        int val = iterate(orangeStore);
        System.out.println("rounds to make all zero : " + val);
        List<Integer> num=new ArrayList<>();
        //num.indexOf()
    }

    /**
     * tc -O(n*m)
     * sc- O(n+m)
     *
     * @param arr
     * @return
     */
    public static int iterate(int[][] arr) {
        int x = 0;
        //boolean allRotten=true;
        while (x < arr.length) {
            boolean allRotten = true;
            HashSet<String> coveredSet = new HashSet();
            HashSet<String> zeroSet=new HashSet();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    //System.out.print(" " + orangeStore[i][j]);

                    if (arr[i][j] == 1 && !coveredSet.contains(i+""+j)) {
                        int pi = i - 1;
                        int pj= j;
                        if (  (pi) >= 0 && pi<arr.length && pj <arr[0].length && pj>=0) {
                            if(arr[pi][pj] == 0) {
                                arr[pi][pj] = 1;
                                coveredSet.add(pi + "" + pj);
                                if (zeroSet.contains(pi + "" + pj)) {
                                    zeroSet.remove(pi + "" + pj);
                                }
                            }
                        }

                         pi = i - 1;
                         pj= j-1;
                        if (  (pi) >= 0 && pi<arr.length && pj <arr[0].length && pj>=0) {
                            if(arr[pi][pj] == 0) {
                                arr[pi][pj] = 1;
                                coveredSet.add(pi + "" + pj);
                                if (zeroSet.contains(pi + "" + pj)) {
                                    zeroSet.remove(pi + "" + pj);
                                }
                            }
                        }


                        pi = i - 1;
                        pj= j+1;
                        if (  (pi) >= 0 && pi<arr.length && pj <arr[0].length && pj>=0) {
                            if(arr[pi][pj] == 0) {
                                arr[pi][pj] = 1;
                                coveredSet.add(pi + "" + pj);
                                if (zeroSet.contains(pi + "" + pj)) {
                                    zeroSet.remove(pi + "" + pj);
                                }
                            }
                        }

                        pi = i ;
                        pj= j-1;
                        if (  (pi) >= 0 && pi<arr.length && pj <arr[0].length && pj>=0) {
                            if(arr[pi][pj] == 0) {
                                arr[pi][pj] = 1;
                                coveredSet.add(pi + "" + pj);
                                if (zeroSet.contains(pi + "" + pj)) {
                                    zeroSet.remove(pi + "" + pj);
                                }
                            }
                        }

                        pi = i ;
                        pj= j+1;
                        if (  (pi) >= 0 && pi<arr.length && pj <arr[0].length && pj>=0) {
                            if(arr[pi][pj] == 0) {
                                arr[pi][pj] = 1;
                                coveredSet.add(pi + "" + pj);
                                if (zeroSet.contains(pi + "" + pj)) {
                                    zeroSet.remove(pi + "" + pj);
                                }
                            }
                        }

                        pi = i+1 ;
                        pj= j-1;
                        if (  (pi) >= 0 && pi<arr.length && pj <arr[0].length && pj>=0) {
                            if(arr[pi][pj] == 0) {
                                arr[pi][pj] = 1;
                                coveredSet.add(pi + "" + pj);
                                if (zeroSet.contains(pi + "" + pj)) {
                                    zeroSet.remove(pi + "" + pj);
                                }
                            }
                        }

                        pi = i+1 ;
                        pj= j;
                        if (  (pi) >= 0 && pi<arr.length && pj <arr[0].length && pj>=0) {
                            if(arr[pi][pj] == 0) {
                                arr[pi][pj] = 1;
                                coveredSet.add(pi + "" + pj);
                                if (zeroSet.contains(pi + "" + pj)) {
                                    zeroSet.remove(pi + "" + pj);
                                }
                            }
                        }

                        pi = i+1 ;
                        pj= j+1;
                        if (  (pi) >= 0 && pi<arr.length && pj <arr[0].length && pj>=0) {
                            if(arr[pi][pj] == 0) {
                                arr[pi][pj] = 1;
                                coveredSet.add(pi + "" + pj);
                                if (zeroSet.contains(pi + "" + pj)) {
                                    zeroSet.remove(pi + "" + pj);
                                }
                            }
                        }
                    }
                    else if(arr[i][j] ==0)
                    {
                        zeroSet.add(i+""+j);
                    }
                }
                //System.out.print(",\n");
            }
            x++;
            if (zeroSet.isEmpty()) {
                return x;
            }
        }
        return -1;
    }


}
