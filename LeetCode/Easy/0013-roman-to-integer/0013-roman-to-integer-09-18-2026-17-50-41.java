class Solution {
    public int romanToInt(String s) {
        // M-1 optimal approach | time O(n) | space O(1) 
        int n = s.length();
        // store values of symbols
        Map<Character , Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0 ;
        // itrate on i-1 length string and check if curr ch symbol value is less than next one so sub otherwise add 
        for (int i = 0 ; i < n-1 ; i++){
            if (map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                ans -=  map.get(s.charAt(i));
            }
            else{
                ans += map.get(s.charAt(i));
            }
        }
        ans = ans + map.get(s.charAt(n-1));
        return ans;
    }
}