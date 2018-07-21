class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i =0;i<s.length();i++){
            count +=subCount(s,i,i);
            count +=subCount(s,i,i+1);
        }
        return count;
    }
    private int subCount(String s ,int i,int j){
        int count = 0;
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
}