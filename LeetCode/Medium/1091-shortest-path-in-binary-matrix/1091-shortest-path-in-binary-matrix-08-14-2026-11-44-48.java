class Solution {
    // possible 8 directions for movement
    private int [][] directions = {{1,0}, {-1,0}, {0,1}, {0 ,-1}, {1,1},{1,-1}, {-1,1},{-1,-1}};

    private boolean isSafe (int x , int y, int n){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        // M-2 using dijkstra algo (finding min dis form source for each cell) |time O(N^2 * logN) |space O(N * N)
        // in dijkstra we use E * logV here vertices = N*N (all cells) so E = 8 * N^2
        int n = grid.length;

        if (n == 0 || grid[0][0] == 1){
            return -1;
        }

        int [][] result = new int [n][n];
        for (int [] row : result){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Priority queue to act as a min-heap.
        // Stores arrays of size 3: {distance, x, y}
        // Ordered by the distance (index 0)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] {0, 0 ,0});
        result[0][0] = 0;
        grid[0][0] = 1;   // Mark as visited

        while (!pq.isEmpty()){
            int [] curr = pq.poll();
            int d = curr[0];
            int x = curr[1];
            int y = curr[2];

            // check for all directions we can move 
            for (int [] dir : directions){
                int x_ = x + dir[0];
                int y_ = y + dir[1];
                int dist = 1;
                if (isSafe(x_ , y_ , n ) && grid[x_][y_] == 0 && d + dist < result[x_][y_]){
                    pq.offer(new int [] {d + dist, x_ ,y_});
                    result[x_][y_] = d + dist;
                    grid[x_][y_] = 1;
                }
            }
        }
        if (result[n-1][n-1] == Integer.MAX_VALUE){
            return -1;
        }
        return result[n-1][n-1] + 1;
    }
}