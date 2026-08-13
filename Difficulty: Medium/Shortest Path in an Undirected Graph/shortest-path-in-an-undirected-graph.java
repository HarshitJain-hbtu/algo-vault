class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        // M-1 using reverse djkstra algo (pq) | time O(ElogV) | space O(E + V)
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        
        for (int i = 0 ; i<= V ;i++){
            adj.add( new ArrayList<>());
        }
        for (int [] arr : edges){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];
            
            adj.get(u).add(new int [] {v, w});
            adj.get(v).add(new int [] {u, w});
        }
        
        // dist arr stores min dis from dest to that node
        int [] dist = new int [V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[dest] =  0;
        
        
        //  Min-Heap Priority Queue to store {distance, vertex}
        // Ordered by distance ascending
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0 , dest});
        
        while (! pq.isEmpty()){
            int[] current = pq.poll();
            int currDist = current[0];
            int u = current[1];
            
            if (currDist > dist[u]){
                continue;
            }
            // explore all neighbou
            for (int[] neighbor : adj.get(u)){
                int v = neighbor[0];
                int weight = neighbor[1];
                
                if (currDist + weight < dist[v]){
                    dist[v] = currDist + weight;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        
        ArrayList <Integer> path = new ArrayList<>();
        // if no path exist 
        if (dist[src] == Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }
        // 2. Build path forwards from SRC, greedily picking the lexicographically smallest valid node
        int curr = src;
        path.add(curr);
        
        
        while (curr != dest) {
            int nextNode = -1;
            
            for (int[] neighbor : adj.get(curr)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                
                // Check if this neighbor is strictly on a shortest path to the destination
                if (dist[v] != Integer.MAX_VALUE && dist[curr] == weight + dist[v]) {
                    
                    // Out of all valid shortest path neighbors, pick the smallest vertex ID
                    if (nextNode == -1 || v < nextNode) {
                        nextNode = v;
                    }
                }
            }
            
            curr = nextNode;
            path.add(curr);
        }
        return path;
    }
}