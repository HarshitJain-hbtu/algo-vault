class Solution {
    public String largestOddNumber(String num) {
        // M-2 optimal approach  | time O(n) | space O(n)
        for (int i = num.length() -1 ; i >=0; i--) {
            int lastDigit = num.charAt(i) - '0';
            if (lastDigit % 2 == 1){
                return num.substring(0 , i+1);
            }
        }
        return "";
    }
}