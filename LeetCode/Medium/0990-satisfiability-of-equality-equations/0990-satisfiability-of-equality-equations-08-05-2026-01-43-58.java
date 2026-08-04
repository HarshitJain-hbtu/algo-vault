class Solution {
    // M-1 using DSU | time complex O(V + E) | space O(V)
    int [] parent ;
    int [] rank;

    public boolean equationsPossible(String[] equations) {
        parent = new int [26];
        rank = new int [26];
        for (int i = 0 ;i < 26 ;i++){
            parent[i] = i ;
        }
        // union all the == cases 
        for (String s : equations){
            if (s.charAt(1) == '='){    // a==b 
                union(s.charAt(0) - 'a' , s.charAt(3) - 'a');
            }
        }
        for (String s : equations){
            // check validity for != 
            if (s.charAt(1) == '!'){
                char x = s.charAt(0);
                char y = s.charAt(3);
                if (find(x - 'a') == find(y - 'a')){
                    return false;
                }
            }
        }
        return true;
    }
    private int find (int v){
        if (v == parent[v]){
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    private void union (int x , int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent != y_parent){
            // if rank equal      
            if (rank[x_parent] > rank[y_parent]){
                parent[y_parent] = x_parent;
            }
            else if (rank[x_parent] < rank[y_parent]){
                parent[x_parent] = y_parent;
            }
            else {
                // ranks equal then 
                parent[x_parent] = y_parent;
                rank[x_parent]++;
            }
        }
    }
}