class Solution {
    public boolean checkPerfectNumber(int num) {
        // optimal  approach | time complexity O(n^1/2) | space O(1)
        // base case 
        if (num == 1){
            return false;
        }
        int sum = 1;
        // starts with two and find all the divisors of num and update sum by add all divisors 
        int i = 2;
        while (i * i <= num){
            if (num % i == 0){
                sum = sum + i ;
                if (num / i  != i){
                    sum = sum + num / i;
                }
            } 
            i++;
        }
        return sum == num;
    }
}