class Solution {
    int [] parent ;
    int [] rank ;
    public long countPairs(int n, int[][] edges) {
        // M-1 using DSU | time O(n + m ) | space O(n) // m = edges.length
        // here things divided into components like that that's why dsu and then calculate size of components and then 
        // using formula to count pairs:  size * (remain - size)  and update remain 
        parent = new int[n];
        rank = new int[n];

        for (int i = 0 ; i< n;i++){
            parent[i] = i;
        }

        // making components
        for (int [] arr : edges){
            int u = arr[0];
            int v = arr[1];

            union (u , v);
        }

        // creating map that store parent(component) -> size of that component
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i< n;i++){
            int parent = find(i);
            map.put(parent , map.getOrDefault(parent, 0) + 1);
        }
        
        // finding result
        long result = 0;
        long remainNodes = n;
        for (int key : map.keySet()){
            int size = map.get(key);
            result += size * (remainNodes - size);
            remainNodes -= size;
        }
        return result;
    }
    // creating find and union methods using path compression and rank
    private int find (int x){
        if (x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    private void union (int x , int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent != y_parent){
            if (rank[x_parent] > rank[y_parent]){
                parent[y_parent] = x_parent;
            }
            else if (rank[x_parent] < rank [y_parent]){
                parent[x_parent] = y_parent;
            }
            else {
                parent[x_parent] = y_parent;
                rank[y_parent]++;
            }
        }
    }
}