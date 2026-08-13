class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        // M-1 using priority queue | time O(ElogV) | space O(V + E)
        // O(Elogv)  in worst case we add all edges in pq so logV time to extract min(poll) from pq and we poll E elements and same for insertion E log V
        // create adj list/ graph
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for (int i = 0 ; i< V ;i++){
            adj.add(new ArrayList<>());
        }
        
        for (int [] arr : edges){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];
            
            adj.get(u).add(new int [] {v,w});
            adj.get(v).add(new int [] {u,w});
        }
        
        // initialise dist arr to store shoortest path for each node from source 
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        //  Min-Heap Priority Queue to store {distance, vertex}
        // Ordered by distance ascending
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Compare by distance
            }
            return Integer.compare(a[1], b[1]);     // Tie-breaker: Compare by node ID
        });
        pq.offer(new int[]{0, src});
        
        // dijkstra algo 
        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int currentDist = current[0];
            int u = current[1];
            
            // Optimization: If we've already found a shorter path to this node, skip it
            if (currentDist > dist[u]) {
                continue;
            }
            
            // Traverse all adjacent nodes (neighbors) of the current node
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // Relaxation step: If a shorter path is found, update it and push to PQ
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        
        // conv dist arr into list 
        ArrayList <Integer> result = new ArrayList<>();
        for (int i = 0; i< V ;i++){
            result.add(dist[i]);
        }
        return result;
    }
}