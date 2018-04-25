class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        return maxSub(nums,0,nums.length-1);
    }
    public static int maxSub(int[] nums,int left,int right){
        if(left==right) return nums[left];
        if(right-left==1){
            if(nums[left]>0&&nums[right]>0) return nums[left]+nums[right];
            else return nums[left]>nums[right]?nums[left]:nums[right];
        }
        int maxL = maxSub(nums, left, left+(right-left)/2);
        int maxR = maxSub(nums, left+(right-left)/2+1,right);
        int maxM = maxMid(nums,left,right);
        return maxL>maxR? maxL>maxM? maxL:maxM :maxR>maxM? maxR:maxM;
    }
    public static int maxMid(int[] nums,int left, int right){
        int mid = left+(right-left)/2;
        int curL = nums[mid];
        int curR = nums[mid+1];
        int maxL = curL, maxR = curR;
        for(int i = mid-1;i>=left;i--){
            curL = curL + nums[i];
            if(curL>maxL) maxL = curL;
        }
        for(int i = mid+2;i<=right;i++){
            curR = curR+nums[i];
            if(curR>maxR) maxR = curR;
        }
        return maxL+maxR;
    }
}
