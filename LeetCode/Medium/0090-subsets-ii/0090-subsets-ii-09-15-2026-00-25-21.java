class Solution {
    // M -2 using Backtraking (to remove duplicates we use set) | time O(n * 2 ^n) | space O(n + n * 2^n)
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        solve(nums , 0 , temp);
        // now convert set into list 
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }
    private void solve (int [] nums , int i , List<Integer> temp){
        // base case
        if (i == nums.length){
            set.add(new ArrayList<>(temp));
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