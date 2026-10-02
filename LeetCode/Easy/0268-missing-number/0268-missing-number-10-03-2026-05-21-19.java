class Solution {
    public int missingNumber(int[] nums) {
        // M-3 better approach (by sorting)| time O(n) | space O(n)
        int n = nums.length;
        int [] arr = new int[n+1];
        // now check each index should equal to value
        for (int i = 0 ; i < n ; i++){
            arr[nums[i]]++;
        }
        
        for (int i = 0 ;i <= n; i++){
            if (arr[i] == 0){
                return i ;
            }
        }
        return -1;
    }
}