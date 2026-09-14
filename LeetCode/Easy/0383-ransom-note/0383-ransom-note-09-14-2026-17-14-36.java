class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // M-2 by checking subsequence (brutforce) | time O(m * log m + n * logn) | space O(m + n)   , where m = ransomNote.length , n = magazine.length 

        // sort both strings 
        char [] s1 = ransomNote.toCharArray();
        Arrays.sort(s1);
        String newS1 = new String(s1);

        char [] s2 = magazine.toCharArray();
        Arrays.sort(s2);
        String newS2 = new String(s2);

        // now check s1 is subsequence of s2 or not 
        int i = 0 , j = 0 ; 
        while (i < newS1.length()  && j < newS2.length()){
            if (newS1.charAt(i) == newS2.charAt(j)){
                i++;
            }
            j++;
        }
        return i == newS1.length();
    }
}