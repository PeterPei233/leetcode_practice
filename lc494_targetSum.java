class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[] res = new int[2001];
        res[nums[0]+1000] = 1;
        res[-nums[0]+1000]+=1;
        for(int i = 1;i<nums.length;i++){
            int next[] = new int[2001];
            for(int j = 0;j<2001;j++){
                if(res[j]>0){
                    next[j+nums[i]]+=res[j];
                    next[j-nums[i]]+=res[j];
                }
            }
            res = next;
        }
        return (S>1000||S<-1000)? 0:res[S+1000];
    }  
}