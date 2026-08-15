class Solution {
    int m ; 
    int n ;
    private boolean isSafe (int x , int y ){
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
    public int orangesRotting(int[][] grid) {
        // using multiSource BFS | time O(m * n) | space O(m * n) in worst case we add all in queue 
        m = grid.length;
        n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0 ;
        // add all rotten oranges as sources in queue
        for (int i = 0 ; i< m ;i++){
            for (int j = 0 ; j < n;j++){
                if (grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                else if (grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        // if already no freshoranges 
        if (freshOranges == 0){
            return 0 ;
        }

        int [][] directions  = {{1,0} , {0,1} , {-1,0} , {0,-1}};
        int minutes = 0 ;

        while(!queue.isEmpty()){
            int N = queue.size();
            // this rep level of bfs 
            while(N-- > 0){
                int [] current = queue.poll();
                int x = current[0];
                int y = current[1];

                // exploring neighbor of each rotten orange in this level 
                for (int [] dir : directions){
                    // x_ and y_ represent neigh coor 
                    int x_ = x + dir[0];
                    int y_ =  y + dir[1];

                    // if neighbor is safe and fresh so mark as rotten and add in queue 
                    if (isSafe(x_, y_) && grid[x_][y_] == 1){
                        grid[x_][y_] = 2;
                        queue.offer(new int[] {x_,y_});
                        freshOranges--;
                    }
                }
            }
            // after each level min++
            minutes++;
        }
        return freshOranges == 0 ? minutes -1 : -1;
    }
}