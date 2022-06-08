package com.learn.online.question.array;

import java.util.Arrays;

public class CourseScheduler {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        Integer[][] memo = new Integer[courses.length][courses[courses.length - 1][1] + 1];
        return schedule(courses, 0, 0, memo);
    }

    /**
     * Time complexity O(n*d)
     * space complexity is O(n*d) memory array size
     *
     * @param courses
     * @param i
     * @param time
     * @param memo
     * @return
     */
    public int schedule(int[][] courses, int i, int time, Integer[][] memo) {
        if (i == courses.length)
            return 0;
        if (memo[i][0] != null)
            return memo[i][time];
        int taken = 0;
        //System.out.println("---------------");
        //System.out.println("courses[i][0] : "+courses[i][0]);
        //System.out.println("courses[i][1] : "+courses[i][1]);
        //System.out.println("time : "+time);
        //System.out.println("#################");
        if (time + courses[i][0] <= courses[i][1]) {
            taken = 1 + schedule(courses, i + 1, time + courses[i][0], memo);
        }
        //System.out.println("not taken :"+i+1  +" , time :"+time +" ;");
        int not_taken = schedule(courses, i + 1, time, memo);
        //System.out.println("    taken : "+taken);
        //System.out.println("not_taken : "+not_taken);
        memo[i][time] = Math.max(taken, not_taken);
        //System.out.println(Arrays.deepToString(memo));
        return memo[i][time];
    }


    /**
     * Time complexity is O(n*count)
     * space complexity O(1)
     * @param courses
     * @return
     */
    public int scheduleCourseApproch2(int[][] courses) {
        System.out.println(courses.length);
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int time = 0, count = 0;
        for (int i = 0; i < courses.length; i++) {
            if (time + courses[i][0] <= courses[i][1]) {
                time += courses[i][0];
                count++;
            } else {
                int max_i = i;
                for (int j = 0; j < i; j++) {
                    if (courses[j][0] > courses[max_i][0])
                        max_i = j;
                }
                if (courses[max_i][0] > courses[i][0]) {
                    time += courses[i][0] - courses[max_i][0];
                }
                courses[max_i][0] = -1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
         //int[][] courseArray = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        //int[][] courseArray = {{5, 5}, {4, 6}, {2, 6} ,{8,13},{9,15}};
        int[][] courseArray = {{5, 5}, {4, 6}, {2, 6} ,{8,13},{9,15}};
        CourseScheduler courseScheduler=new CourseScheduler();
        int courseTaken= courseScheduler.scheduleCourseApproch2(courseArray);
        System.out.println("course taken:"+courseTaken);
    }
}
