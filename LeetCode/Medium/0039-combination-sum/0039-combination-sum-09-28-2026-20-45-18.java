class Solution {
    // M -1 better approach | time O(2 ^ (n + k/m)) | space O(n + k/m)   // k/m is target / smallest element  overall indicate max take operation 
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        solve (candidates , target , temp , 0 , 0);
        return result;
    }
    private void solve (int [] nums , int target , List<Integer> temp, int sum , int i){
        if (sum == target){
            result.add(new ArrayList<>(temp));
            return ;
        }
        if (i == nums.length || sum > target){
            return ;
        }

        // take ith element  and agian not inc i
        sum = sum + nums[i];
        temp.add(nums[i]);
        solve(nums ,target ,temp , sum , i);

        // not take i 
        sum = sum - nums[i];
        temp.remove(temp.size()-1);
        solve(nums ,target ,temp ,sum , i+1);
    }
}