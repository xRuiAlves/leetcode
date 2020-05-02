class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {            
            int diff1 = i + 1;
            int diff2 = numRows - diff1 + 1;
            if (diff1 == 1) {
                diff2 = diff1;
            } else if (diff2 == 1) {
                diff1 = diff2;
            }
            for (int j = i, v=0; j < s.length(); j+=((numRows-((v%2==0) ? diff1 : diff2))*2), v++) {
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }
    
    
}