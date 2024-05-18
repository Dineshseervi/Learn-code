class LeetCodeMergeInterval {
    public int[][] merge(int[][] intervals) {
        // will have an array list for new array and then in the end convert that to
        // array
        // we always need to have one pointer
        // [[1,3],[2,6],[8,10],[15,18]]
        // [[1,6],[8,10],[15,18]]

        // [[1,3],[2,6],[8,10],[9,18]]
        // current 8,18
        // in the end insert the current

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] current = intervals[0];

        for (int i = 0; i < intervals.length - 1; i++) {

            if (current[1] >= intervals[i + 1][0] && current[0] <= intervals[i + 1][0]) {

                current[0] = Math.min(intervals[i + 1][0], current[0]);
                current[1] = Math.max(intervals[i + 1][1], current[1]);
            } else if (current[0] >= intervals[i + 1][0] && current[0] >= intervals[i + 1][1]) {

                current[0] = Math.min(intervals[i + 1][0], current[0]);
                current[1] = Math.max(intervals[i + 1][1], current[1]);

            } else if (current[0] >= intervals[i + 1][0] && current[1] >= intervals[i + 1][1]) {

                current[0] = Math.min(intervals[i + 1][0], current[0]);
                current[1] = Math.max(intervals[i + 1][1], current[1]);

            }

            else {
                result.add(current);
                current = intervals[i + 1];
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}
