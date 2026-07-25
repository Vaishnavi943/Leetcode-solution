class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = 0;
        
        // find duplicate number
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicate = Math.abs(nums[i]);
            } else {
                nums[index] = -nums[index];
            }
        }
        
        // find  missing number
        int missing = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }
        
        return new int[] {duplicate, missing};
    }
}