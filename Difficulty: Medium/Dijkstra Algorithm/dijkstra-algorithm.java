class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        // M-2 using set | time O(ElogV) | space O(V + E)
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
        
        // intialize the Treeset to store {distance , node}
        // it is crucial The comparator must differentiate nodes with the SAME distance.
        // If we only compare distances, the Set will treat different nodes with 
        // identical distances as duplicates and refuse to add them.
        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            else {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        set.add(new int[]{0, src});
        
        // dijkstra algo 
        while (!set.isEmpty()){
            // it retrive and poll the lowest value pair
            int[] current = set.pollFirst();
            int currentDist = current[0];
            int u = current[1];
            
            
            // Traverse all adjacent nodes (neighbors) of the current node
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // Relaxation step: If a shorter path is found, update it 
                if (dist[u] + weight < dist[v]) {
                    
                    // If the node 'v' was already reached before but we found a better path,
                    // remove the old, suboptimal distance entry from the set to save space and iteration 
                    if (dist[v] != Integer.MAX_VALUE){
                        set.remove(new int[] {dist[v] , v});
                    }
                    dist[v] = dist[u] + weight;
                    set.add(new int[]{dist[v], v});
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