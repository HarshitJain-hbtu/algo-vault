class Solution {
    public boolean isPalindrome(int x) {
        // M-2 better approach (reversing entire num) | time O(log n) | space O(log n)
        if (x < 0 ){
            return false ;
        }
        int revNum = 0;
        int temp = x ;
        while (temp > 0){
            int rem = temp % 10;
            revNum = revNum * 10 + rem;
            temp = temp / 10;
        }
        return (revNum == x);
    }
}