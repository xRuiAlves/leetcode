import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<Double> p1_distances = getDistances(p1, p2, p3, p4);
        List<Double> p2_distances = getDistances(p2, p1, p3, p4);
        List<Double> p3_distances = getDistances(p3, p1, p2, p4);
        List<Double> p4_distances = getDistances(p4, p1, p2, p3);

        double square_side = p1_distances.get(0);

        return noEqualPoints(p1, p2, p3, p4)
                && square_side == p1_distances.get(1)
                && square_side == p2_distances.get(0)
                && square_side == p2_distances.get(1)
                && square_side == p3_distances.get(0)
                && square_side == p3_distances.get(1)
                && square_side == p4_distances.get(0)
                && square_side == p4_distances.get(1);
    }

    private boolean noEqualPoints(int[] p1, int[] p2, int[] p3, int[] p4) {
        return !((p1[0] == p2[0] && p1[1] == p2[1])
                || (p1[0] == p3[0] && p1[1] == p3[1])
                || (p1[0] == p4[0] && p1[1] == p4[1])
                || (p2[0] == p3[0] && p2[1] == p3[1])
                || (p2[0] == p4[0] && p2[1] == p4[1])
                || (p3[0] == p4[0] && p3[1] == p4[1])
        );
    }

    private List<Double> getDistances(int[] p1, int[] p2, int[] p3, int[] p4) {
        return Arrays.asList(
                calcDistance(p1, p2),
                calcDistance(p1, p3),
                calcDistance(p1, p4)
        ).stream().sorted().collect(Collectors.toList());
    }

    private double calcDistance(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }
}