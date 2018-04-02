class Solution {
    public int reverse(int x) {
        String y = new StringBuilder(x+"").reverse().toString();
        int begin = 0;
        while(y.charAt(begin)=='0'&&begin<y.length()-1) begin++;
        y = y.substring(begin,y.length());
        int len = y.length();
        if(y.charAt(len-1)=='-') y=("-"+y).substring(0,len);
        Long yy= Long.parseLong(y);
        return (yy>Integer.MAX_VALUE||yy<Integer.MIN_VALUE)?
            0:Integer.parseInt(y);
    }
}