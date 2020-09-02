class Solution {
    public String largestTimeFromDigits(int[] A) {
        List<Integer> nums = new LinkedList<>();
        
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    for (int l = 0; l < 4; ++l) {
                        if (i != j && i != k && i != l && j != k && j != l && k != l) {
                            nums.add(A[i]*1000 + A[j]*100 + A[k]*10 + A[l]);
                        }
                    }
                }
            }
        }
        
        Collections.sort(nums, (n1, n2) -> n2 - n1);
        
        for (int num : nums) {
            String formatted_num = formatNum(num);
            if (!formatted_num.isBlank()) {
                return formatted_num;
            }
        }
        
        return "";
    }
    
    private String formatNum(int num) {
        int hh = num / 100;
        int mm = num % 100;
        
        if (!((hh < 24) && (mm < 60))) {
            return "";
        }
        
        return String.format("%02d:%02d", hh, mm);
    }
}
