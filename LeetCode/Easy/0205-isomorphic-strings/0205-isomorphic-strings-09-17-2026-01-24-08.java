class Solution {
    public boolean isIsomorphic(String s, String t) {
        // intuation store each pair in two maps from s to t and t to s , if we get repeat one then it should be mapped to same char as it mapped before and if new pair so store 
        // M-2 better approach  | time O(n) | space O(1)
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0 ; i < s.length();i++){
            char a = s.charAt(i);
            char b = t.charAt(i);

            // if char already exists then it should be mapped to same otherwise false
            if (map1.containsKey(a) && map1.get(a) != b){
                return false;
            }
            if (map2.containsKey(b) && map2.get(b) != a){
                return false;
            }
            
            // store current mapping
            map1.put(a,b);
            map2.put(b,a);
        }
        return true;
    }
}