class Solution {
    public int findUnsortedSubarray(int[] nums) {
       int begin = 0,min = 0,end=0,max=0;
       for(int i = 0; i<nums.length-1;i++){
           if(nums[i]>nums[i+1]) {
               begin = i+1;
               min = nums[i+1];
               break;
           }
       }
        if(begin==0) return 0;
        for(int i = begin+1;i<nums.length;i++){
            if(nums[i]<min) min = nums[i];
        }
        for(int i = 0;;i++){
            if(nums[i]>min){
                begin = i;
                break;
            } 
        }
        for(int i = nums.length-1; i>0;i--){
           if(nums[i]<nums[i-1]) {
               end = i-1;
               max = nums[i-1];
               break;
           }
       }
        for(int i = end-1;i>=0;i--){
            if(nums[i]>max) max = nums[i];
        }
        for(int i = nums.length-1;;i--){
            if(nums[i]<max){
                end = i;
                break;
            } 
        }
        return end-begin+1;
    }
}