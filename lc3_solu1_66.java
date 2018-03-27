class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int max =1,i=0,j=0;
        HashSet<Character> x = new HashSet<>();
        int n = s.length();
        while(i<=n-max&&j<n){
            if(!x.contains(s.charAt(j))){
                x.add(s.charAt(j++));
                max = (max>=x.size())?max:x.size();
            }
            else x.remove(s.charAt(i++));
        }
        return max;
    }
}