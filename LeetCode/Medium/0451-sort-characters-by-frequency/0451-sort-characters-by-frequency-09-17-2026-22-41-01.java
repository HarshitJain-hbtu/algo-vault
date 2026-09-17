class Solution {
    public String frequencySort(String s) {
        // M -2 better approach | time O(n + k log k) | space O(k + n) | k <= 26 so k is like constant  
        int n = s.length();
        // counting freq 
        Map<Character , Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch, 0) + 1);
        }
        // store unique chars 
        List<Character> list = new ArrayList<>(map.keySet());

        // sort characters by dec freq 
        list.sort((a, b) -> map.get(b) - map.get(a));
        
        StringBuilder sb = new StringBuilder();
        for (char ch : list){
            int count = map.get(ch);

            while(count-- > 0){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}