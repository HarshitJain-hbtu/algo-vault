class Solution {
    public double myPow(double x, int n) {
        // M -3 better approach using recursion | time O(log n) | space O(log n)
        long N = n;
        if (N < 0){
            return 1 / power(x ,-N);
        }
        return power(x , N);
    }
    private double power (double x , long n){
        // base case 
        if (n == 1){
            return x;
        }
        if (n == 0){
            return 1;
        }
        // if power is odd 
        if (n % 2 == 1){
            return x * power(x , n -1);
        }
        // power is even
        return power (x * x , n/2);
    }
}