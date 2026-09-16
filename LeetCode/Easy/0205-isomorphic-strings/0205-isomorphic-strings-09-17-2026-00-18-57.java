class Solution {
    public boolean isIsomorphic(String s, String t) {
        // M-1 brut force | time O(n*n) | space O(1)
        // checking each pair in string s & t
        int n = s.length();
        for (int i = 0 ; i < n ; i++){
            for (int j = i+1; j < n ;j++){
                // if same char in s
                // then must mapped to same char in t otherwise false
                if(s.charAt(i) == s.charAt(j)){
                    if (t.charAt(i) != t.charAt(j)){
                        return false;
                    }
                }
                // if diff char in s 
                // then must mapped to diff char in t otherwise false
                else{
                    if (t.charAt(i) == t.charAt(j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}