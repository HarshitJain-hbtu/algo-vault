class Solution {
    int n ;
    boolean hasCycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // M-1 using  topological sort(using DFS)| intuation : we use topological sort order using  dfs bcz in directed graph mein we cant take element randomly (prereqsite) with them we also check that cycle is form or not in Directed graph using DFS if there is cycle is present so we return empty array otherwise ans 
        // time O(V + E) and space O(V + E)

        n = numCourses;

        // creating graphh 
        ArrayList <ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0 ;i < n;i++){
            adj.add( new ArrayList<Integer>());
        }

        for (int [] arr : prerequisites){
            int u = arr[1];
            int v = arr[0];

            adj.get(u).add(v);
        }
        boolean[] visited = new boolean[n];
        boolean[] inRecursion = new boolean[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0 ; i < n;i++){
            if(!visited[i] ){
                DFS(adj , i, visited, inRecursion , stack);
            }
        }

        if (hasCycle){
            return new int[] {};
        }

        int [] result = new int[n];
        int x = 0 ;
        while (!stack.isEmpty()){
            int num = stack.pop();
            result[x++] = num;
        }
        return result;
    }
    private void DFS (ArrayList <ArrayList<Integer>> adj , int u , boolean [] visited , boolean[] inRecursion, Stack<Integer> stack){
        visited[u] = true;
        inRecursion[u] = true;
        // phle mere 'u' ke baccho ke stack mei daalo then mujhe 
        for (int v : adj.get(u)){
            if (!visited[v]){
                DFS(adj, v, visited, inRecursion,stack);
            }
            else if (inRecursion[v] == true){
                hasCycle = true;
                return;
            }
        }
        inRecursion[u] = false;
        stack.push(u);
    }
}