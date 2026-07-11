class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths don't match, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for the 26 lowercase English letters
        int[] charCount = new int[26];

        // Increment count for string s, decrement for string t
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
