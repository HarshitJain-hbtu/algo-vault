class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // M-1 using hashmap | time O(m + n) | space O(n)   , where m = ransomNote.length , n = magazine.length 
        Map<Character , Integer> map = new HashMap<>();
        for (char ch : magazine.toCharArray()){
            map.put(ch , map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()){
            if (map.containsKey(ch)){
                int count = map.get(ch);
                if (count == 1){
                    map.remove(ch);
                }
                else{
                    map.put(ch , count-1);
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
}