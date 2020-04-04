class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int count = (nums1.length + nums2.length)/2;
        if (count == 0) {
            return nums1.length == 0 ? nums2[0] : nums1[0];
        }
        int i = 0;
        int j = 0;
        int old = 0;
        
        int elem;
        if (nums1.length == 0 || nums2.length == 0) {
            elem = nums1.length == 0 ? nums2[0] : nums1[0];
        } else {
            elem = Math.min(nums1[0], nums2[0]);
        }
        
        for (int k = 0; k < count; k++) {
            if (i >= nums1.length) {
                j++;
                old = elem;
                elem = nums2[j];
                continue;
            }
            if (j >= nums2.length) {
                i++;
                old = elem;
                elem = nums1[i];
                continue;
            }
            
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
            old = elem;
            
            if (i >= nums1.length) {
                elem = Math.max(nums1[i-1], nums2[j]);
            } else if (j >= nums2.length) {
                elem = Math.max(nums2[j-1], nums1[i]);
            } else {
                elem = Math.min(nums1[i], nums2[j]);
            }
        }
        
        if ((nums1.length + nums2.length)%2 == 1) {
            return elem;
        } else {
            return (elem + old) / 2.0;
        }
    }
}