class Solution {
    public boolean isPerfectSquare(int num) {
        
        if (num == 1) {
            return true;
        }
        
        long left = 1;
        long right = num / 2; 
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            
            if (square == num) {
                return true; // Found the perfect square root
            } else if (square < num) {
                left = mid + 1; // Search the higher half
            } else {
                right = mid - 1; // Search the lower half
            }
        }
        
        return false;
    }
}
