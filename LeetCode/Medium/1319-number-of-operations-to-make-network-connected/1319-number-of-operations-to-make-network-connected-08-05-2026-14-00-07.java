class Solution {
    int [] parent ;
    int [] rank;
    public int makeConnected(int n, int[][] connections) {
        // M -1 using DSU | time O(n + m) | space O(n) 
        // here we have to connect unconnected computer means union 
        // intuation : find no of components form after processing all the edge then (no of comp -1) ans to connected all component 
        int m = connections.length;
        // min edges req to connect n computer is n-1
        if (m < n-1){
            return -1;
        }
        parent = new int [n];
        rank = new int [n];
        
        for (int i = 0 ; i< n;i++){
            parent[i] = i;
        }

        int component = n ;
        for (int [] arr : connections){
            int u = arr[0];
            int v = arr[1];

            int parent_u = find(u);
            int parent_v = find(v);

            // if parent same means already a connection don't do  union  just skip same component 
            if (parent_u == parent_v){
                continue;
            }
            else{
                union(parent_u, parent_v);
                component--;
            }
        }
        return component -1;
         
    }
    private int find (int v){
        if (v == parent[v]){
            return v ;
        }
        return parent[v] = find(parent[v]);
    }
    private void union (int x , int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent != y_parent){
            if (rank[x_parent] > rank[y_parent]){
                parent[y_parent] = x_parent;
            }
            else if (rank[x_parent] < rank[y_parent]){
                parent[x_parent] = y_parent;
            }
            else {
                parent[x_parent] = y_parent;
                rank[y_parent]++;
            }
        }
    }
}