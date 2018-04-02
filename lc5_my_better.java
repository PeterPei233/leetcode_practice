class Solution {
    public String longestPalindrome(String s) {
        int max = 1,begin = 0;
        for(int i = 0;i<s.length();i++){
            int j = i-1;
            int k = i+1;
            while(j>=0&&k<s.length()){
                if(s.charAt(j)==s.charAt(k)){
                    if((k-j+1)>max){
                        max = k-j+1;
                        begin = j;
                    }
                    j--;k++;
                }
                else break;
            }
            j= i;k=i+1;
            while(j>=0&&k<s.length()){
                if(s.charAt(j)==s.charAt(k)){
                    if((k-j+1)>max){
                        max = k-j+1;
                        begin = j;
                    }
                    j--;k++;
                }
                else break;
            }
        }
               return s.substring(begin,max+begin);
     }
}