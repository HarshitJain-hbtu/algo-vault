class Solution {
    public int romanToInt(String s) {
        // M-2 more optimal approach (using value arr to store symbols)| time O(n) | space O(1) 
        int n = s.length();

        // store values of symbols
        int [] value = new int[128];
        value['I'] = 1;
        value['V'] = 5;
        value['X'] = 10;
        value['L'] = 50;
        value['C'] = 100;
        value['D'] = 500;
        value['M'] = 1000;

        int ans = 0 ;
        // itrate on i-1 length string and check if curr ch symbol value is less than next one so sub otherwise add 
        for (int i = 0 ; i < n-1 ; i++){
            if (value[s.charAt(i)] < value[s.charAt(i+1)]){
                ans -=  value[s.charAt(i)];
            }
            else{
                ans += value[s.charAt(i)];
            }
        }
        ans = ans + value[s.charAt(n-1)];
        return ans;
    }
}