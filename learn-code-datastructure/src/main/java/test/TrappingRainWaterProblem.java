package main.java.test;

/**
 * 0 1 2 3 4 5 6 7 8 9
 *
 * 7 0 4 2 5 0 6 4 0 5
 * --------------------
 * 0 7 7 7 7 7 7 7 7 7 ->left Array
 *   6 6 6 6 6 5 5 5 5  <right
 *   6 6 6 6 6 F 4 0 5   <min
 *   6 2 4 1 6 s 1 5    <water
 */
public class TrappingRainWaterProblem {

    // Function to find amount of water that can be trapped within
    // given set of bars in linear time and extra space
    public static int trap(int[] bars)
    {
        int n = bars.length;
        int water = 0;

        // left[i] stores the maximum height of a bar to the left
        // of current bar
        int[] left = new int[n-1];
        left[0] = Integer.MIN_VALUE;

        // process bars from left to right
        for (int i = 1; i < n - 1; i++) {
            left[i] = Integer.max(left[i - 1], bars[i - 1]);
            System.out.print("-"+left[i]);
        }

		/*
		int[] right = new int[n];
		right[n - 1] = Integer.MIN_VALUE;
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Integer.max(right[i + 1], bars[i + 1]);
		}

		for (int i = 1; i < n - 1; i++) {
			if (Integer.min(left[i], right[i]) > bars[i]) {
				water += Integer.min(left[i], right[i]) - bars[i];
			}
		}
		*/

        // right stores the maximum height of a bar to the right
        // of current bar
        int right = Integer.MIN_VALUE;

        // process bars from right to left
        for (int i = n - 2; i >= 1; i--) {
            right = Integer.max(right, bars[i + 1]);

            // check if it is possible to store water in current bar
            if (Integer.min(left[i], right) > bars[i]) {
                water += Integer.min(left[i], right) - bars[i];
            }
        }

        return water;
    }

    // Trapping Rain Water within given set of bars
    public static void main(String[] args)
    {
        int[] heights = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 };

        System.out.print("Maximum amount of water that can be trapped is " +
                trap(heights));
    }
}
