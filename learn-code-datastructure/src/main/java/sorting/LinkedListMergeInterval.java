class LinkedListMergeInterval {
    public int[][] merge(int[][] intervals) {
        // sorting
      // LinkedList to fetch last element
      // compare last element should be small then current element 
      // otherwise update the current last element with Math max of current and next

        LinkedList<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //int[] current = intervals[0];

        for( int []interval:intervals )
        {
            if(result.isEmpty()|| result.getLast()[1]<interval[0])
            {
                result.add(interval);
            }else{
            result.getLast()[1]=Math.max(result.getLast()[1],interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
