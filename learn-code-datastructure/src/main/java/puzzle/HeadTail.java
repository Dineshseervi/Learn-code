package main.java.puzzle;

public class HeadTail {

    private static void puzzle(int coins, int people) {
        boolean[] headTails = new boolean[coins];
        //head=true
        //tail =false
        for (int i = 0; i < coins; i++) {
            headTails[i] = true;
        }

        for (int i = 2; i <= people; i++) {

            for (int j = 0; j < coins; j++) {

                if ((j + 1) % i == 0) {
                    boolean value = headTails[j];
                    if (value == true) {
                        headTails[j] = false;
                    } else {
                        headTails[j] = true;
                    }
                }
            }
        }
        int headCount = 0;
        for (int k = 0; k < coins; k++) {
            if (headTails[k] == true) {
                headCount++;
            }
        }

        System.out.println("count:" + headCount);
    }

    public static void main(String[] args) {
        HeadTail.puzzle(1100, 1100);

    }
}
