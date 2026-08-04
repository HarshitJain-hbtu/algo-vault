class Solution {
    int [] parent ; 
    int [] rank ;
    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        // time comp O(V + E) | space O(V)
        parent = new int [V];
        rank = new int [V];
        for (int i = 0 ;i < V;i++){
            parent[i] = i;
            rank[i] = 0 ;
        }
        // process all edges if we get same parent then cycle is present if not same parent then union means there is edge btw both vertex 
        // bcz if parent same means already a edge btw two vertex to its parent and now we again get edge btw both edge means cycle form 
        for (int u = 0 ;u < V ;u++){
            for (int v : adj.get(u)){
                // process each edge once 
                if (u < v){
                    int parent_x = find(u);
                    int parent_y = find(v);
                    if (parent_x == parent_y){
                        return true;
                    }
                    union(u , v);
                }
            }
        }
        return false;
    }
    
    
    // find and union method using path compression and rank 
    private int find (int v ){
        if (v == parent[v]){
            return v;
        }
        return parent[v] = find(parent[v]);
    }
    
    private void union (int x , int y ){
        int x_parent = find(x);
        int y_parent = find(y);
        
        // if both parents not same then only union 
        if (x_parent != y_parent){
            // jiski rank badi wo parent but not inc in rank 
            if (rank[x_parent] > rank[y_parent]){
                parent[y_parent] = x_parent;
            }
            else if (rank[y_parent] > rank[x_parent]){
                parent[x_parent] = y_parent;
            }
            else {
                // if rank equal then one of them become parent and rank inc by one 
                parent[x_parent] = y_parent;
                rank[y_parent]++;
            }
        }
    }
}