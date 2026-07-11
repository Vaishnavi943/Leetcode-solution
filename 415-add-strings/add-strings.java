class Solution {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int base = 10;

        while(p1 >= 0 || p2 >= 0){
            int s = 0, s1=0, s2=0;

            if(p1 >= 0){
                s1 = num1.charAt(p1) - '0';
                p1--;
            }
            if(p2 >= 0){
                s2 = num2.charAt(p2) - '0';
                p2--;
            }
            s = s1+s2+carry;
            if(s >= base){
                carry=1;
                s=s-base;
            }else{
                carry=0;
            }
            res.append(s);
        }
        if(carry == 1) res.append(carry);
        return res.reverse().toString();
    }
}