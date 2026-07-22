
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int totalElements = 1 << n; // Equivalent to 2^n
        
        for (int i = 0; i < totalElements; i++) {
            result.add(i ^ (i >> 1)); // Formula to convert binary to Gray code
        }
        
        return result;
    }
}
