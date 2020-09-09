import java.util.Arrays;

public class Day9 {
    public int compareVersion(String version1, String version2) {
        String[] v1_tokens = version1.split("\\.");
        String[] v2_tokens = version2.split("\\.");

        int padding = v1_tokens.length - v2_tokens.length;

        int v1_val= getVersionVal(v1_tokens);
        int v2_val= getVersionVal(v2_tokens);

        if (padding > 0) {
            v2_val *= Math.pow(10, padding);
        } else {
            v1_val *= Math.pow(10, -padding);
        }

        if (v1_val == v2_val) {
            return 0;
        }

        return v1_val > v2_val ? 1 : -1;
    }

    private int getVersionVal(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).reduce(0, (acc, curr) -> acc*10 + curr);
    }
}
