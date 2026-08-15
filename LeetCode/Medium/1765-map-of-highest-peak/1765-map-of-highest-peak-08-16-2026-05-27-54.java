class Solution {
    int m , n;
    private boolean isSafe(int x , int y ){
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
    public int[][] highestPeak(int[][] isWater) {
        // using multiSource BFS | time O(m * n) | space O(m * n) in worst case all cells in queue 
        m = isWater.length;
        n = isWater[0].length;

        int [][] height = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        // filling  height of all watercell is 0 and adding in queue as source 
        for (int i = 0 ; i < m ;i++){
            for (int j = 0 ; j < n; j++){
                if (isWater[i][j] == 1){
                    height[i][j] = 0 ;
                    queue.offer(new int [] {i , j});
                }
                else{
                    height[i][j] = -1;
                }
            }
        }

        int[][] directions = {{1,0}, {0,1},{-1,0}, {0,-1}};

        while(! queue.isEmpty()){
            int N = queue.size();
            while (N-- > 0){
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int[] dir : directions){
                    int x_ = x + dir[0];
                    int y_ = y + dir[1];

                    if (isSafe(x_ , y_ ) && height[x_][y_] == -1){
                        queue.offer(new int[] {x_, y_});
                        height[x_][y_] = height[x][y] + 1;
                    }
                }
            }
        }
        return height;
    }
}