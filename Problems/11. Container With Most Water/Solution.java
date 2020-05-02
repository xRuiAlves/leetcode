class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int max_area = Integer.MIN_VALUE;
        while (l < r) {
            int new_area =  Math.min(height[r], height[l]) * (r - l);
            max_area = Math.max(new_area, max_area);

            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        
        return max_area;
    }
}