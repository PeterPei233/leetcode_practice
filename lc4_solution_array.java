class Solution {
    // Algoriths: two pointer approach(based on greedy algorithm)
    // From the two sides, culculate the area and compare with max
    // then remain the longer one, replace the other one with the 
    // line next to it, loop until the last two lines are close 
    // to each other
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j  = height.length-1;
        while(i!=j){
            if(height[i]>height[j]) max = Math.max(max,(j-i)*height[j--]);
            else max = Math.max(max,(j-i)*height[i++]);
        }
        return max;
    }
}