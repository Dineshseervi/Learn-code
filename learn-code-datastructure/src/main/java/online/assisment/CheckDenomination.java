package main.java.online.assisment;

import java.util.Arrays;

public class CheckDenomination {
    static int solveCoinChange(int[] denominations, int amount) {
        int[] solution = new int[amount + 1];
        solution[0] = 1;

        for (int den: denominations) {                      //-->1 ,2 ,5
            for (int i = den; i < (amount + 1); ++i) {      //-->1 ,2 ,3, 4, 5, 6 ,7  //-> 2-3-4-5-6-7 //5-6-7
                //System.out.print("val:"+solution[i - den]+" , ");//(1-1)=s[0]-1, (2-1) =s[1]
                solution[i] += solution[i - den];
                System.out.print(solution[i]+" ");
            }
            System.out.println("");
        }
        return solution[solution.length - 1];
    }
    public static void main(String[] args) {

        int[] denominations = new int[] {1, 3, 5};
        int amount = 7;
        int result = solveCoinChange(denominations, amount);
        System.out.print("SolveCoinChange(" + Arrays.toString(denominations) +  ", " + amount + ") = ");
        System.out.print(result);
        System.out.println("substring: "+ ("substring".charAt(1) == "sub".charAt(1)));
    }
}
