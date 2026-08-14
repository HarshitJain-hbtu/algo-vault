class Solution {
    // M-1 using dijkstra algorithm | time O(m * n * log(m*n)) | space O(m * n)
    private int[] [] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    private boolean isSafe (int x , int y , int m , int n){
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        // stores min effort from source(0,0) to that node
        int [][] result = new int[m][n];
        for (int [] row : result){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        // creating pq to implement dijkstra stores as min heap 
        // pq of type int [] which stores {diff , x , y}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        result[0][0] = 0;
        pq.offer(new int []{0,0,0});

        while (!pq.isEmpty()){
            int [] curr = pq.poll();
            int diff = curr[0];
            int x = curr[1];
            int y = curr[2];

            // we just return when we reach last node bcz we keep maintain min heap so all below entries  in queue for same last cell and diffcell have maxDiff is higher 
            if (x == m-1 && y == n-1){
                return diff;
            }
            // explore all paths from that node 
            for (int [] dir : directions){
                int x_ = x + dir[0];
                int y_ = y + dir[1];

                if (isSafe(x_ , y_ , m , n)){
                    int heightDiff = Math.abs(heights[x_][y_] - heights[x][y]);
                    int maxDiff = Math.max(diff,heightDiff);
                    // if maxDiff is lesser than effort stored then update
                    if (maxDiff < result[x_][y_]){
                        result[x_][y_] = maxDiff;
                        pq.offer(new int [] {maxDiff , x_ , y_});
                    }
                }
            }
        }
        return result[m-1][n-1];
    }
}