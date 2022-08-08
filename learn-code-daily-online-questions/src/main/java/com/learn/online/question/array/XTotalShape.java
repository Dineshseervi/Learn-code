package com.learn.online.question.array;

/**
 * DP problem bottom up
 * <p>
 * <p>
 * https://practice.geeksforgeeks.org/problems/x-total-shapes3617/1
 */
public class XTotalShape {

    public static final char X_SHAPE = 'X';

    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid) {
        // code here
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 1 && grid[i][j] == X_SHAPE) {
                    boolean val = validate(m, n, i, j, grid, dp);
                    if (val == true) {
                        dp[i][j] = 1;
                        System.out.println("index " + i + " " + j);
                        count++;
                    }
                }
            }
        }

        System.out.println("--------dp-------------");
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        return count;
    }


    private boolean validate(int m, int n, int i, int j, char[][] grid, int[][] dp) {
        boolean flag = true;

        if (i - 1 >= 0) {
            if (dp[i - 1][j] == 1) {
                flag = false;
            }

        }
        if (i + 1 < m) {
            if (dp[i + 1][j] == 1) {
                flag = false;
            }

        }
        if (j - 1 >= 0) {
            if (dp[i][j - 1] == 1) {
                flag = false;
            }

        }
        if (j + 1 < n) {
            if (dp[i][j + 1] == 1) {
                flag = false;
            }
        }

        if (i - 1 >= 0) {
            if (grid[i - 1][j] == X_SHAPE && dp[i - 1][j] != 1) {
                dp[i - 1][j] = 1;
                validate(m, n, i - 1, j, grid, dp);
            }

        }

        if (i + 1 < m) {
            if (grid[i + 1][j] == X_SHAPE && dp[i + 1][j] != 1) {
                dp[i + 1][j] = 1;
                validate(m, n, i + 1, j, grid, dp);

            }
        }

        if (j - 1 >= 0) {
            if (grid[i][j - 1] == X_SHAPE && dp[i][j - 1] != 1) {
                dp[i][j - 1] = 1;
                validate(m, n, i, j - 1, grid, dp);

            }
        }

        if (j + 1 < n) {
            if (grid[i][j + 1] == X_SHAPE && dp[i][j + 1] != 1) {
                dp[i][j + 1] = 1;
                validate(m, n, i, j + 1, grid, dp);

            }
        }

        return flag;
    }


    public static void main(String[] args) {
        char[][] grid = {{X_SHAPE, 'O', 'O', X_SHAPE, X_SHAPE, 'O'}, {'O', 'O', 'O', X_SHAPE, X_SHAPE, X_SHAPE}, {'O', X_SHAPE, X_SHAPE, X_SHAPE, X_SHAPE, X_SHAPE}, {'O', 'O', X_SHAPE, 'O', 'O', X_SHAPE}, {'O', 'O', X_SHAPE, X_SHAPE, 'O', 'O'}};
        XTotalShape xTotalShape = new XTotalShape();
        int count = xTotalShape.xShape(grid);
        System.out.println("Count:" + count);
    }
}
