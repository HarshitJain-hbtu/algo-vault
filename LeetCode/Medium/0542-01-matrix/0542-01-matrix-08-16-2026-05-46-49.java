class Solution {
    int m , n;
    private boolean isSafe(int x , int y ){
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
    public int[][] updateMatrix(int[][] mat) {
        // intuation is all zero cells have dist 0 of nearest so it will not change  we traverse  all neighbor cells of zero simultaneously and inc dist by 1 like Multi source BFS
        // using multiSource BFS | time O(m * n) | space O(m * n) in worst case all cells in queue 
        m = mat.length;
        n = mat[0].length;

        // result matrix stores dist of nearest 0 for each cell
        int [][] result = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        // filling  dist of all cell of '0' is 0 and adding in queue as source 
        for (int i = 0 ; i < m ;i++){
            for (int j = 0 ; j < n; j++){
                if (mat[i][j] == 0){
                    result[i][j] = 0;
                    queue.offer(new int [] {i , j});
                }
                else{
                    result[i][j] = -1;
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

                    if (isSafe(x_ , y_ ) && result[x_][y_] == -1){
                        queue.offer(new int[] {x_, y_});
                        result[x_][y_] = result[x][y] + 1;
                    }
                }
            }
        }
        return result;
    }
}