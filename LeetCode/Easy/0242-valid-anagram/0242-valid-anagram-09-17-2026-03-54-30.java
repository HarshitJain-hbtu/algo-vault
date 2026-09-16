class Solution {
    public boolean isAnagram(String s, String t) {
        // M -1 brut force | time O(n * log n) | space O(n)
        if (s.length() != t.length()){
            return false;
        }
        char [] S = s.toCharArray();
        char [] T = t.toCharArray();
        Arrays.sort(S);
        Arrays.sort(T);

        String a = new String (S);
        String b = new String (T);
        return a.equals(b);
    }
}