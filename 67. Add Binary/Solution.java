class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        
        int iters = Math.min(a.length(), b.length());
        
        int carry = 0;
        for (int i = 0; i < iters; i++) {
            int sum = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(i)) + carry;
            
            if (sum >= 2) {
                sb.append(sum%2);
                carry = 1;
            } else {
                sb.append(sum);
                carry = 0;
            }
        }
        
        String biggest = a.length() < b.length() ? b : a;
        int extra_iters = biggest.length() - Math.min(a.length(), b.length());
        
        for (int i = iters; i < iters + extra_iters; i++) {
            if (carry == 1 && biggest.charAt(i) == '1') {
                sb.append(0);
            } else if (carry == 1 && biggest.charAt(i) == '0') {
                sb.append(1);
                carry = 0;
            } else {
                sb.append(biggest.charAt(i));
                carry = 0;
            }
        }
        
        if (carry == 1) {
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }
}
