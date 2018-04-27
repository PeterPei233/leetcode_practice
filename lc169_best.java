class Solution {
    // suppose an element as the majority, everytime we find the 
    // same one, increase, otherwise decrease one. When count =0,
    // find a new majority. In this case,
    // we divide the array as n subarray, the number in the majority 
    // in the front array is always no more than half of the numbers
    // so in the last array, the choosen element is the majority   
    public int majorityElement(int[] nums) {
        int count = 1;
        int cur = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == cur) count++;
            else count--;
            if(count == 0) cur = nums[i+1];
        }
        return cur;
    }
}