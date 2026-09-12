class Solution {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // intuation is if we itrate ones if we start with valid index and reach the last index without the negative rem or with a +ve value means we got ans and initially we check that soln exist or not using base case 
        // greedy approach  | time O(n ) & space O(1)
        int n = gas.length;
        
        int totalGas = 0 ; int totalCost = 0 ;
        for (int i = 0 ; i < n ;i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        // (base case) no soln exist 
        if (totalGas < totalCost){
            return -1;
        }
        int currGas = 0 ; int startIndex = 0 ;
        for (int i = 0 ; i < n;i++){
            currGas += gas[i] - cost[i];

            // if currGas < 0 then reset startIndex and currGas(basically check rem)
            if (currGas < 0 ){
                startIndex = i+1;
                currGas = 0 ;
            }
        }
        return startIndex;
    }
}