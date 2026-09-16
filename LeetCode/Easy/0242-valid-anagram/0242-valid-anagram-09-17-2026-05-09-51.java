class Solution {
    public boolean isAnagram(String s, String t) {
        // M -2 better approach | time O(n) | space O(n)
        if (s.length() != t.length()){
            return false;
        }
        int n = s.length();
        Map<Character , Integer> map = new HashMap<>();
        for (int i = 0 ; i < n ;i++){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0 ; i < n ;i++){
            if (!map.containsKey(t.charAt(i))){
                return false;
            }
            else{
                if (map.get(t.charAt(i)) == 1){
                    map.remove(t.charAt(i));
                }else{
                    int count = map.get(t.charAt(i));
                    map.put(t.charAt(i) , count-1);
                }
            }
        }
        return true;
    }
}