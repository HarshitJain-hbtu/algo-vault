class Solution {
    // M -1 better approach (we can also like this )| time O(2 ^ (n + k/m)) | space O(n + k/m)   // k/m is target / smallest element  overall indicate max take operation 
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        solve (candidates , target , temp , 0);
        return result;
    }
    private void solve (int [] nums , int remaining , List<Integer> temp, int i){
        if (remaining == 0){
            result.add(new ArrayList<>(temp));
            return ;
        }
        if (i == nums.length || remaining  < 0){
            return ;
        }

        // take ith element  and agian not inc i
        if (nums[i] <= remaining) {
            temp.add(nums[i]);
            solve(nums, remaining - nums[i], temp , i);
            temp.remove(temp.size() - 1);
        }
        // not take ith element 
        solve(nums ,remaining ,temp ,i+1);
    }
}