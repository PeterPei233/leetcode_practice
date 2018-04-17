class Solution {
    public String longestCommonPrefix(String[] strs) {
        int count = 0;
        if(strs.length==0) return "";
        for(int i = 0;i<strs[0].length();i++){
            char cur = strs[0].charAt(i);
            boolean flag = true;
            for(int j = 1; j<strs.length;j++){
                if(i>=strs[j].length()||cur!=strs[j].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
            else count++;
        }
        return strs[0].substring(0,count);
    }
}