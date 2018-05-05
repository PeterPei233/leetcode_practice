class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int [] res = Arrays.copyOf(nums,nums.length);
        Arrays.sort(res);
        int i = 0,j=nums.length-1;
        while(i<=j&&nums[i]==res[i])i++;
        if(i>j) return 0;
        while(nums[j]==res[j]) j--;
        return j-i+1;
    }
}