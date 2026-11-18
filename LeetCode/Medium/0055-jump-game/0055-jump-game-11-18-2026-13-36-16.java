class Solution {
    public boolean canJump(int[] nums) {
        // M-3 bottom up approach O(n^2)    // simply creating the array contain for each index can we reach that index via any previous ones or not
        int n = nums.length;
        boolean  [] t = new boolean [n];

        //t[i] = True means, you can reach index i
        //t[i] = false means, you can't reach index i

        t[0] = true;    //initially at starting index

        for(int i = 1;i < n ;i++){
            for (int j = i-1;j >=0;j--){
                if(t[j] == true && j+nums[j] >= i ){
                    t[i] = true;
                    break;
                }
            }
        }

        return t[n-1];
    }
}