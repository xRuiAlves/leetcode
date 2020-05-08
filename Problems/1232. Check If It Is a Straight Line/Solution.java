class Solution {
    private static final int MAX_SLOPE = Integer.MAX_VALUE;

    public boolean checkStraightLine(int[][] coordinates) {
        double slope = getSlope(coordinates[0], coordinates[1]);

        for (int i = 1; i < coordinates.length - 1; ++i) {
            if (getSlope(coordinates[i], coordinates[i + 1]) != slope) {
                return false;
            }
        }

        return true;
    }

    private static final double getSlope(int[] p1, int[] p2) {
        int[] vector = new int[]{
                p2[0] - p1[0],
                p2[1] - p1[1]
        };

        return vector[0] == 0 ? MAX_SLOPE : ((double)vector[1]/vector[0]);
    }
}
