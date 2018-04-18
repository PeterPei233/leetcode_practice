// next permutation based on full permutation;
//from the end, find the first element which is in the decreasing 
//order, this means this elment shoule be updated, then find the next
// larger number to replace the former num, then resort the leaving nums[]

class Solution {
    public void nextPermutation(int[] nums) {
        int begin = 0;
        for(int i =nums.length-1;i>=0;i--){
             if(i==0) {
                    reverse(nums,0);
                    return;
            }
            if(nums[i]>nums[i-1]){
                begin = i-1;
                break;
            }
        }
        for(int i = begin;i<nums.length;i++){
            if(i==nums.length-1||nums[begin]>=nums[i+1]){
                int temp = nums[begin];
                nums[begin] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        reverse(nums,begin+1);
    }
    static void reverse(int[] nums,int begin){
        int end = nums.length-1;
        while(end-begin>0){
            int temp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = temp;
        }
    }
}