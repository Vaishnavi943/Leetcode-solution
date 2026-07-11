class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();

        int left = 0, right=0;

        while(right < arr.length){
            // if find a space, reverse word
            if(arr[right] == ' '){
                reverse(arr, left, right-1);
                left = right + 1;
            }
            right++;
        }
        // revere lat words
        reverse(arr, left, right-1);

        // retyrn string
        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right){
        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            left++;
            arr[right] = temp;
            right--;
        }
    }
}