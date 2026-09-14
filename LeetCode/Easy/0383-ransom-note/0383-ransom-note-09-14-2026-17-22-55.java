class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // M-3 optimal app (using freq arr) | time O(m + n) | space O(k) or O(1), where m = ransomNote.length , n = magazine.length , k <= 26  
        int[] count = new int[26];

        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            if (count[ch - 'a'] == 0) {
                return false;
            }
            count[ch - 'a']--;
        }
        return true;
    }
}