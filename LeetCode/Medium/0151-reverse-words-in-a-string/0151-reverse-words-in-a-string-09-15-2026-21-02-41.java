class Solution {
    public String reverseWords(String s) {
        // M-1 brut force | time O(n)  | space O(n)
        // strip() fn remove leading and trailing spaces from s , where as replaceAll("\\s+", " ") replaces multiple spaces with a single space
        String s1 = s.strip().replaceAll("\\s+" , " ");
        // split string into words 
        String [] words = s1.split(" ");

        // reverse words arr
        int i = 0 ;
        int j = words.length -1;
        while (i < j){
            // swap 
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }

        // now join whole arr to form result string (using String.join method)
        String result = String.join(" " , words);
        return result;
    }
}