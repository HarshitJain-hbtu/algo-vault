class Solution {
    // M -1 using Backtraking (recursion) | time O(n * 2 ^n) | space O(n + n * 2^n)
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        solve(nums , 0 , temp);
        return result;
    }
    private void solve (int [] nums , int i , List<Integer> temp){
        // base case
        if (i == nums.length){
            if (!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
            return ;
        }

        // taking ith element
        temp.add(nums[i]);
        solve(nums ,i + 1 , temp);
        // not taking ith element
        temp.remove(temp.size()-1);
        solve(nums , i + 1 ,temp);
    }
}