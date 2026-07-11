class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                String subStr = s.substring(0, i);
                StringBuilder newStr = new StringBuilder();
                int numRepeats = n / i;
                
                // Append substring to reconstruct the original string length
                for (int j = 0; j < numRepeats; j++) {
                    newStr.append(subStr);
                }
                
                if (newStr.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
