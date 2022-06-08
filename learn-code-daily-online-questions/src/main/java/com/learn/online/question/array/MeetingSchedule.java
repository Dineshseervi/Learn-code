package com.learn.online.question.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class MeetingSchedule {


    public int solve(ArrayList<ArrayList<Integer>> A) {
        int sA = A.size();

        Collections.sort(A, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        ArrayList<ArrayList<Integer>> num = new ArrayList();
        for (ArrayList<Integer> inerList : A) {
            int start = inerList.get(0);
            int end = inerList.get(1);

            addToList(num, start, end);
        }


        return num.size();
    }

    private void addToList(ArrayList<ArrayList<Integer>> num, int start, int end) {
        boolean flag = false;
        for (ArrayList<Integer> innerList : num) {
            int ls = innerList.get(0);
            if (ls >= end) {
                innerList.add(0, start);
                innerList.add(1, end);
                flag = true;
                break;
            } else if (innerList.get(innerList.size() - 1) <= start) {
                innerList.add(start);
                innerList.add(end);
                flag = true;
                break;
            }

        }

        if (!flag) {
            ArrayList<Integer> newList = new ArrayList<>();
            newList.add(start);
            newList.add(end);
            num.add(newList);
        }
    }

    //https://www.interviewbit.com/problems/meeting-rooms/
    //https://letstalkalgorithms.com/meeting-rooms-leetcode/

    public static int findMinNoOfMeetingRooms(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.size() == 0)
            return 0;
        Collections.sort(A, (a, b) -> a.get(0).compareTo(b.get(0)));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 1;
        queue.offer(A.get(0).get(1));
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i).get(0) < queue.peek()) {
                count++;
            } else {
                queue.poll();
            }
            queue.offer(A.get(i).get(1));
        }

        return count;
    }

    /**
     * 1,18
     * 2,11
     * 4,15
     * 5,13
     * 15,29
     * 18,23
     * <p>
     * o/p->4
     * <p>
     * 1. Sort the array
     * 2. Create a instance of PQ (min)
     * 3. iterate over input array List
     * 1.1. If queue is empty add element to that (here adding meeting end-time).
     * 1.2. Increment the count.
     * 1.3.next
     * 2.1.-->if queue.peek element is higher then start of next meeting time .. (we have a sorted array)
     * 2.2 -->increment the room
     * 2.3 -->
     *
     * @param A
     * @return
     */
    public int solveMinHeap(ArrayList<ArrayList<Integer>> A) {

        Collections.sort(A, (a, b) -> a.get(0) - b.get(0));

        PriorityBlockingQueue<Integer> minPq = new PriorityBlockingQueue<>();
       // new PriorityBlockingQueue<>(1,)
        int room = 0;
        for (int i = 0; i < A.size(); i++) {

            if (minPq.isEmpty()) {

                room++;
                minPq.add(A.get(i).get(1));

            } else {

                if (minPq.peek() > A.get(i).get(0)) {

                    room++;
                } else {

                    minPq.poll();
                }
                minPq.add(A.get(i).get(1));
            }
        }
        return room;

    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> aa = new ArrayList<>();
        aa.add(1);
        aa.add(18);

        ArrayList<Integer> bb = new ArrayList<>();
        bb.add(18);
        bb.add(23);

        ArrayList<Integer> cc = new ArrayList<>();
        cc.add(15);
        cc.add(29);

        ArrayList<Integer> dd = new ArrayList<>();
        dd.add(4);
        dd.add(15);

        ArrayList<Integer> ee = new ArrayList<>();
        ee.add(2);
        ee.add(11);

        ArrayList<Integer> ff = new ArrayList<>();
        ff.add(5);
        ff.add(13);

        A.add(aa);
        A.add(bb);
        A.add(cc);
        A.add(dd);
        A.add(ee);
        A.add(ff);

        MeetingSchedule meetingSchedule = new MeetingSchedule();
        int count = meetingSchedule.solveMinHeap(A);
        System.out.println("count: " + count);

    }
}
