class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2){
            int[] temp = nums2;nums2 =nums1;nums1 = temp;
            int t = n1; n1 =n2; n2=t;
        }
        if(n1==0)  return (nums2[n2/2]+nums2[(n2-1)/2])/2.0;
        int iMin = 0, iMax = n1, len = (n1+n2+1)/2;
        while(iMin<=iMax){
            int i = (iMax+iMin)/2;
            int j = len - i;
            if(i<n1&&nums2[j-1]>nums1[i]) iMin=i+1;
            else if(i>0&&nums1[i-1]>nums2[j]) iMax=i-1;
            else{
                int left = 0,right = 0;
                if(i==0) {
                    if((n1+n2)%2==0){
                        left = nums2[j-1];
                        if(j==n2) right =nums1[0];
                        else  right = Math.min(nums1[i],nums2[j]);
                    }
                    else {
                        if(j==n2) left=right =nums2[j-1];
                        else left = right =Math.min(nums1[0],nums2[j-1]);
                    }
                }
                else if(i==n1) {
                     if((n1+n2)%2==0){
                        if(j == 0) left = nums1[i-1];
                        else left = Math.max(nums1[i-1],nums2[j-1]);
                        right = nums2[j];
                    }
                    else {
                        if(j == 0) left = right = nums1[i-1];
                        else  left = right=Math.max(nums1[i-1],nums2[j-1]);
                    }
                }
                else{
                     if((n1+n2)%2==0){
                        left = Math.max(nums1[i-1],nums2[j-1]);
                        right = Math.min(nums1[i],nums2[j]);
                    }
                    else left = right = Math.max(nums1[i-1],nums2[j-1]);
                }
                return (left+right)/2.0;
            }           
        }
        return 0.0;
    }
}