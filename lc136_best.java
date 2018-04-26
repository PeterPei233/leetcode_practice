class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1) return nums[0];
        for(int i = 1;i<nums.length;i++){
            nums[i] = nums[i]^nums[i-1];
        }
        return nums[nums.length-1];
    }
}