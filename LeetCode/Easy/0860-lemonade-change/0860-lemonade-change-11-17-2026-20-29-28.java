class Solution {
    public boolean lemonadeChange(int[] bills) {
        // simple gready | time O(n) | space O(1)
        int five = 0 , ten = 0 , twenty = 0 ; 
        for (int num : bills){
            if (num == 5){
                five++;
            }
            else if (num == 10){
                if (five == 0){
                    return false;
                }
                ten++;
                five--;
            }
            else{
                if (five >= 1 && ten >= 1){
                    twenty++;
                    five--;
                    ten--;
                }
                else if (five >= 3){
                    twenty++ ;
                    five = five - 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}