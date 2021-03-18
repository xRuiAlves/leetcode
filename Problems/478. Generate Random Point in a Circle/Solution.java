public class Solution {
    private final double radius;
    private final double x_center;
    private final double y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double vec_angle = Math.random() * 2 * Math.PI;
        double vec_modulus_factor = Math.random() + Math.random();
        double vec_modulus = (vec_modulus_factor > 1 ? 2 - vec_modulus_factor : vec_modulus_factor) * this.radius;

        double vec_x = vec_modulus * Math.cos(vec_angle);
        double vec_y = vec_modulus * Math.sin(vec_angle);

        return new double[]{
            x_center + vec_x,
            y_center + vec_y
        };
    }
}
