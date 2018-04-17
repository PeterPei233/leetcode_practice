class Solution {
    public int romanToInt(String s) {
        int[] value = new int[24];
        value[(int)('I'-'A')] = 1;
        value[(int)('V'-'A')] = 5;
        value[(int)('X'-'A')] = 10;
        value[(int)('L'-'A')] = 50;
        value[(int)('C'-'A')] = 100;
        value[(int)('D'-'A')] = 500;
        value[(int)('M'-'A')] = 1000;
        int res = 0;
        for(int i = 0;i<s.length();i++){
            int n = (int)(s.charAt(i)-'A');
            if(i<s.length()-1&&value[n]<value[(int)(s.charAt(i+1)-'A')]) res-=value[n];
            else res+=value[n];
        }
        return res;
    }
}