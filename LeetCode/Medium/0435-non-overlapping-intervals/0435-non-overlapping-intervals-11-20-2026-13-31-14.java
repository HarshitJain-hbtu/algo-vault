class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // M-3 greedy approach | time O(n * log n) | space O(1)
        // sort array acc to endtime and checks overlapping intervals 
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int [] item : intervals){
            int s = item[0];
            int e = item[1];

            if (s >= lastEnd){
                // no overlap so just update lastend
                lastEnd = e;
            }else{
                // overlapped then remove this item and no update lastend
                count++;
            }
        }
        return count;
    }
}