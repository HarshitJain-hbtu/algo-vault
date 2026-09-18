class Solution {
    public String frequencySort(String s) {
        // M -3 optimal approach (using bucket sort with freq arr ) | time O(n) | space O(n|
        // count freq of char | size 128 covers all letters
        int n = s.length();
        int [] arr = new int [128];
        for (char ch : s.toCharArray()){
            arr[ch]++;
        }

        // Create buckets
        List<Character>[] bucket = new ArrayList[n + 1];
         for (int ch = 0; ch < 128; ch++) {

            if (arr[ch] > 0) {
                int count = arr[ch];
                // count should not zero and already not created that bucket[i]
                if (bucket[count] == null) {
                    bucket[count] = new ArrayList<>();
                }

                bucket[count].add((char) ch);
            }
        }
        // count can max up to n (all letters)
        StringBuilder sb = new StringBuilder();
        for (int count = n; count >= 1; count--) {
            if (bucket[count] == null) {
                continue;
            }

            for (char ch : bucket[count]) {
                for (int j = 0; j < count; j++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}