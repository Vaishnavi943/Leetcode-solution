class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int maxFreq = 0;
        char maxChar = ' ';
        
        // 1. Count frequencies and track the most frequent character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > maxFreq) {
                maxFreq = freq[c - 'a'];
                maxChar = c;
            }
        }
        
        // 2. If the most frequent character exceeds half the spots, it's impossible
        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }
        
        char[] result = new char[s.length()];
        int index = 0;
        
        // 3. Place the most frequent character first at even indices
        while (freq[maxChar - 'a'] > 0) {
            result[index] = maxChar;
            index += 2;
            freq[maxChar - 'a']--;
        }
        
        // 4. Fill out the remaining characters into the remaining slots
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (index >= result.length) {
                    index = 1; // Switch to odd indices when even slots are full
                }
                result[index] = (char) (i + 'a');
                index += 2;
                freq[i]--;
            }
        }
        
        return String.valueOf(result);
    }
}
