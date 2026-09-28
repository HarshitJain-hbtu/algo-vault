class Solution {
    public int countPrimes(int n) {
        // M -3  optimal approach  (Sieve of Eratosthenes) | time O(n * log(log n) ) | space O(n)
        // key observation is that if a number is prime, all its multiples (except itself) are composite.
         if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        // handle case of 0 and 1 
        isPrime[0] = false;
        isPrime[1] = false;

        // Iterate through possible prime factors
        for (int i = 2; i <= (n - 1) / i; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0 ;
        for (int i = 2 ; i < n; i++){
            if (isPrime[i]){
                count++;
            }
        }
        return count;
    }
}