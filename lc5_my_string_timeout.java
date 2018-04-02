class Solution {
    public String longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++) set.add(s.charAt(i));
        if(set.size()==0) return s;
        List<Integer> l1 = new LinkedList<>();
        for(int i =0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)) l1.add(i);
        }
        int max1 = (l1.size()>0)?2:0;
        int begin1 = (l1.size()>0)?l1.get(0):0;
        while(l1.size()>0){
            for(int i = 0;i<l1.size();i++){
                int k = l1.get(i);
                if(k>0&&k<s.length()-max1&&s.charAt(k-1)==s.charAt(k+max1)) l1.set(i,k-1);
                else l1.remove(l1.get(i--));
            }
            if(l1.size()==0) break;
            max1+=2;
            begin1 = l1.get(0);
        }
        for(int i =1;i<s.length()-1;i++){
            if(s.charAt(i-1)==s.charAt(i+1)) l1.add(i-1);
        }
        int max2 = (l1.size()>0)?3:1;
        int begin2 = (l1.size()>0)?l1.get(0):0;
        while(l1.size()>0){
            for(int i = 0;i<l1.size();i++){
                int k = l1.get(i);
                if(k>0&&k<s.length()-max2&&s.charAt(k-1)==s.charAt(k+max2)) l1.set(i,k-1);
                else l1.remove(l1.get(i--));
            }
            if(l1.size()==0) break;
            max2+=2;
            begin2 = l1.get(0);
        }
        int max = (max1>max2)?max1:max2;
        int begin = (max1>max2)?begin1:begin2;
        return(s.substring(begin,begin+max));
     }
}
