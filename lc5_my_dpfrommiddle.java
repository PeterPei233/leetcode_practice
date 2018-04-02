class Solution {
    public String longestPalindrome(String s) {
        boolean[][] flag= new boolean[s.length()][s.length()];
        int max = 1,begin = 0;
        for(int i = 0; i<s.length();i++){
            flag[i][i] = true;
        }
        for(int i = 0; i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                flag[i][i+1] = true;
                max = 2; begin = i;
            }
        }
        for(int i = 0;i<s.length();i++){
            int j = i-1;
            int k = i+1;
            int m = i+2;
            while(j>=0&&k<s.length()){
                if(flag[j+1][k-1]&&(s.charAt(j)==s.charAt(k))){
                    flag[j][k]=true;
                    if((k-j+1)>max){
                        max = k-j+1;
                        begin = j;
                    }
                    j--;k++;
                }
                else break;
            }
            j= i - 1;
            while(j>=0&&m<s.length()){
                if(flag[j+1][m-1]&&(s.charAt(j)==s.charAt(m))){
                    flag[j][m]=true;
                    if((m-j+1)>max){
                        max = m-j+1;
                        begin = j;
                    }
                    j--;m++;
                }
                else break;
            }
        }
               return s.substring(begin,max+begin);
     }
}