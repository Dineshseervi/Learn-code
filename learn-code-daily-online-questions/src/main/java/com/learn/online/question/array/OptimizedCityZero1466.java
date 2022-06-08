package com.learn.online.question.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class OptimizedCityZero1466 {
    public int minReorder(int n, int[][] connections) {
        boolean[][] adj = new boolean[n][n];
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;

        for(int[] c : connections) {
            adj[c[0]][c[1]] = true;
        }
        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int city = queue.poll();
            for(int i = 0; i < n; i++) { //check column
                if(adj[i][city] == true && visited[i] == false) {
                    queue.add(i);
                    visited[i]=true;
                }
            }
            for(int i = 0; i < n; i++) {//check row
                if(adj[city][i] == true && visited[i] == false) {
                    cnt++;
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        OptimizedCityZero1466 cityZero1466 = new OptimizedCityZero1466();
        int[][] arr = {{0, 2}, {0, 3}, {4, 1}, {4, 5}, {5, 0}};
        System.out.println(cityZero1466.minReorder(6, arr));
    }


}
