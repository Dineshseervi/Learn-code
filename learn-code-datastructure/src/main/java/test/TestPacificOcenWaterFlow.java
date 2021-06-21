package main.java.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestPacificOcenWaterFlow {

    int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static void main(String[] args) {

       // int [][] matrix={{2,1},{1,2}};
        int [][] matrix= {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        TestPacificOcenWaterFlow testPacificOcenWaterFlow=new TestPacificOcenWaterFlow();
        List<List<Integer>> list=testPacificOcenWaterFlow.pacificAtlantic(matrix);
        System.out.println(Arrays.toString(list.toArray()));

    }


    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;

        int row = matrix.length, col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        //DFS
        for(int i = 0; i < col; i++){
            dfs(matrix, 0, i, Integer.MIN_VALUE, pacific);
            dfs(matrix, row-1, i, Integer.MIN_VALUE, atlantic);
        }
        for(int i = 0; i < row; i++){
            dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
            dfs(matrix, i, col-1, Integer.MIN_VALUE, atlantic);
        }

        //preparing the result
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }

    public void dfs(int[][] matrix, int i, int j, int prev, boolean[][] ocean){
        if(i < 0 || i >= ocean.length || j < 0 || j >= ocean[0].length) return;
        if(matrix[i][j] < prev || ocean[i][j]) return;
        ocean[i][j] = true;
        System.out.println("from outside --------------------> i :"+i+" j:"+j+",    previous : "+prev);
        for(int[] d : dir){
            System.out.println("dir array d0: "+d[0]+" d1: "+d[1]);
            dfs(matrix, i+d[0], j+d[1], matrix[i][j], ocean);
        }

    }
}
