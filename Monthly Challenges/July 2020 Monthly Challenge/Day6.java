public class Day6 {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length -1] != 9) {
            digits[digits.length - 1] += 1;
            return digits;
        }
             
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] == 9) {
                digits[i] = 0;
                carry = true;
            } else {
                carry = false;
                digits[i] += 1;
                break;
            }
        }
        
        if (carry) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }   
        
        return digits;
    }
}
