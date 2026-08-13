class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // intuation - here weight are diff so dijkstra (No bfs) so using dijkstra we find min dist or time to all nodes from source and then return max of all dist bcz we need min dist to reach all nodes 
        // M-1 using dijkstra algorithm  | time O(V + E) | space O(V + E)

        // creating adj list 
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();

        for (int i = 0 ;i <= n; i++){
            adj.add( new ArrayList<>());
        }

        for (int [] arr : times){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];

            adj.get(u).add(new int [] {v, w});
        }
        // creating dist arr stores min time/dist  (for all node) from source to that node
        int [] dist = new int [n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0 ;

        //  Min-Heap Priority Queue to store {distance, vertex}
        // Ordered by distance ascending
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int [] {0 , k});

        while (!pq.isEmpty()){
            int [] current = pq.poll();
            int currDist = current [0];
            int u = current[1];

            // If we've already found a shorter path to this node, skip it
            if (currDist > dist[u]){
                continue ;
            }

            // exploring neighbors 
            for (int [] neighbor : adj.get(u)){
                int v = neighbor[0]; 
                int weight = neighbor[1];

                if (currDist + weight < dist[v]){
                    dist[v] = currDist + weight ;
                    pq.offer(new int [] {dist[v], v});
                }
            }
        }
        // calculating max
        int ans = dist[1] ;
        for (int i = 1 ; i < n+1 ;i++){
            ans = Math.max(ans , dist[i]);
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}