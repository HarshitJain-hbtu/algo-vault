class Solution {
    public void floydWarshall(int[][] dist) {
        // traverse each edge through every via 
        // floyd warshall algo (multisource shortest path algorithm ) | time O(n^3) | space O(1)
        int n = dist.length;
        int INF = 1000_000_00;
        
        for (int via = 0 ; via < n; via++){
            for (int i = 0 ; i< n ; i++){
                for (int j = 0 ; j< n ; j++){
                    // If either part of the path doesn't exist,
                    // don't calculate the sum.
                    if (dist[i][via] == INF || dist[via][j] == INF) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j] , dist[i][via] + dist[via][j]);
                }
            }
        }
        
    }
}