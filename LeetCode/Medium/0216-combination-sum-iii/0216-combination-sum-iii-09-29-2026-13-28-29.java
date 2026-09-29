class Solution {
    // using recursion | time O(2 ^ 9 + R * k) | space O(R * k) 
    List<List<Integer>> result = new ArrayList<>();
    int K ;
    public List<List<Integer>> combinationSum3(int k, int n) {
        K = k;
        if (k > n){
            return new ArrayList<>();
        }
        ArrayList<Integer> temp = new ArrayList<>();
        solve(k , n , temp , 1);
        return result;
    }
    private void solve (int k , int n , List<Integer> temp , int i){
        if (n == 0){
            if (temp.size() == K){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        if (i > 9 || k <= 0 || n < 0 || 10 - i < k){
            return ;
        }

        // take 
        if (n >= i){
            temp.add(i);
            solve(k-1, n-i,temp, i+1);
            temp.remove(temp.size()-1);
        }

        // not take 
        solve(k , n ,temp , i+1);
    }
}