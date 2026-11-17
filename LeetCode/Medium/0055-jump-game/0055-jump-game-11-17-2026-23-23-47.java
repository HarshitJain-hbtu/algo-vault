class Solution {
    public boolean canJump(int[] nums) {
        // trick soln O(n) and space O(1) in bottom up it is O(n)
        int n = nums.length ;
        int maxReachable = 0;

        for(int i = 0; i < n ;i++){
            // this condn checks for every index that it is reachable from any previous index or not 
            if (i > maxReachable){      // means that curr index is not reachable 
                return false;
            }
            // update maxReachable
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }
}