class Solution {
    public static String reverse(String str){  
        return new StringBuilder(str).reverse().toString();  
    }
    public static boolean ispalin(String str){ 
        int i = 0;
        while(i!=str.length()/2){
            if(str.charAt(i)!=str.charAt(str.length()-1-i))return false;
            i++;
        } 
        return true;
    }
    public String longestPalindrome(String s) {
        int[][] flag= new int[s.length()][s.length()];
        String s2 = reverse(s);
        int max = 1, begin=0;
        for(int i =0;i<s.length();i++){
            for(int j = 0;j<s.length();j++){
                if(s.charAt(i)==s2.charAt(j)){
                    if(i==0|j==0) flag[i][j]=1;
                    else{ 
                        flag[i][j] = flag[i-1][j-1]+1;
                        if(flag[i][j]>max&&ispalin(s.substring(i-flag[i][j]+1,i+1))){
                            max = flag[i][j];
                            begin = i-flag[i][j]+1;
                        }
                    }
                }
                else flag[i][j]=0;
            }
        }
        return s.substring(begin,begin+max);
     }
}