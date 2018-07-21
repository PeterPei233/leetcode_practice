class Solution {
    public int countSubstrings(String s) {
        int count = s.length();
        if(count>1&&s.charAt(0)==s.charAt(1)) count++;
        for(int i = 1; i<s.length()-1;i++){
            int j =i-1,k=i+1;
            while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
                count++;
                j--;
                k++;
            }
            j=i-1;k=i+2;
            if(s.charAt(i)==s.charAt(i+1)){
                count++;
                while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)) {
                    count++;
                    j--;
                    k++;
                }
            }
        }
        return count;
    }
}