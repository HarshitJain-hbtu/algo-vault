class Solution {
    public boolean checkPerfectNumber(int num) {
        // brut force approach | time complexity O(n) | space O(1)
        // base case 
        if (num == 1){
            return false;
        }
        int sum = 1;
        // starts with two and find all the divisors of num and update sum by add all divisors 
        for (int i = 2 ; i < num ; i++){
            if (num % i == 0){
                sum = sum + i;
            }
        }
        return sum == num;
    }
}