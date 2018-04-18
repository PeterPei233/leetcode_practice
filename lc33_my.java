class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len==0) return -1;
        int half;
        int left = 0;
        int right = len-1;
        while(left<=right){
            // only one element left
            if(left==right){
                if(nums[left] == target) return left;
                else return -1;
            }
            // in the normal increasing order 
            if(nums[left]<nums[right]) return binarysearch(nums,target,left,right);
            half = (left+right)/2;
            if(nums[half]==target) return half;
            // the rotate place is in the half's right
            else if(nums[half]>=nums[left]&&target>=nums[left]&&target<nums[half]||
                // the rotate place is in the half's right.Here are two situations
              nums[half]<=nums[left]&&(target>nums[right]||(half>left&&target<nums[half]))) right = half-1;
            else left = half+1;
        }
        return -1;
    }
    public static int binarysearch(int[] nums, int target, int left, int right){
        while(left<=right){
            int half = (left+right)/2;
            if(nums[half] == target) return half;
            else if(nums[half]>target) right = half-1;
            else left = half+1;           
        }
        return -1;
    }
}