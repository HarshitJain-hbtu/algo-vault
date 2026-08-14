class Solution {
    int n ;
    // possible 8 directions for movement
    private int [][] directions = {{1,0}, {-1,0}, {0,1}, {0 ,-1}, {1,1},{1,-1}, {-1,1},{-1,-1}};

    private boolean isSafe (int x , int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        // M-1 using bfs (all weight are equal for one cell to another cell) | time O(N * N) in worst case we might visit each cell of matrix | space O(N * N)  max size of queue at any level 

        n = grid.length;

        if (n == 0 || grid[0][0] == 1){
            return -1;
        }
        int levels = 1 ;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        grid[0][0] = 1;   // Mark as visited

        while (!queue.isEmpty()){
            int N = queue.size();
            // here we process all cells at that current levels BFS
            while (N-- > 0){
                int [] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];

                // if current cell is dest 
                if (x == n-1 && y == n-1){
                    return levels;
                }
                // check for all directions we can move 
                for (int [] arr : directions){
                    int x_ = x + arr[0];
                    int y_ = y + arr[1];

                    if (isSafe(x_ , y_ ) && grid[x_][y_] == 0){
                        queue.offer(new int [] {x_ ,y_});
                        grid[x_][y_] = 1;
                    }
                }
            }
            // increse level count after finishing each level 
            levels++;
        }
        // means we cant reach dest  
        return -1;
    }
}