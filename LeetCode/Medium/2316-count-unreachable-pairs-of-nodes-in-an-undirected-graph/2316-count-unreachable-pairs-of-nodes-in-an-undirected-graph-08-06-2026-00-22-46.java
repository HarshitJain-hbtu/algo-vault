class Solution {
    int n ;
    public long countPairs(int N, int[][] edges) {
        // M-3 using BFS | time O(n + m) | space O(n+ m) // m = edges.length
        // here things divided into components like that and then calculate size of components using dfs and bfs
        // using formula to count pairs:  size * (remain - size)  and update remain 
        n = N;
        // creating graph 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i< n;i++){
            adj.add( new ArrayList<Integer>());
        }
        for (int [] arr : edges){
            int u = arr[0];
            int v = arr[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean [] visited = new boolean[n];
        long result = 0;
        long remainNodes = n;
        for (int i = 0 ;i < n;i++){
            if (! visited[i]){
                int size = BFS(adj , i , visited);
                result += size * (remainNodes - size);
                remainNodes -= size;
            }
        }
        return result;
    }
    private int BFS (ArrayList<ArrayList<Integer>> adj , int u , boolean[] visited ){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        visited[u] = true; 
        int size = 1;

        while (!queue.isEmpty()){
            int num = queue.poll();

            for (int v : adj.get(num)){
                if (!visited[v]){
                    queue.offer(v);
                    visited[v] = true;
                    size++;
                }
            }
        }
        

        return size ;
    }
}