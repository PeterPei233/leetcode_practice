class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res ={-1,-1};
        if(nums.length==0) return res;
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                int rleft = mid-1;
                int rright = mid+1;
                while(rleft>=0) {
                    if(nums[rleft]==target) rleft--;
                    else break;
                }
                while(rright<nums.length) {
                    if(nums[rright]==target) rright++;
                    else break;
                }
                res[0] = rleft+1; res[1] = rright-1;
                return res;
            }
            else if(target>nums[mid]) left=mid+1;
            else right = mid-1;
        }
        return  res;
    }
}